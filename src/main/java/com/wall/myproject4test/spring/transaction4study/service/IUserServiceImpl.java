package com.wall.myproject4test.spring.transaction4study.service;


import com.wall.myproject4test.spring.transaction4study.dao.IUserDao;
import com.wall.myproject4test.spring.transaction4study.model.WallDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 业务类
* @Author: zhang.zw
* @Date: 2020/12/29
*/
@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    IUserDao iUserDao;

    @Override
    public List<WallDemo> queryWallDemoAll() {
        return iUserDao.queryWallDemoAll();
    }

    @Override
    public void insertWallDemo(WallDemo wallDemo) {
        iUserDao.insertWallDemo(wallDemo);
    }

}
