package com.wall.myproject4test.leedcode.code844;


/**
 * @Description: 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 * <p>
 * 如果相等，返回 true ；否则，返回 false 。
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * @Author: zhang.zw
 * @Date: 2021/11/29
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ab#c"));
    }

    public boolean backspaceCompare(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        String resultS = getResultByChars(charsS);
        String resultT = getResultByChars(charsT);
        return resultS.equals(resultT);
    }

    public String getResultByChars(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ('#' == chars[i]) {
                // 退格键
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
