package com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* @Description:组件注解
* @Author: zhang.zw
* @Date: 2020/11/17
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WallComponent {
}
