package com.wall.myproject4test.spring.transaction4study.dao;


import com.wall.myproject4test.spring.transaction4study.model.WallDemo;

import java.util.List;

/**
* @Description: 持久层
* @Author: zhang.zw
* @Date: 2020/12/29 
*/
public interface IUserDao {

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

    /**
     * 插表操作
     * @param wallDemo
     */
    public void insertWallDemo2(WallDemo wallDemo);
}
