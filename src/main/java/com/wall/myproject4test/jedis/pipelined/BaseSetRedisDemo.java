package com.wall.myproject4test.jedis.pipelined;

import redis.clients.jedis.Jedis;

public class BaseSetRedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            jedis.set("base"+i,String.valueOf(i));
        }
        System.out.println("resTime:" + (System.currentTimeMillis() - startTime));
    }
}
