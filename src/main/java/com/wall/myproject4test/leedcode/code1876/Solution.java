package com.wall.myproject4test.leedcode.code1876;


/**
 * @Description: 1876. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好字符串
 * 给你一个字符串 s，请你返回 s中长度为 3的 好子字符串 的数量。
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 * @Author: zhang.zw
 * @Date: 2021/11/29
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countGoodSubstrings("aababcabc"));
    }

    public int countGoodSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        if (chars.length < 3) {
            return result;
        }
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == chars[i + 1]) {
                continue;
            }
            if (chars[i] == chars[i + 2]) {
                continue;
            }
            if (chars[i + 1] == chars[i + 2]) {
                continue;
            }
            result += 1;
        }
        return result;
    }
}
