package com.wall.myproject4test.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T3 {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00");
        String startTime = LocalDateTime.now().minusMinutes(10).format(df);
        String endTime = LocalDateTime.now().format(df);
        System.out.println(startTime);
        System.out.println(endTime);
    }
}
