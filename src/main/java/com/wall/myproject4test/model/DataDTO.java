package com.wall.myproject4test.model;


import java.util.List;

/**
* @Description: data节点
* @Author: zhang.zw
* @Date: 2021/8/31
*/
public class DataDTO {

    private String time;

    private List<AppDataDTO> appData;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<AppDataDTO> getAppData() {
        return appData;
    }

    public void setAppData(List<AppDataDTO> appData) {
        this.appData = appData;
    }
}
