package com.wall.myproject4test;

import com.wall.myproject4test.java.zzw.inf4demo.io.MySwaggerInf4Io;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.*;

@SpringBootTest
class MyProject4testApplicationTest implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        getBean();
//        Map map = new HashMap();
//        map.put("a","1");
//        map.put("b","2");
//        System.out.println(map);
//        System.out.println("--------------------");
//        String str = JSON.toJSONString(map);
//        Map map2 = JSON.parseObject(str, HashMap.class);
//        System.out.println(map2);
    }

    void getBean(){
        MySwaggerInf4Io mySwaggerInf4Io = applicationContext.getBean(MySwaggerInf4Io.class);
        MySwaggerInf4Io mySwaggerInf4Io2 = applicationContext.getBean(MySwaggerInf4Io.class);
        System.out.println(mySwaggerInf4Io);
        System.out.println(mySwaggerInf4Io2);
    }

    void showDetail (String str){
        String[] strs = str.split(",");
        List<String> list1 = Arrays.asList(strs);
        list1.forEach(item2->{
            System.out.println("item2:" + item2);
        });
    }
    void add(int i){
        i+=1;
        System.out.println("i:"+i);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(MyProject4testApplicationTest.applicationContext == null) {
            MyProject4testApplicationTest.applicationContext = applicationContext;
        }
    }
}
