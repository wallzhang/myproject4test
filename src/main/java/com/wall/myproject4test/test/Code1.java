package com.wall.myproject4test.test;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import io.micrometer.core.instrument.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

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
        Map<String,Integer> mapRepeat = new HashMap<>();
        mapRepeat.put("aa", 1);
        mapRepeat.put("bb", 45);
        mapRepeat.put("cc", 32);
        mapRepeat.put("dd", 226);
        mapRepeat.put("ee", 16);
        mapRepeat.put("ff", 320);
        mapRepeat.put("gg", 99);
        final Map<String, Integer> sortedByCount1 = mapRepeat.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(JSON.toJSONString(sortedByCount1));
        Iterator<Map.Entry<String, Integer>> iterator = sortedByCount1.entrySet().iterator();
        int index = 0;
        List<String> list = new ArrayList<>();
        while (iterator.hasNext()&&index<5){
            Map.Entry<String, Integer> next = iterator.next();
            list.add(next.getKey());
            index++;
        }
        System.out.println(list);
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
