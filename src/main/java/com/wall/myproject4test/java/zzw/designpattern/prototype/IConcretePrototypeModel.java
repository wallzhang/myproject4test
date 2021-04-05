package com.wall.myproject4test.java.zzw.designpattern.prototype;


import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
* @Description:拷贝原型
* @Author: zhang.zw
* @Date: 2021/3/21
*/
@Data
public class IConcretePrototypeModel implements Cloneable{

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
    public IConcretePrototypeModel clone() {
        try {
            return (IConcretePrototypeModel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public IConcretePrototypeModel deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (IConcretePrototypeModel) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
