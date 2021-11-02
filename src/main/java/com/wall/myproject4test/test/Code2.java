package com.wall.myproject4test.test;

import org.springframework.core.NamedThreadLocal;

public class Code2 {
    public static void main(String[] args) {
        ThreadLocal<Long> tenantContextHolder = new NamedThreadLocal<>("tenant id");
        tenantContextHolder.set(Long.valueOf(-1));
        System.out.println(tenantContextHolder);
        System.out.println(tenantContextHolder.get());
    }
}
