package com.wall.myproject4test.java.zzw.thread.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/28-20:24
 */
public class Allocator {

    private List<Object> list=new ArrayList<>();
    /**
     * 申请资源
     * @param from
     * @param to
     * @return
     */
    synchronized boolean apply(Object from,Object to){
        if(list.contains(from)||list.contains(to)){
            return false;
        }else {
            list.add(from);
            list.add(to);
            return true;
        }
    }
    synchronized void free(Object from,Object to){
        list.remove(from);
        list.remove(to);
    }
}
