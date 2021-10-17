package com.wall.myproject4test.model;


import java.util.List;

/**
* @Description: 指标数据
* @Author: zhang.zw
* @Date: 2021/8/31 
*/
public class ParDataModel {

    private String status;

    private String msg;

    private List<DataDTO> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }


}
