package com.wall.myproject4test.leedcode.NumberofBoomerangs;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 447. 回旋镖的数量
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * @Author: zhang.zw
 * @Date: 2021/11/2
 */
public class Solution {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        int ans = numberOfBoomerangs(points);
        System.out.println(ans);
    }

    public static int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> checkbox = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double range = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) +
                        Math.pow(points[i][1] - points[j][1], 2));
                if (checkbox.containsKey(range)) {
                    int val = checkbox.get(range);
                    val = val + 1;
                    checkbox.put(range, val);
                    // 计算出A(N,2)-A(N-1,2)然后计算
                    ans += (int) Math.pow(2, val - 1);
                } else {
                    checkbox.put(range, 1);
                }
            }
        }
        return ans;
    }
}
