package com.wall.myproject4test;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    static {
        age = 17;
    }
    static int age ;
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("3");
//        System.out.println(list);
//        // 1.基于代码逻辑保留最新的数据
//        Collections.reverse(list);
//        System.out.println(list);
//        Set<String> set = new HashSet<>();
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String key = iterator.next();
//            if(!set.add(key)){
//                // set中已存在同名数据
//                iterator.remove();
//            }
//        }
//        System.out.println(list);
//          String jsonArrays = "[[1,2,3],[4,5,6],[7,8,9]]";
//        try {
//            JSONArray jsonArray = new JSONArray(jsonArrays);
//            jsonArray.getJSONArray(0).length();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//          int[][] res2 = Arrays.;
//          int[][] res1 = {{1,2,3},{4,5,6}};
//        System.out.println(res1.);
//        int[][] res = new int[4][2];
////        Stack stack = new Stack();
////        List list = new ArrayList();
////        list.sort(Comparator.comparingInt(Integer::intValue));
////        char[] chars = "{hello}".toCharArray();
////        for (int i = 0; i < chars.length; i++) {
////            System.out.println(chars[i]);
////        }
//        int[] A = {1,1,5,2,3};
//        System.out.println(new  Test().largestPerimeter(A));

//        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
//        int[] arr1 = {2,3,1,3,2};
////        int[] arr2 = {2,1,4,3,9,6};
//        int[] arr2 = {2,1};
//        int[] res = new Test().relativeSortArray(arr1,arr2);
//        System.out.println(res);
    }

    private int[] res(){
        int[] ints = {1,2};
        return ints;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        int[] res = new int[2];
        for (int j = 0; j < nums.length; j++){
            if(map.containsKey(target - nums[j])){
                res[0] = j;
                res[1] = map.get(target - nums[j]);
                break;
            }
        }
        return res;
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int flag = A.length -1;
        return findRes(A,flag);
    }

    public int findRes(int[] A,int flag){
        if(flag == 2){
            // 等于3的情况
            if(A[flag] < (A[flag-1] + A[flag-2])){
                return A[flag] + A[flag-1] +A[flag-2];
            }else {
                return 0;
            }
        }else {
            // 大于三的情况
            if(A[flag] < (A[flag-1] + A[flag-2])){
                return A[flag] + A[flag-1] +A[flag-2];
            }else {
                return findRes(A,flag-1);
            }
        }
    }



    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i*j + j;
                res[t][0] = i;
                res[t][1] = j;
            }
        }
//        Arrays.sort(res, (arr1, arr2) -> {
//            int d1 = dist(arr1[0], arr1[1], r0, c0);
//            int d2 = dist(arr2[0], arr2[1], r0, c0);
//            return Integer.compare(d1, d2);
//        });
//        // 从 (r0, c0) 到其他单元格的距离为：[0,1]
        res[0][0] = r0;
        res[0][1] = c0;
        int rowFlag = 1;
        int cowFlag = 1;
        boolean flagUp = true;
        boolean flagDown = true;
        boolean flagLeft = true;
        boolean flagRight = true;
        for (int i = 1; i < R*C; i++) {
            if(r0+rowFlag < R && flagUp) {
                // 检查右移是否满足要求
                res[i][0] = r0 + rowFlag;
                res[i][1] = c0;
                flagUp = false;
            }else if(r0 - rowFlag >= 0 && flagDown){
                res[i][0] = r0 - rowFlag;
                res[i][1] = c0;
                flagDown = false;
            }else if(c0 + cowFlag < C && flagLeft){
                res[i][0] = r0;
                res[i][1] = c0 + cowFlag;
                flagLeft = false;
            }else if(c0 - cowFlag >= 0 && flagRight){
                res[i][0] = r0;
                res[i][1] = c0 - cowFlag;
                flagRight = false;
            }else {
                flagUp = true;
                flagDown = true;
                flagLeft = true;
                flagRight = true;
                rowFlag +=1;
                cowFlag +=1;
                continue;
            }
        }
        return res;
    }

    private int dist(int r1,int c1,int r2,int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        // res数组标识
        int flagB = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                 if(arr2[i]==arr1[j]){
                     res[flagB] = arr2[i];
                     flagB++;
                 }
            }
        }
        List list = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if(!list.contains(arr1[i])){
                integers.add(arr1[i]);
            }
        }
        int[] arr3 = integers.stream().mapToInt(Integer::valueOf).toArray();

        Arrays.sort(arr3);
        System.arraycopy(arr3,0,res,flagB,arr3.length);
        return res;
    }
}
