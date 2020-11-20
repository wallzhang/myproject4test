package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: Irms响应的结果
 * @author: zhang.zw
 * @date: 2020/10/22 11:18
 **/
@ApiModel
public class IrmsCallBackBean {

    @ApiModelProperty(value = "地市",required = true)
    public String CITY;

    @ApiModelProperty(value = "OLT设备IP地址",required = true)
    public String OLT_IPADDRESS;

    @ApiModelProperty(value = "OLT设备名称",required = true)
    public String OLT_NAME;

    @ApiModelProperty(value = "业务类型",required = true)
    public String SERVICE_TYPE;

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getOLT_IPADDRESS() {
        return OLT_IPADDRESS;
    }

    public void setOLT_IPADDRESS(String OLT_IPADDRESS) {
        this.OLT_IPADDRESS = OLT_IPADDRESS;
    }

    public String getOLT_NAME() {
        return OLT_NAME;
    }

    public void setOLT_NAME(String OLT_NAME) {
        this.OLT_NAME = OLT_NAME;
    }

    public String getSERVICE_TYPE() {
        return SERVICE_TYPE;
    }

    public void setSERVICE_TYPE(String SERVICE_TYPE) {
        this.SERVICE_TYPE = SERVICE_TYPE;
    }
}

