package com.wall.myproject4test.leedcode.DiagonalTraverse;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
* @Description:  498. Diagonal Traverse
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
* @Author: zhang.zw
* @Date: 2021/11/3 
*/
public class Solution {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ans = findDiagonalOrder(mat);
        System.out.println(Arrays.asList(ans).toString());
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        // 初始化结果数组
        // y轴
        int m = mat.length;
        // x轴
        int n = mat[0].length;
        int[] ans = new int[m*n];
        // 一共有total条对角线
        int total = m + n -1;
        int index = 0;
        int x = 0;
        int y = 0;
        // 对角线默认方向斜向上
        boolean direction = true;
        for (int i = 0; i < total; i++) {
            // x和y的值需要初始化
            if(direction){
                // 正向
                if(i<n){
                    x = i;
                }else {
                    x = n-1;
                }
                y = i-x;
            }else {
                // 反向
                if(i<m){
                    x = 0;
                }else {
                    x = m-1;
                }
                y = i -x;
            }
            for (int j = 0; j <= i; j++) {
                ans[index] = mat[x][y];
                index++;
                if(direction){
                    x--;
                    y++;
                }else {
                    x++;
                    y--;
                }
            }
            // 每次执行完毕反向
            direction = !direction;
        }
        return ans;
    }
}
