package com.wall.myproject4test.exam;


/** 
* @Description: 字符类型转换
 * 0000000000001111,000F
 * 0000000000001111,000F
 * "1111111111111111,FFFF"
* @Author: zhang.zw
* @Date: 2021/1/13 
*/
public class Solution {

    public static void main(String[] args) {
        String str = "-2";
        System.out.println(new Solution().changeFormatNumber(str));
    }
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    public String changeFormatNumber (String number) {
        // 预处理特殊情况1
        int nbr = 0;
        String flag = "";
        try {
            if(number.startsWith("-")){
                flag = "-";
                number = number.substring(1);
            }
            nbr = Integer.valueOf(number);
            if(nbr> 65535 ){
                return "NODATA";
            }
            if("-".equals(flag)){
                nbr = 65536 -nbr;
            }
        }catch (NumberFormatException ex){
            return "INPUTERROR";
        }
        // 预处理特殊情况2
        if("-1".equals(number)){
            return "1111111111111111,FFFF";
        }
        // 二进制模板
        String twoTemplate = "0000000000000000";
        // 二进制位负数的情况
        String twoTemplate2 = "1111111111111111";

        // 十六进制模板
        String secondTemplate = "0000";
        String secondTemplate2 = "FFFF";
        // 求出二进制结果
        StringBuilder str1 = new StringBuilder();
        // 求出十六进制结果
        StringBuilder str2 = new StringBuilder();
        // 二进制处理逻辑过程
        int num1 = nbr;
        while (num1!=0){
            str1.append(num1%2);
            num1 = num1/2;
        }
        // 十六进制处理逻辑过程
        int num2 = nbr;
        int num2flag = 0;
        String num2res = "";
        while (num2!=0){
            num2flag = num2%16;
            num2res = checkNum(num2flag);
            str2.append(num2res);
            num2 = num2/16;
        }
        String finalRes = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if(!"-".equals(flag)){
            finalRes = twoTemplate.substring(0,twoTemplate.length() - str1.length()) +str1.toString()  + ","
                    + secondTemplate.substring(0,secondTemplate.length()- str2.length()) + str2.toString();
        }else {
            String res1 = twoTemplate2.substring(0,twoTemplate2.length() - str1.length()) +str1.toString();
            String res2 = secondTemplate2.substring(0,secondTemplate2.length()- str2.length()) + str2.toString();
            sb.append(res1);
            sb2.append(res2);
            finalRes = sb.reverse().toString() +"," + sb2.reverse().toString() ;
        }
        return finalRes;
    }

    private String checkNum(int num2flag) {
        if(num2flag < 10){
            return String.valueOf(num2flag);
        }
        String res = "";
        switch (num2flag){
            case 10:
                res = "A";
                break;
            case 11:
                res = "B";
                break;
            case 12:
                res = "C";
                break;
            case 13:
                res = "D";
                break;
            case 14:
                res = "E";
                break;
            case 15:
                res = "F";
                break;
            default:
                break;
        }
        return res;
    }
}
