package com.wall.myproject4test.test;

import org.springframework.core.NamedThreadLocal;

public class Code3 {
    private static ThreadLocal<Integer> local1 = new NamedThreadLocal<Integer>("local1"){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };
    private static ThreadLocal<Integer> local2 = new NamedThreadLocal<Integer>("local2"){
        @Override
        protected Integer initialValue() {
            return 2;
        }
    };
    private static ThreadLocal<Integer> local3 = new NamedThreadLocal<Integer>("local3"){
        @Override
        protected Integer initialValue() {
            return 3;
        }
    };
    public static void main(String[] args) {
        System.out.println(local1.get());
        System.out.println(local2.get());
        System.out.println(local3.get());
    }
}
