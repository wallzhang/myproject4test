package com.wall.myproject4test.leedcode.binarySearch;


/** 
* @Description: 153题 leedcode 查询旋转数组的最小值
* @Author: zhang.zw
* @Date: 2021/1/5 
*/
public class BinarySearchMinDemo {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println("min:" + searchMin2(nums));
    }

    
    /** 
    * @Description: 时间复杂度O(n)不一定
    * @Author: zhang.zw
    * @Date: 2021/1/5 
    */
    public int searchMin(int[] nums){
        // 借助标识位来判断循环一次就能得到结果
        if(nums == null && nums.length == 0){
            return -1;
        }
        int flag = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(flag > nums[i]){
                flag = nums[i];
            }
        }
        return flag;
    }

    /**
     * 通过二分进行查询
     * @param nums
     * @return
     */
    public static int searchMin2(int[] nums){
        if(nums == null && nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length -1;
        int target = nums[end];
        while (start + 1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid] <= target){
                end = mid;
            }else {
                start = mid;
            }
        }
        return Math.min(nums[start],nums[end]);
    }
}
