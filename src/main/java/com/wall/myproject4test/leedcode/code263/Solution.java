package com.wall.myproject4test.leedcode.code263;


/**
 * @Description: 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数2、3 和5的正整数。
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * @Author: zhang.zw
 * @Date: 2021/11/29
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(-2147483648));
    }

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        // 除以2
        while (true) {
            if (n % 2 == 0) {
                n = n / 2;
                // 包含有2的值
            } else {
                break;
            }
        }
        // 除以3
        while (true) {
            if (n % 3 == 0) {
                n = n / 3;
                // 包含有2的值
            } else {
                break;
            }
        }
        // 除以5
        while (true) {
            if (n % 5 == 0) {
                n = n / 5;
                // 包含有2的值
            } else {
                break;
            }
        }
        return n == 1;
    }
}
