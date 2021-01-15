package com.wall.myproject4test.exam;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class Main {
    public static String changeFormatNumber (String number) {
        try {
            int n = Integer.valueOf(number);
            StringBuilder sb = new StringBuilder();
            String binaryS;
            String hexS;
            if(Math.abs(n) > Math.pow(2, 15) - 1){
                System.out.print("NODATA");
            }else {
                if(n >= 0){
                    return calculatePositiveNum(n, sb);
                }else {
                    return sb.append(Integer.toBinaryString(n).substring(16)).append(',').append(Integer.toHexString(n).substring(4).toUpperCase()).toString();
                }
            }
        }catch (NumberFormatException e){
            System.out.print("INPUTERROR");
        }
        return "";
    }

    static String calculatePositiveNum(int n, StringBuilder sb) {
        String binaryS;
        String hexS;
        binaryS = Integer.toBinaryString(n);
        for(int i = 0,j = 16 - binaryS.length();i < j;i ++){
            sb.append('0');
        }
        sb.append(binaryS).append(',');
        hexS = Integer.toHexString(n);
        for(int i = 0,j = 4 - hexS.length();i < j;i ++){
            sb.append('0');
        }
        sb.append(hexS.toUpperCase());
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(changeFormatNumber("-2"));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toHexString(15));
    }

    //把map转换成指定类型的javabean对象
    public static <T> T toBean(Map map, Class<T> clazz) {

        try {
            //创建指定类型的javaBean对象
            T bean = clazz.newInstance();
            //把数据封装到javaBean中
            BeanUtils.populate(bean, map);
            //返回javaBean对象
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
