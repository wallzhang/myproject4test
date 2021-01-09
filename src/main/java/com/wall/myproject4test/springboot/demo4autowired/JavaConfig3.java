package com.wall.myproject4test.springboot.demo4autowired;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/** 
* @Description:
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
public class JavaConfig3 implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 将我们需要添加的类型统一封装为RootBeanDefinition对象
        RootBeanDefinition user4springboot = new RootBeanDefinition(User4springboot.class);
        beanDefinitionRegistry.registerBeanDefinition("user4springboot",user4springboot);
    }
}
