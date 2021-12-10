package com.wall.myproject4test.leedcode.offer092;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang.StringUtils;
//import net.sf.json.JSONArray;
//import org.json.JSONArray;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Description: 剑指 Offer II 092. 翻转字符
 * 如果一个由'0' 和 '1'组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * 我们给出一个由字符 '0' 和 '1'组成的字符串 s，我们可以将任何'0' 翻转为'1'或者将'1'翻转为'0'。
 * 返回使 s单调递增的最小翻转次数。
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * @Author: zhang.zw
 * @Date: 2021/11/29
 */
public class Solution {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList(new String[]{"1.1.1.1","2.2.2.2"}));
        System.out.println(JSON.toJSONString(set));
        System.out.println(JSON.toJSONString(new HashSet<>()));
        System.out.println(JSONArray.parseArray(JSON.toJSONString(set)));
//        String ip =
//        System.out.println(LocalDate.now());
//        String str = "[\"1.1.1.1\",\"1.1.1.1\",\"2.2.2.2\"]";
//        Set<String> set = JSONArray.parseObject(str,Set.class);
//        List list = new ArrayList();
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        Set<Integer> set = new HashSet(list);
//        System.out.println(set);
//        set.forEach(item->{
//            System.out.println(item);
//        });
//
//        String str2 = "[]";
//        Set<String> set2 = JSONArray.parseObject(str2,Set.class);
//        System.out.println(set2);
//        System.out.println(set2.size());
//        System.out.println(StringUtils.isNotBlank(str2));
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:00");
//        System.out.println(LocalDateTime.now().format(df));
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("a","45.0021231232342343423");
//        jsonObject.put("b","42");
//        jsonObject.put("c",null);
//        jsonObject.put("d",42);
////        System.out.println(Optional.ofNullable(jsonObject.getDouble("c")).orElse(0.0).intValue());
////        System.out.println(jsonObject.getDouble("a").intValue());
//        System.out.println(jsonObject.getString("d"));
//        String str = String.format("%.3f",Double.parseDouble(jsonObject.getString("a")));
//        Double c = Double.parseDouble(str);
//        System.out.println(c);
//
//        BigDecimal bd = new BigDecimal("3.14659265");
//
//        bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);

//        System.out.println(bd.toString());
//        System.out.println(jsonObject.);
//        System.out.println(jsonObject.getDouble("b").intValue());
//        System.out.println(jsonObject.getIntValue("b"));
//        System.out.println(jsonObject.getString("c"));
//        System.out.println(jsonObject.getInteger("c"));
//        System.out.println(jsonObject.getIntValue("c"));
//        int index = 0;
//        for (int i = 0; i < 10; i++) {
//            index++;
//        }
//        System.out.println(index);
    }

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int indexOf1 = 0;
        // 找到第一个1的位置
        for (int i = 0; i < chars.length; i++) {
            if(i==0){
                continue;
            }
            if(i>0&&i<chars.length-1){
                if(chars[i-1]==chars[i]){
                    
                }
            }
        }
        return 0;
    }
}
