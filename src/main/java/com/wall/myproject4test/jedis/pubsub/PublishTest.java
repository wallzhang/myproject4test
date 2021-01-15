package com.wall.myproject4test.jedis.pubsub;


import redis.clients.jedis.Jedis;

/**
* @Description: 测试连接
* @Author: zhang.zw
* @Date: 2021/1/13 
*/
public class PublishTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.publish("channel-1","wall");
        jedis.publish("channel-2","hello");
        jedis.publish("channel-2","world");
    }

}
