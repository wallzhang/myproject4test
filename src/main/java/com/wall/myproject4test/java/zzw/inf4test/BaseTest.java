package com.wall.myproject4test.java.zzw.inf4test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BaseTest {

    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public static void main(String[] args) {
        String str = "0.460000.123";
        String[] strs = str.split("\\.");
        logger.info("strs[1]:"+strs[1]);
    }
}
