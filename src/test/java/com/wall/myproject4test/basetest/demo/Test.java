package com.wall.myproject4test.basetest.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    static {
        age = 17;
    }
    static int age ;
    public static void main(String[] args) {

        Stack stack = new Stack();
        List list = new ArrayList();
        list.sort(Comparator.comparingInt(Integer::intValue));
        char[] chars = "{hello}".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

    }

    private int[] res(){
        int[] ints = {1,2};
        return ints;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        int[] res = new int[2];
        for (int j = 0; j < nums.length; j++){
            if(map.containsKey(target - nums[j])){
                res[0] = j;
                res[1] = map.get(target - nums[j]);
                break;
            }
        }
        return res;
    }
}
