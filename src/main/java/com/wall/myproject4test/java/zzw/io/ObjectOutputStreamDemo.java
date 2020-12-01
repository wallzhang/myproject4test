package com.wall.myproject4test.java.zzw.io;


import com.wall.myproject4test.java.zzw.io.dto.User;

import java.io.*;

/**
* @Description: 序列化对象，和反序列化对象
* @Author: zhang.zw
* @Date: 2020/12/2 
*/
public class ObjectOutputStreamDemo {

    public static void main(String[] args) {
//        User user = new User("zzw",18);
//        // 序列化
//        try(ObjectOutputStream objectOutputStream =
//                    new ObjectOutputStream(new FileOutputStream("D://user"))) {
//            objectOutputStream.writeObject(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 反序列化
        try(ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("D://user"))) {
           User user1 =  (User) objectInputStream.readObject();
            System.out.println(user1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
