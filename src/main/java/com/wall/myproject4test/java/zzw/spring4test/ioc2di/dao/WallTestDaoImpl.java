package com.wall.myproject4test.java.zzw.spring4test.ioc2di.dao;

import com.wall.myproject4test.java.zzw.spring4test.ioc2di.anno.WallComponent;


/** 
* @Description: 测试
* @Author: zhang.zw
* @Date: 2020/11/18 
*/
@WallComponent
public class WallTestDaoImpl implements WallTestDao{
    @Override
    public void say() {
        System.out.println("wall 在WallTestDaoImpl上使用了say方法！！！");
    }
}
