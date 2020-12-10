package com.wall.myproject4test;

import net.sf.json.JSONObject;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    public static void main(String[] args) {
//        JSONObject
//        int CAPACITY   = (1 << Integer.SIZE - 3) - 1;
//        System.out.println(CAPACITY);
//        System.out.println(536870913 & CAPACITY);
//        ReentrantReadWriteLock
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.print("foo");
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//        System.out.print("ball");
//        System.out.println("----------");
//        String str = "{\"aEndAddressType\":\"1\",\"aEndCeAddressInfo\":{\"aEndAreaName\":\"白银区\",\"aEndCityName\":\"白银\",\"aEndCountyName\":\"dadada\",\"aEndProvinceName\":\"甘肃\",\"aEndVillageName\":\"啦啦啦\"},\"aEndCeIp\":\"sint ex id aliquip ad\",\"aEndCeIpMask\":\"45460051\",\"aEndCeIpType\":\"IPv6\",\"aEndCustomContact\":\"a\",\"aEndCustomContactPhone\":\"18888888888\",\"aEndCustomName\":\"yizhifeidie123\",\"aEndIpType\":\"IPv4\",\"aEndNeAddressInfo\":{\"aEndNeAreaName\":\"\",\"aEndNeCityName\":\"\",\"aEndNeId\":\"\",\"aEndNeProvinceName\":\"\",\"aEndNeRoomName\":\"\",\"aEndNeSiteName\":\"\"},\"aEndNetworkSegment\":\"192.168.4.0/22\",\"bandwidth\":200,\"bandwidthUnit\":\"M\",\"routeMode\":\"3\",\"serviceMaintainLevel\":\"AA\",\"vpcInfo\":\"10.1.2.0/24\",\"zNeInfo\":[{\"zNeId\":\"laboris ullamco\",\"zNeIpMask\":\"45460051\",\"zNeName\":\"未知设备名\",\"zNePortId\":\"aliqua non\",\"zNePortIp\":\"sint ex id aliquip ad\",\"zNePortIpType\":\"IPv6\",\"zNePortName\":\"未知端口名\",\"zNeVlanId\":2733},{\"zNeId\":\"proident ull\",\"zNeIpMask\":\"-71702725\",\"zNeName\":\"未知设备名\",\"zNePortId\":\"sunt consec\",\"zNePortIp\":\"et exercitation in\",\"zNePortIpType\":\"IPv6\",\"zNePortName\":\"未知端口名\",\"zNeVlanId\":2262}]}";
         Set set = new HashSet();
         boolean a = set.add("333");
         boolean b = set.add("333");
        System.out.println("a:"+a+",b:"+b);
    }
}
