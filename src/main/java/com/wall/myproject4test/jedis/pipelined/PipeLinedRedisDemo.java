package com.wall.myproject4test.jedis.pipelined;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PipeLinedRedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        long startTime = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 10000; i++) {
            pipeline.set("pipeline"+i, String.valueOf(i));
        }
        pipeline.syncAndReturnAll();
        System.out.println("resTime:"+ (System.currentTimeMillis() - startTime));
    }
}
