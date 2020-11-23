package com.wall.myproject4test;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {
        Set<String> staffIds = new HashSet<>();
        staffIds.add("123");
        staffIds.add("1234");
        staffIds.add("12345");
        StringJoiner finalStaffIds = new StringJoiner(",");
        staffIds.forEach(item->{
            finalStaffIds.add(item);
//			finalStaffIds.append(item + ",");
        });
        System.out.println("finalStaffIds.toString():"+finalStaffIds.toString());
    }
}
