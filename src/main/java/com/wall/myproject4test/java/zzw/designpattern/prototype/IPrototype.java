package com.wall.myproject4test.java.zzw.designpattern.prototype;


/**
* @Description: 拷贝接口
* @Author: zhang.zw
* @Date: 2021/3/21
*/
public interface IPrototype<T> {

    /**
     * 克隆方法
     * @return
     */
    public T clone();
}
