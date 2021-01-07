package com.wall.myproject4test.leedcode.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random()*100);
            System.out.print(arr[i] + ",");
        }
        System.out.println("----------");
        new QuickSort().sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
    public void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int[] arr, int start,int end){
        if(start >= end){
            return;
        }
        int point = arr[start];
        int left = start;
        int right = end;
        while (left <= right){
             while (left<=right && arr[left] < point){
                left++;
            }
            while(left<=right && arr[right] > point){
                right--;
            }
            if(left<=right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        quickSort(arr,start,right);
        quickSort(arr,left,end);
    }
}
