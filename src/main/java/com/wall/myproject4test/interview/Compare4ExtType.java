package com.wall.myproject4test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/** 
* @Description: question2 重写比较器
* @Author: zhang.zw
* @Date: 2021/1/15 
*/
public class Compare4ExtType implements Comparator< Extension > {
    static String[] sortType = {"User","Dept","AO","TMO","Other"};
    static List list = new ArrayList();
    static {
        list = Arrays.asList(sortType);
    }

    @Override
    public int compare(Extension o1, Extension o2) {
        // 算出o1和o2的排序顺序
        int index1 = 0;
        if(list.contains(o1.getExtType())){
            index1 = list.indexOf(o1.getExtType());
        }else {
            index1 = list.size();
        }
        int index2 = 0;
        if(list.contains(o2.getExtType())){
            index2 = list.indexOf(o2.getExtType());
        }else {
            index2 = list.size();
        }

        if(index1 == index2){
            return 0;
        }else if(index1 < index2){
            return -1;
        }else {
            return 1;
        }

    }
}
