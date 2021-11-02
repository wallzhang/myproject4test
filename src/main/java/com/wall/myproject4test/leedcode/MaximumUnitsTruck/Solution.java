package com.wall.myproject4test.leedcode.MaximumUnitsTruck;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 请你将一些箱子装在 一辆卡车 上 返回卡车可以装载 单元 的 最大 总数。
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * @Author: zhang.zw
 * @Date: 2021/11/1
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] boxTypes = new int[][]{{2,1},{4,4},{3,1},{4,1},{2,4},{3,4},{1,3},{4,3},{5,3},{5,3}};
        int[][] boxTypes = new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}};
        int result = maximumUnits(boxTypes, 35);
        System.out.println(result);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // 基于二维数组的第二个值做倒叙排序
        //将箱子信息按照容量大小降序排列
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int result = 0;
        int index = 0;
        while (truckSize > 0) {
            if (index > boxTypes.length - 1) {
                break;
            }
            int boxNum = boxTypes[index][0];
            int boxSize = boxTypes[index][1];
            if (boxNum <= truckSize) {
                truckSize -= boxNum;
                result += boxNum * boxSize;
                index++;
            } else {
                result += truckSize * boxSize;
                truckSize = 0;
            }
        }
        return result;
    }
}
