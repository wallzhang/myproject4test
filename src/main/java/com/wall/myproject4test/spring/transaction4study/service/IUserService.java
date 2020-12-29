package com.wall.myproject4test.spring.transaction4study.service;


import com.wall.myproject4test.spring.transaction4study.model.WallDemo;

import java.util.List;

/**
* @Description:
* @Author: zhang.zw
* @Date: 2020/12/29
*/
public interface IUserService {

    /**
     * 查询wall_demo表
     * @return
     */
    public List<WallDemo> queryWallDemoAll();

    /**
     * 插表操作
     * @param wallDemo
     */
    public void insertWallDemo(WallDemo wallDemo);
}
