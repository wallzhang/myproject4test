package com.wall.myproject4test.interview;

import java.util.Comparator;


/** 
* @Description: question1 重写比较器1
* @Author: zhang.zw
* @Date: 2021/1/15 
*/
public class Compare4Question1 implements Comparator< Extension > {

    private static String DEF_VALUE= "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
    @Override
    public int compare(Extension o1, Extension o2) {
        try {
            // 算出o1和o2的排序顺序
            // 先比较firstName;
            String firstNameForO1 = o1.getFirstName();
            String firstNameForO2 = o2.getFirstName();
            int firstCompare = firstNameForO1.compareTo(firstNameForO2);
            if(firstCompare < 0){
                return -1;
            }else if(firstCompare > 0){
                return 1;
            }else {
                // firstName相等进入下一层比较
                // 为null的时候给个默认值
                String lastNameForO1 = o1.getLastName()==null?DEF_VALUE:o1.getLastName();
                String lastNameForO2 = o2.getLastName()==null?DEF_VALUE:o2.getLastName();
                int lastCompare = lastNameForO1.compareTo(lastNameForO2);
                if(lastCompare < 0){
                    return -1;
                }else if(lastCompare > 0){
                    return 1;
                }else {
                    // 第三次判断 Ext
                    String ExtForO1 = o1.getExt()==null?DEF_VALUE: o1.getExt();
                    String ExtForO2 = o2.getExt()==null?DEF_VALUE:o2.getExt();
                    int extCompare = ExtForO1.compareTo(ExtForO2);
                    if(extCompare < 0){
                        return -1;
                    }else if(extCompare > 0){
                        return 1;
                    }else {
                        return 0;
                    }

                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        // 默认值
        return 0;
    }
}
