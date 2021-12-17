package com.wall.myproject4test.leedcode.code1451;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 1451. 重新排列句子中的单词
 * 输入：text = "Leetcode is cool"
 * 输出："Is cool leetcode"
 * 解释：句子中共有 3 个单词，长度为 8 的 "Leetcode" ，长度为 2 的 "is" 以及长度为 4 的 "cool" 。
 * 输出需要按单词的长度升序排列，新句子中的第一个单词首字母需要大写。
 * @Author: zhang.zw
 * @Date: 2021/12/13
 */
public class Solution {
    public String arrangeWords(String text) {
        String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, Comparator.comparingInt(String::length));
        s[0] = s[0].substring(0, 1).toUpperCase() + s[0].substring(1);
        return String.join(" ", s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeWords("Keep calm and code on"));
    }
}
