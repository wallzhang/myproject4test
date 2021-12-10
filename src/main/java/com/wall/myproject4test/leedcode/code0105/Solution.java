package com.wall.myproject4test.leedcode.code0105;

/**
 * 面试题 01.05. 一次编辑
 */
class Solution {

    public static void main(String[] args) {
        //"intention"
        //"execution"
        System.out.println(new Solution().oneEditAway("intention","execution"));
    }
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        char[] charsFirst = first.toCharArray();
        char[] charsSecond = second.toCharArray();
        char[] minArr ;
        char[] maxArr ;
        if(charsFirst.length<=charsSecond.length){
            minArr = charsFirst;
            maxArr = charsSecond;
        }else {
            minArr = charsSecond;
            maxArr = charsFirst;
        }
        int offsetFirst = -1;
        int offsetSecond = -1;
        for (int i = 0; i < minArr.length; i++) {
            if (minArr[i] == maxArr[i]) {
                continue;
            }
            offsetFirst = i;
            break;
        }
        for (int i = 0; i < minArr.length; i++) {
            if (minArr[minArr.length - i - 1] == maxArr[maxArr.length - i - 1]) {
                continue;
            }
            offsetSecond = maxArr.length - i - 1;
            break;
        }
        if (offsetFirst == -1 || offsetSecond == -1 || offsetFirst == offsetSecond) {
            return true;
        }
        return false;
    }
}
