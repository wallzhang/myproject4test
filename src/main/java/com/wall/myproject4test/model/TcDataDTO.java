package com.wall.myproject4test.model;


/** 
* @Description: tcData节点
* @Author: zhang.zw
* @Date: 2021/8/31 
*/
public class TcDataDTO {

    private String tcName;

    private ParDataDTO parData;

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public ParDataDTO getParData() {
        return parData;
    }

    public void setParData(ParDataDTO parData) {
        this.parData = parData;
    }
}
