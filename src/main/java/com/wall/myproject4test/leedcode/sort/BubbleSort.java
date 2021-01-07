package com.wall.myproject4test.leedcode.sort;


/**
* @Description: 冒泡排序。时间复杂度O（n2）
* @Author: zhang.zw
* @Date: 2021/1/6
*/
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1,6,3,2,8,7};
        int[] res = bubbleSortArr(nums);
        System.out.println("-------------");
        for (int num: res) {
            System.out.print(num);
            System.out.print("->");
        }
    }

    public static int[] bubbleSortArr(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                int k = j-1;
                if(nums[k] > nums[j]){
                    // swap1都可以的
                    // int temp = nums[j];
                    // nums[j] = nums[k];
                    // nums[k] = temp;
                    // swap2
                    nums[k] = nums[k] + nums[j];
                    nums[j] = nums[k] - nums[j];
                    nums[k] = nums[k] - nums[j];
                }
            }
        }
        return nums;
    }
}
