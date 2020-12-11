package com.wall.myproject4test;

public class BaseInfoDemo {

    private int realAge = 23;
    public static String name = "wallzhang";
    public final String fromArea = "fujian";

    public BaseInfoDemo() {

    }
    public BaseInfoDemo(int realAge) {
        this.realAge = realAge;
    }

    public void say(){
        System.out.println("fromArea:"+fromArea+",name:"+name+",realAge:"+realAge);
    }

    public static void main(String[] args) {
        BaseInfoDemo baseInfoDemo = new BaseInfoDemo(18);
        baseInfoDemo.say();
        BaseInfoDemo baseInfoDemo2 = new BaseInfoDemo();
        baseInfoDemo2.say();
    }
}
