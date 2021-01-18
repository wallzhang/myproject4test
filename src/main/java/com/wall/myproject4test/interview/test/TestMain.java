package com.wall.myproject4test.interview.test;



import com.wall.myproject4test.interview.Extension;
import com.wall.myproject4test.interview.QuarterSalesItem;
import com.wall.myproject4test.interview.SaleItem;
import com.wall.myproject4test.interview.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
* @Description: 问题单元测试类,
* @Author: zhang.zw
* @Date: 2021/1/15
*/
public class TestMain {

    private static TestMain testMain = new TestMain();

    public static void main(String[] args) {
        // Question1,Question2测试前置条件
        List<Extension> list = new ArrayList<>();
        Extension extension1 = new Extension("zs",null,null,"Dept");
        list.add(extension1);
        Extension extension2 = new Extension("ls",null,null,"User");
        list.add(extension2);
        Extension extension3 = new Extension("ls","ls2",null,"111");
        list.add(extension3);
        Extension extension4 = new Extension("ww",null,null,"AO");
        list.add(extension4);
        Extension extension5 = new Extension("ls","zzz",null,"111");
        list.add(extension5);
        // Question1 基于firstName, lastName, ext排序
         testMain.testForSortByName(list);
        System.out.println("-------------");
        // 基于extType排序
         testMain.test4sortByExtType(list);
        System.out.println("-------------");
        // Question3，Question4测试前置条件
        List<SaleItem> saleItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            SaleItem saleItem = new SaleItem(i,null,Math.random()*10000);
            System.out.println(saleItem.toString());
            saleItems.add(saleItem);
        }
        // Question3 sum all sales items by quarter
        testMain.test4sumByQuarter(saleItems);
        System.out.println("-------------");
        // Question4, max all sales items by quarter, get the max amount from the item belongs to the same quarter
        testMain.test4maxByQuarter(saleItems);
        System.out.println("-------------");
        // Question5 get all unused keys
        // 测试100个初始值,已使用其中的23个。
        int[] allKeys = new int[100];
        int[] usedKeys = new int[23];
        for (int i = 0; i < allKeys.length; i++) {
            allKeys[i] = i;
        }
//        // 利用list.contains方法进行去重
        List<Integer> list4deduplication = new ArrayList();
        int num = -1;
        int index = 0;
        while (index <23){
            num = (int) Math.round(Math.random()*99);
            if(!list4deduplication.contains(num)){
                list4deduplication.add(num);
                usedKeys[index] = num;
                index++;
            }
        }
        // 对usedKeys进行排序处理(快排)
        testMain.sort(usedKeys);
        testMain.test4getAllUnusedKey(allKeys,usedKeys);
    }

    
    /** 
    * @Description: Question1, sort by firstName , lastName and  ext, 
    * @Author: zhang.zw
    * @Date: 2021/1/16 
    */
    public void testForSortByName(List<Extension> list){

        for (Extension ex:list) {
            System.out.println(ex.toString());
        }
        System.out.println("Question1:基于firstName, lastName, ext排序");
        Utils.sortByName(list);
        for (Extension ex:list) {
            System.out.println(ex.toString());
        }
    }

    
    /** 
    * @Description: Question2, sort extType
    * @Author: zhang.zw
    * @Date: 2021/1/16 
    */
    public void test4sortByExtType(List<Extension> list){
        for (Extension ex:list) {
            System.out.println(ex.toString());
        }
        System.out.println("Question2:基于extType排序");
        Utils.sortByExtType(list);
        for (Extension ex:list) {
            System.out.println(ex.toString());
        }
    }

    /**
     * @Description: Question3, sort extType
     * @Author: zhang.zw
     * @Date: 2021/1/16
     */
    public void test4sumByQuarter(List<SaleItem> saleItems){
        List<QuarterSalesItem> sortByQuarter = Utils.sumByQuarter(saleItems);
        System.out.println("Question3, sort extType:");
        for (QuarterSalesItem qa:sortByQuarter) {
            System.out.println("QuarterSalesItem:" + qa.toString());
        }
    }

    /**
     * @Description: Question4, max all sales items by quarter, get the max amount from the item belongs to the same quarter
     * @Author: zhang.zw
     * @Date: 2021/1/16
     */
    public void test4maxByQuarter(List<SaleItem> saleItems){
        List<QuarterSalesItem> maxByQuarter = Utils.maxByQuarter(saleItems);
        System.out.println("Question4, get the max amount from the item belongs to the same quarter:");
        for (QuarterSalesItem qa:maxByQuarter) {
            System.out.println("QuarterSalesItem:" + qa.toString());
        }
    }

    /**
     * @Description: Question5,get all unused keys
     * @Author: zhang.zw
     * @Date: 2021/1/16
     */
    public void test4getAllUnusedKey(int[] allKeys, int[] usedKeys){
        int[] unusedKeys = Utils.getUnUsedKeys(allKeys,usedKeys);

        StringJoiner sj = new StringJoiner(",");
        for (int num:unusedKeys) {
            sj.add(String.valueOf(num));
        }
        System.out.println("Question5,get all unused keys:\n [" + sj.toString() + "]");
    }

    // 快排
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
