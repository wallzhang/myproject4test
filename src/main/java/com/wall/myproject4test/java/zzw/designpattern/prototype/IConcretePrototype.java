package com.wall.myproject4test.java.zzw.designpattern.prototype;


import lombok.Data;

import java.io.*;
import java.util.List;

/**
* @Description:拷贝原型
* @Author: zhang.zw
* @Date: 2021/3/21
*/
@Data
public class IConcretePrototype implements Cloneable{

    /**
     * 年龄
     */
    Integer age;

    /**
     * 姓名
     */
    String name;

    /**
     * 爱好
     */
    List<String> hobbies;

    @Override
    public IConcretePrototype clone() {
        try {
            return (IConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public IConcretePrototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (IConcretePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
