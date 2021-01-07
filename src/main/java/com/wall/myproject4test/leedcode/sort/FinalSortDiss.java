package com.wall.myproject4test.leedcode.sort;

/** 
* @Description: 基于leedcode 215方法小结
* @Author: zhang.zw
* @Date: 2021/1/7 
*/
public class FinalSortDiss {
    public int findKthLargest(int[] nums, int k) {
        // 思路就是对数组进行从小到大的排序，然后去下标为length-k的数据
//        sort(nums);
//        selectSort(nums);
//        insertSort(nums);
//        quickSort(nums,0,nums.length-1);
//        return nums[nums.length-k];
        return quickSort(nums,0,nums.length-1,nums.length-k);

    }
    // 冒泡排序
    public void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length -i; j++){
                int k = j-1;
                if(nums[k] > nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                }
            }
        }
    }
    // 选择排序
    public void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int position = i;
            for (int j = i+1; j < nums.length; j++){
                if(nums[position] > nums[j]){
                    position = j;
                }
            }
            if(i !=position){
                int temp = nums[position];
                nums[position] = nums[i];
                nums[i] = temp;
            }
        }
    }
    // 插入排序
    public void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int insert = nums[i];
            int j = i - 1;
            while (j>=0 && insert < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            // 前面多减了一位这边补上
            nums[j+1] = insert;
        }
    }
    // 快速排序
    public void quickSort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int flagNum = nums[start];
        int left = start;
        int right = end;
        while (left <= right){
            while (left <= right && nums[left] < flagNum){
                left++;
            }
            while (left <= right && nums[right] > flagNum){
                right--;
            }
            if (left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums,start,right);
        quickSort(nums,left,end);
    }
    // 快速排序变化找指定K
    public int quickSort(int[] nums,int start,int end,int k){
        int flagNum = nums[(start+end)/2];
        int left = start;
        int right = end;
        while (left <= right){
            while (left <= right && nums[left] < flagNum){
                left++;
            }
            while (left <= right && nums[right] > flagNum){
                right--;
            }
            if (left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if( k <= right ){
            return quickSort(nums,start,right,k);
        }
        if( k >= left){
            return quickSort(nums,left,end,k);
        }
        return nums[k];
    }
}
