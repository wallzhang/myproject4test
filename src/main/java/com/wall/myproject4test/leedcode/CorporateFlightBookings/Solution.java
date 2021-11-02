package com.wall.myproject4test.leedcode.CorporateFlightBookings;


import java.util.Arrays;

/**
* @Description: 航班预订统计
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
* @Author: zhang.zw
* @Date: 2021/11/2 
*/
public class Solution {

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int[] ans = corpFlightBookings(bookings,5);
        System.out.println(Arrays.asList(ans));
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0]-1;
            int end = bookings[i][1]-1;
            int booking = bookings[i][2];
            for (int j = start; j <= end; j++){
                ans[j] += booking;
            }
        }
        return ans;
    }
}
