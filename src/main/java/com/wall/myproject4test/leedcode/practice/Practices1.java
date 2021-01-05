package com.wall.myproject4test.leedcode.practice;


import java.util.Scanner;

/**
* @Description:
 * 输入描述:
 * 输入为一个正整数的字符串
 * 输出描述:
 * 输出为与输入数字最接近的对称数字(不包括输入本身)的字符串
 * 示例1
 * 输入
 * 123
 * 输出
 * 121
* @Author: zhang.zw
* @Date: 2021/1/5 
*/
public class Practices1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(findMid(input));
    }
    public static String findMid(String input){
        // 处理特殊1位情况
        if(input.length() == 1){
            return input;
        }
        // 先找中位数
        int mid = (input.length()+1)/2;
        // 判断基偶性 0偶数,1奇数
        int isDouble = input.length()%2;
        String prev = input.substring(0,mid);
        String res;
        String res2;
        String res3;
        StringBuilder stringBuilder = new StringBuilder();
        if(0 == isDouble){
            stringBuilder.append(prev);
            res = prev + stringBuilder.reverse();
        }else {
            stringBuilder.append(prev.substring(0,prev.length()-1));
            res = prev + stringBuilder.reverse();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String prevAndOne = String.valueOf(Long.parseLong(prev)+1);
        if(0 == isDouble){
            stringBuilder2.append(prevAndOne);
            res2 = prevAndOne + stringBuilder2.reverse();
        }else {
            stringBuilder2.append(prevAndOne.substring(0,prevAndOne.length()-1));
            res2 = prevAndOne + stringBuilder2.reverse();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        String prevDelOne = String.valueOf(Long.parseLong(prev)-1);
        if(0 == isDouble){
            stringBuilder3.append(prevDelOne);
            res3 = prevDelOne + stringBuilder3.reverse();
        }else {
            stringBuilder3.append(prevDelOne.substring(0,prevDelOne.length()-1));
            res3 = prevDelOne + stringBuilder3.reverse();
        }
        // res1,res2,res3分别对input做差值判断
        String min = "";
        min = (Math.abs(Long.parseLong(res)-Long.parseLong(input)) -
                Math.abs(Long.parseLong(res2)-Long.parseLong(input)) < 0 ? res:res2);
        min = (Math.abs(Long.parseLong(min)-Long.parseLong(input)) -
                Math.abs(Long.parseLong(res3)-Long.parseLong(input)) < 0 ? min:res3);

        return min;
    }
}
