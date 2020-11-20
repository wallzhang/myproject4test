package com.wall.myproject4test.java.zzw.spring4test.ioc2di.content;


import com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno.WallAutowired;
import com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno.WallComponent;
import com.wall.myproject4test.java.zzw.spring4test.ioc2di.service.WallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
* @Description:设计的上下文类
* @Author: zhang.zw
* @Date: 2020/11/17
*/
public class WallApplicationContent {

    private static Logger logger = LoggerFactory.getLogger(WallApplicationContent.class);
    private static ConcurrentHashMap<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    private static Set< Class<?>> classNames = new HashSet<>();

    public WallApplicationContent(String packageName) throws Exception {

        // 内置一个初始化函数
        initContent(packageName);
    }

    private void initContent(String packageName) throws Exception {
        // 预先进行包扫描
        scanPackage(packageName);
        if(logger.isInfoEnabled()){
            logger.info("classNames:"+classNames);
        }
        // 初始化IOC
        initIoc();
        // 初始化DI
        initDI();
    }
    private void initDI() throws IllegalAccessException, InstantiationException {
        // DI初始化
        if(ioc.size()==0){
            if(logger.isInfoEnabled()){
                logger.info("容器内不含有实例");
            }
            return;
        }
        Iterator iterator = ioc.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry =(Map.Entry) iterator.next();
//            Class clazz = (Class) entry.getValue();
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field:fields){
                if(field.isAnnotationPresent(WallAutowired.class)){

                    // 非public属性都需要设置
                    field.setAccessible(true);
//                    String f = field.getType().getSimpleName();
//                    Object= ioc.get(field.getName()) ;
//                    Class clazz2 = ioc.get("wallTestDao") ;
//                    Object object = clazz.newInstance();
//                    Object object2 = clazz2.newInstance();
//                    entry.getValue();
                    field.set(entry.getValue(),ioc.get(field.getName()));
                }
            }
        }
    }
    private void initIoc(){

        // ioc初始化
        // 对classNames内的类做处理,如果类包含有WallComponent注解则注入到ioc容器中
        classNames.forEach(item->{
                try {
                    // 获取类内的自定义注解
                    WallComponent anno = item.getAnnotation(WallComponent.class);
                    if(anno != null){
                        // 首字母小写
                        String simpleName = item.getSimpleName();
                        String finalClazzName = simpleName.substring(0,1).toLowerCase()+simpleName.substring(1);
                        ioc.put(finalClazzName,item.newInstance());
                        // todo 额外 处理下存在接口的情况
                        for (Class<?> i : item.getInterfaces()) {
                            if(ioc.containsKey(i.getName())){
                                throw new Exception("The " + i.getName() + " is exists!!");
                            }
                            String interfName = i.getSimpleName();
                            ioc.put(String.valueOf(interfName.charAt(0)).toLowerCase()+interfName.substring(1),item.newInstance());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });
    }

    private void scanPackage(String pageName) throws Exception {
        String packageDirName = pageName.replace('.', '/');
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        while (dirs.hasMoreElements()) {
            // 获取下一个元素
            URL url = dirs.nextElement();
            // 得到协议的名称
            String protocol = url.getProtocol();
            // 如果是以文件的形式保存在服务器上
            if ("file".equals(protocol)) {
                // 获取包的物理路径
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                findAndAddClassesInPackageByFile(pageName,filePath);
            }
        }
    }

    public static void findAndAddClassesInPackageByFile(String packageName,
                                                        String packagePath) throws ClassNotFoundException {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            @Override
            public boolean accept(File file) {
                return (true && file.isDirectory())
                        || (file.getName().endsWith(".class"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "."
                                + file.getName(), file.getAbsolutePath());
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0,
                        file.getName().length() - 6);
                // 添加到集合中去
                // 用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                classNames.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
//                classNames.add(packageName + '.' + className);
            }
        }
    }

    private  <T> T getBean(String name){

        return (T) ioc.get(name);
    }

//    private Object getBean(String name){
//        return ioc.get(name);
//    }
    public static void main(String[] args) throws Exception {
        WallApplicationContent content = new WallApplicationContent("com.wall.myproject4test.java.zzw.spring4test.ioc2di");
        WallService wallService =  content.getBean("wallService");
        wallService.say();
        System.out.println("-------------------");
        wallService.say2();
    }
}