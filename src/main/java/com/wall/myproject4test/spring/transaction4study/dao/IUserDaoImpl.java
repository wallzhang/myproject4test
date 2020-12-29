package com.wall.myproject4test.spring.transaction4study.dao;

import com.wall.myproject4test.spring.transaction4study.model.WallDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
* @Description:
* @Author: zhang.zw
* @Date: 2020/12/29
*/
@Repository
public class IUserDaoImpl implements IUserDao{

    private static Logger logger = LoggerFactory.getLogger(IUserDao.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<WallDemo> queryWallDemoAll() {
        String sql = "SELECT * FROM WALL_DEMO";
        List<WallDemo> list = jdbcTemplate.query(sql, new RowMapper<WallDemo>() {
            @Override
            public WallDemo mapRow(ResultSet resultSet, int i) throws SQLException {
                WallDemo wallDemo = new WallDemo();
                wallDemo.setId(resultSet.getInt("id"));
                wallDemo.setAge(resultSet.getInt("age"));
                wallDemo.setName(resultSet.getString("name"));
                return wallDemo;
            }
        });
        return list;
    }

    @Override
    public void insertWallDemo(WallDemo wallDemo) {
        String sql = "INSERT INTO WALL_DEMO (ID,NAME,AGE) VALUES (?,?,?)";

        int res = jdbcTemplate.update(sql,wallDemo.getId(),wallDemo.getName(),wallDemo.getAge());
        if(logger.isInfoEnabled()){
            logger.info("res:" + res);
        }
    }
}
