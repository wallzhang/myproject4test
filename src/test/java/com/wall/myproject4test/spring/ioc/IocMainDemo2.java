package com.wall.myproject4test.spring.ioc;

import org.apache.naming.factory.BeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class IocMainDemo2 {



    /**
    * @Description: ApplicationContent初始化
     * 加载阶段就好初始化化所有的javaBean
    * @Author: zhang.zw
    * @Date: 2020/12/22
    */
    @Test
    public void fun1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * @Description: beanFactory初始化
     * IOC容器在初始化节点不会实例化类，调用时候才会实例化类
     * @Author: zhang.zw
     * @Date: 2020/12/22
     */
    @Test
    public void fun2(){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        beanFactory.getBean("user1");
    }
}
