package com.wall.myproject4test.test;


import io.micrometer.core.instrument.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 给5位数  0<= x <=99999
 * 1.输出共几位
 * 2.输出每位的值（sout打印就行）
 * 3.翻转值输出，如输入234，输出432
 * @Author: zhang.zw
 * @Date: 2021/10/20
 */
public class Code1 {
    static String[] flags = {"个位", "十位", "百位", "千位", "万位"};

    public static void main(String[] args) {
//        double a = -0.3;
//        a -= 0.03;
//        System.out.println(Double.valueOf(a));
//        System.out.println(String.valueOf(a));
//        System.out.println(String.format("%.2f",a));
//        int num = 68721;
//        dealInt(num);
//        String name = "";
//        Map<String, Object> tes = new HashMap<>();
//        System.out.println(tes.get("name")==null);
//        System.out.println(String.valueOf(tes.get("name")));
//        System.out.println(StringUtils.isNotBlank(String.valueOf(tes.get("name"))));
//        System.out.println(tes.get("name")==null);
//        tes.put("name",name);
//        System.out.println(tes.get("name")=="");
        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        List<Map<String, String>> objects = new ArrayList<>();
        objects.add(map);
        System.out.println(objects);
        System.out.println(objects.toString());
    }

    private static void dealInt(int num) {
        int initNum = num;
        // 默认至少0位
        int size = 0;
        // 使用数组依次存储每位的值
        List<Integer> list = new ArrayList<>();
        while (num >= 1) {
            size++;
            list.add(num % 10);
            num = num / 10;
        }
        System.out.println(String.format("输入数字%s共计%s位", initNum, size));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("输入数据%s是%s", flags[i], list.get(i)));
        }
        int resultNum = 0;
        int index = size - 1;

        while (index >= 0) {
            resultNum += list.get(index) * Math.pow(10, index);
            index--;
        }
        System.out.println(String.format("翻转数据的结果是%s", resultNum));
    }
}
