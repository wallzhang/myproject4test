package com.wall.myproject4test.leedcode.binarySearch;


/**
* @Description: 先对二分查找有个概念
* @Author: zhang.zw
* @Date: 2021/1/5
*/
public class BinarySearchDemo {

    public static void main(String[] args) {
        System.out.println("res:"+binarySearch(1,1000,667));
    }

    public static Boolean binarySearch(int start ,int end ,int target){
        // 不推荐使用可能造成数组越界
        // int mid = (start+end)/2;

        while (start +1 < end){
            int mid = start + (end - start)/2;
            if(mid == target){
                return true;
            }else if(mid < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(start == target || end == target){
            return true;
        }
        return false;

    }


}
