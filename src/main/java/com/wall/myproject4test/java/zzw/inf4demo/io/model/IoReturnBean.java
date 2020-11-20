package com.wall.myproject4test.java.zzw.inf4demo.io.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: io相关接口统一响应bean
 * @author: zhang.zw
 * @date: 2020/10/20 14:16
 **/
@ApiModel
public class IoReturnBean {

    /**
     * 处理描述
     */
    @ApiModelProperty(value = "处理描述")
    public String res;

    /**
     * 处理结果，0成功，1失败
     */
    @ApiModelProperty(value = "处理结果，0成功，1失败")
    public String code;

    /**
     * 接口消耗时间单位毫秒
     */
    @ApiModelProperty(value = "接口消耗时间单位毫秒")
    public String dealTime;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }
}
