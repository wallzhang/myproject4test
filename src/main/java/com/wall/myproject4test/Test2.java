package com.wall.myproject4test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.xml.soap.SOAPMessage;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {
    static String str = "{ \"size\":8, \"data\":[[ \"12-09\",359639],[\"12-10\",11622314],[\"12-11\",11045943],[ \"12-12\",12876459],[ \"12-13\",150789261],[ \"12-14\",10837049], [\"12-15\",9914112],[ \"12-16\",8399282 ]], \"columnList\":[{\"name\": \"time\",\"alias\":\"time\"},{\"name\":\"防火墙Deny数\", \"alias\":\"name\"}] }";
    public static void main(String[] args) {
        String chartName = "近7日攻击态势分析-防火墙deny";
        Map<String, Integer> netIpMap = new HashMap<>();
        Map<String, Integer> forbidIpMap = new HashMap<>();
        Map<String, Integer> denyMap = new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(str);
        // json处理后存入result
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONArray columnListJsonArray = jsonObject.getJSONArray("columnList");
        boolean hasBanIp = false;
        boolean hasNetIp = false;
        boolean hasDeny = false;
        for (int j = 0; j < columnListJsonArray.size(); j++) {
            String name = columnListJsonArray.getJSONObject(j).getString("name");
            System.out.println(name);
            if ("互联网IP数".equals(name)) {
                hasNetIp = true;
            } else if ("封禁IP数".equals(name)) {
                hasBanIp = true;
            } else if ("防火墙Deny数".equals(name)) {
                hasDeny = true;
            }
        }
        if ("折线图-封禁IP数&互联网IP数".equals(chartName)) {
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONArray jsonArray2 = jsonArray.getJSONArray(j);
                if (hasNetIp && hasBanIp) {
                    netIpMap.put(jsonArray2.getString(0), jsonArray2.getInteger(1));
                    forbidIpMap.put(jsonArray2.getString(0), jsonArray2.getInteger(2));
                } else if (hasNetIp && !hasBanIp) {
                    netIpMap.put(jsonArray2.getString(0), jsonArray2.getInteger(1));
                } else if (!hasNetIp && hasBanIp) {
                    forbidIpMap.put(jsonArray2.getString(0), jsonArray2.getInteger(1));
                }
            }
        } else if ("近7日攻击态势分析-防火墙deny".equals(chartName)) {
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONArray jsonArray2 = jsonArray.getJSONArray(j);
                if (hasDeny) {
                    denyMap.put(jsonArray2.getString(0), jsonArray2.getInteger(1));
                }
            }
        }
        System.out.println(denyMap);
        System.out.println("1111");
    }

    private static class TestInt {
        private Integer[][] integers;

        public Integer[][] getIntegers() {
            return integers;
        }

        public void setIntegers(Integer[][] integers) {
            this.integers = integers;
        }
    }
//    private static JSONObject TestJson(JSONObject t1) {
//        JSONObject t2 = new JSONObject();
//        t2.put("age", 18);
//        t1 = t2;
//        return t1;
//    }

    public int test() {
        int[] nums = {1, 6, 74};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        AtomicInteger res = new AtomicInteger();
        map.forEach((key, value) -> {
            if (value == 1) {
                res.set(key);
            }
        });
        return res.get();
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 思路合并数组
        int[] arr = new int[nums1.length + nums2.length];
        boolean isDouble = false;
        double arrRes = 0;
        // num1和num2 的长度为空是特殊情况需要单独处理
        if (nums1.length == 0) {
            // 取num2的中位结果
            isDouble = isPowerOfTwo(nums2.length);
            if (!isDouble) {
                arrRes = (double) nums2[nums2.length / 2];
            } else {
                arrRes = ((double) nums2[nums2.length / 2] + (double) nums2[nums2.length / 2 - 1]) / 2;
            }
            return arrRes;
        }
        if (nums2.length == 0) {
            // 取num1的中位结果
            isDouble = isPowerOfTwo(nums1.length);
            if (!isDouble) {
                arrRes = (double) nums1[nums1.length / 2];
            } else {
                arrRes = ((double) nums1[nums1.length / 2] + (double) nums1[nums1.length / 2 - 1]) / 2;
            }
            return arrRes;
        }
        // 处理完后进行合并处理
        int index1 = 0;
        int index2 = 0;
        int indexArr = 0;
        while (indexArr < arr.length) {
            if (nums1[index1] <= nums2[index2]) {
                arr[indexArr] = nums1[index1];
                index1++;
                indexArr++;
                if (index1 == nums1.length) {
                    // nums1数组复制完毕
                    System.arraycopy(nums2, index2, arr, indexArr, arr.length - indexArr);
                    // 跳出
                    break;
                }
            } else {
                arr[indexArr] = nums2[index2];
                index2++;
                indexArr++;
                if (index2 == nums2.length) {
                    // nums2数组进行复制
                    System.arraycopy(nums1, index1, arr, indexArr, arr.length - indexArr);
                    // 跳出
                    break;
                }
            }
        }
        // 获取判断最终数组的单双数
        isDouble = isPowerOfTwo(arr.length);

        if (!isDouble) {
            arrRes = (double) arr[arr.length / 2];
        } else {
            arrRes = ((double) arr[arr.length / 2] + (double) arr[arr.length / 2 - 1]) / 2;
        }
        return arrRes;
    }
}
