package com.wall.myproject4test.springboot.demo4autowired;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
* @Description: 自定义注解
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JavaConfig2.class)
public @interface WallImportConfig {
}
