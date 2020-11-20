package com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* @Description: 自动注入，
* @Author: zhang.zw
* @Date: 2020/11/17
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WallAutowired {
    String value() default "";
}
