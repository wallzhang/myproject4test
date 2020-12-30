package com.wall.myproject4test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    static {
        age = 17;
    }
    static int age ;
    public static void main(String[] args) {

        int[][] res = new int[4][2];
//        Stack stack = new Stack();
//        List list = new ArrayList();
//        list.sort(Comparator.comparingInt(Integer::intValue));
//        char[] chars = "{hello}".toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println(chars[i]);
//        }
        int[] A = {1,1,5,2,3};
        System.out.println(new  Test().largestPerimeter(A));
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
        Arrays.sort(res, (arr1, arr2) -> {
            int d1 = dist(arr1[0], arr1[1], r0, c0);
            int d2 = dist(arr2[0], arr2[1], r0, c0);
            return Integer.compare(d1, d2);
        });
//        // 从 (r0, c0) 到其他单元格的距离为：[0,1]
//        res[0][0] = r0;
//        res[0][1] = c0;
//        int rowFlag = 1;
//        int cowFlag = 1;
//        for (int i = 1; i < R*C; i++) {
//            if(r0+rowFlag < R) {
//                // 检查右移是否满足要求
//                res[i][0] = r0 + rowFlag;
//                res[i][1] = c0;
//            }else if(r0 - rowFlag >= 0){
//                res[i][0] = r0 - rowFlag;
//                res[i][1] = c0;
//            }else if(c0 + cowFlag < C){
//                res[i][0] = r0;
//                res[i][1] = c0 + cowFlag;
//            }else if(c0 - cowFlag >= 0){
//                res[i][0] = r0;
//                res[i][1] = c0 - cowFlag;
//            }else {
//                continue;
//            }
//        }
        return res;
    }

    private int dist(int r1,int c1,int r2,int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
