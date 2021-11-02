package com.wall.myproject4test.leedcode.TupleWithSameProduct;


import java.util.HashMap;
import java.util.Map;

/**
* @Description: 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
* @Author: zhang.zw
* @Date: 2021/11/1
*/
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        int res = tupleSameProduct(nums);
        System.out.println(res);
    }
    public static int tupleSameProduct(int[] nums) {
       int ans = 0;
       Map<Integer, Integer> checks = new HashMap<>();
       Integer count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int key = nums[i]*nums[j];
                count = checks.get(key);
                if (count !=null) {
                    ans+=count;
                    count++;
                }else {
                    count = 1;
                }
                checks.put(key, count);
            }
        }
        return ans<<3;
    }
}
