package com.wall.myproject4test.spring.transaction4study.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
* @Description: 切面
* @Author: zhang.zw
* @Date: 2020/12/29
*/
@Aspect
@Component
public class WallAspectj {

    @Before("@annotation(com.wall.myproject4test.spring.transaction4study.annotation.WallTx)")
    public void beforeAspectj(){

    }
}
