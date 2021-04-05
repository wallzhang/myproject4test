package com.wall.myproject4test.java.zzw.designpattern.prototype;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @Description: 原型模式测试类
* @Author: zhang.zw
* @Date: 2021/3/21 
*/
public class ConcretePrototypeClient {

    public static void main(String[] args) {
        IConcretePrototype model = new IConcretePrototype();
        model.setAge(18);
        model.setName("wall");
        List<String> hobbies = new ArrayList();
        hobbies.add("basketball");
        hobbies.add("coding");
        model.setHobbies(hobbies);

        IConcretePrototype model2 = model.clone();
        hobbies.add("movie");
        model2.setHobbies(hobbies);

        IConcretePrototype model3 = model.deepClone();
//        hobbies.add("running");
//        model3.setHobbies(hobbies);

        System.out.println(model);
        System.out.println(model2);
        System.out.println(model3);
    }
}
