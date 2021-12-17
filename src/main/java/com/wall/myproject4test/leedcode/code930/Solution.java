package com.wall.myproject4test.leedcode.code930;


/**
 * @Description: 930.给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * @Author: zhang.zw
 * @Date: 2021/12/10
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int total = 0;
            for (int j = i; j < nums.length; j++) {
                total += nums[j];
                if (total < goal) {
                    continue;
                } else if (total == goal) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
