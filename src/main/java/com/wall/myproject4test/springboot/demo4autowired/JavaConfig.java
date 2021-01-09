package com.wall.myproject4test.springboot.demo4autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
* @Description: 测试类
* @Author: zhang.zw
* @Date: 2021/1/9
*/
@Configuration
@Import(User4springboot.class)
public class JavaConfig {

//    @Bean
//    public  User4springboot user4springboot(){
//        return new User4springboot();
//    }
}
