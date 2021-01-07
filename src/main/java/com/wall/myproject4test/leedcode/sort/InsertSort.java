package com.wall.myproject4test.leedcode.sort;


/**
* @Description: 插入排序
* @Author: zhang.zw
* @Date: 2021/1/6
*/
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random()*100);
            System.out.print(arr[i] + ",");
        }
        System.out.println("----------");
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void insertSort(int[] arr){

        int insert;
        int j;
        for (int i = 1; i < arr.length; i++) {
            // 从第二位开始往前插入
            insert = arr[i];
            j = i -1;
            while (j>=0 && insert < arr[j]){
                // 如果插入的元素小于第j个元素，就将第j个元素向后移动
                arr[j+1] = arr[j];
                j--;
            }
            // 直到插入的元素不小于第j个元素，将这个insertNode插入
            arr[j+1] = insert;
        }
    }
}
