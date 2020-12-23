package com.wall.myproject4test.spring.ioc4study.factory;

import com.wall.myproject4test.spring.ioc4study.model.UserDemo;

import java.util.HashMap;
import java.util.Map;


/** 
* @Description: 静态工厂 
* @Author: zhang.zw
* @Date: 2020/12/24 
*/
public class StaticFactoryDemo {
    public static Map<String, UserDemo> hashMap ;

    static {
        hashMap = new HashMap<String, UserDemo>();
        hashMap.put("a1",new UserDemo());
        hashMap.put("a2",new UserDemo());
        hashMap.put("a3",new UserDemo());
    }

    /**
     * 静态工厂提供的方法
     * @return
     */
    public static UserDemo getInstance(){
        return hashMap.get("a1");
    }
}
