package com.wall.myproject4test.java.zzw.inf4demo;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:个人定制接口demo类
 * @author: zhang.zw
 * @date: 2020/10/22 8:31
 **/
@Api(description = "个人定制接口")
@RestController
@RequestMapping("/myInf4fun")
public class MySwaggerInf4Demo {
    private static Logger logger = LoggerFactory.getLogger(MySwaggerInf4Demo.class);


}
