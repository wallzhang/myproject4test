package com.wall.myproject4test.java.zzw.inf4demo.failfast;

import java.util.ArrayList;
import java.util.List;

public class FailFastTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        new Thread1(list).start();
        new Thread2(list).start();
    }
}
