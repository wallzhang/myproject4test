package com.wall.myproject4test.model;


import java.util.List;

/**
* @Description: AppData节点
* @Author: zhang.zw
* @Date: 2021/8/31
*/
public class AppDataDTO {

    private String appName;

    private List<TcDataDTO> tcData;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<TcDataDTO> getTcData() {
        return tcData;
    }

    public void setTcData(List<TcDataDTO> tcData) {
        this.tcData = tcData;
    }
}
