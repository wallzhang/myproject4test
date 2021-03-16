package com.wall.myproject4test.leedcode.movezero;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + ",");
        }
    }
    public static void moveZeroes(int[] nums) {
        int index1 = 0;
        int index2;
        for (int i = 0; i < nums.length; i++) {
            index2 = 0;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] != 0){
                    index1++;
                    index2 = nums[j];
                    nums[j] = 0;
                    break;
                }
            }
            nums[i]=index2;
        }
//        for (int i = nums.length - index1+1; i < nums.length; i++) {
//            nums[i] = 0;
//        }
    }
}
