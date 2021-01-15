package com.wall.myproject4test.jedis.pubsub;

import redis.clients.jedis.JedisPubSub;

public class MyListener extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("channel:"+channel);
        System.out.println("message:"+message);
    }


    @Override
    public void onPong(String pattern) {
        System.out.println("pattern:"+pattern);
    }
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("pattern:"+pattern +"channel:"+channel +"message:"+message);
    }
}
