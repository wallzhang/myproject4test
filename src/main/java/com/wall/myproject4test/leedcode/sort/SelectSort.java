package com.wall.myproject4test.leedcode.sort;


/**
* @Description: 选择排序
* @Author: zhang.zw
* @Date: 2021/1/6
*/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random()*100);
            System.out.print(arr[i] + ",");
        }
        System.out.println("----------");
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[pos] > arr[j]){
                    pos = j;
                }
            }
            // 指针发生变化
            if(pos != i){
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
    }
}
