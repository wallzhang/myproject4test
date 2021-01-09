package com.wall.myproject4test.springboot.demo4autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/** 
* @Description: implements ImportSelector  
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
public class JavaConfig2 implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{User4springboot.class.getName()};
    }
}
