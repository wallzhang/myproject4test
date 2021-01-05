package com.wall.myproject4test.leedcode.binarySearch;


import java.util.HashMap;
import java.util.Map;

/**
* @Description: leedcode 33题目
* @Author: zhang.zw
* @Date: 2021/1/5 
*/
public class BinarySerach33Demo {


    public static void main(String[] args) {

    }

    /**
     * 借助hashMap处理.不推荐使用，效率偏低
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        return -1;

    }

    /**
     * foreach遍历查找，时间复杂度O(n)
     * for(int i = 0; i < nums.length; i++){
     *     if(nums[i] ==  target){
     *         return i;
     *     }
     * }
     * return -1
     */
    /**
     * 基于二分查找编写,最优解
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[start] < nums[mid] ){
                // upper
                if(nums[start] < target && target < nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else {
                // down
                if(nums[mid] < target && target < nums[end]){
                    start = mid;
                }else {
                    end = mid;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
}
