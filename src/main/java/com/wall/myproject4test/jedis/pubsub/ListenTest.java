package com.wall.myproject4test.jedis.pubsub;


import redis.clients.jedis.Jedis;

/**
* @Description:  
* @Author: zhang.zw
* @Date: 2021/1/15 
*/
public class ListenTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        final MyListener myListener = new MyListener();
        // 使用匹配的方式设置频道
        // 会阻塞
        jedis.psubscribe(myListener,new String[]{"channel*"});
    }
}
