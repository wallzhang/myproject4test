package com.wall.myproject4test.java.zzw.spring4test.ioc2di.service;

import com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno.WallAutowired;
import com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno.WallComponent;
import com.wall.myproject4test.java.zzw.spring4test.ioc2di.dao.WallTestDao;
import com.wall.myproject4test.java.zzw.spring4test.ioc2di.dao.WallTestDaoImpl;


/**
* @Description: 测试
* @Author: zhang.zw
* @Date: 2020/11/18
*/
@WallComponent
public class WallService {

    @WallAutowired
    WallTestDao wallTestDao;

    public void say(){
        System.out.println("wall在WallService 上执行了say方法！！ ");
    }

    public void say2(){
        wallTestDao.say();
    }
}
