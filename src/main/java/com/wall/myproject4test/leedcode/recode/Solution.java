package com.wall.myproject4test.leedcode.recode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(218));
    }
    public static boolean reorderedPowerOf2(int n) {

        if(n == 1){
            return true;
        }
        // 对n进行重排序。存入Set集合中
        Set<Integer> set = new HashSet<>();
        char[] chars = String.valueOf(n).toCharArray();
        boolean[] vis = new boolean[chars.length];

        //
        boolean powerOf2 = false;
        int a = 0;
        int b = 0;
        while(n>=2){
            a = n / 2;
            b = n % 2;
            if ( b == 1){
                powerOf2 = false;
                break;
            }else if(a ==1 && b == 0){
                powerOf2 = true;
                break;
            } else if(a !=1 && b == 0){
                n = a;
            }
        }
        if(powerOf2){
            return true;
        }
        //
        return powerOf2;
    }
}
