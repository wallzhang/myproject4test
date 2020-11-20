package com.wall.myproject4test.java.zzw.inf4demo.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: Xstream测试demo类
 * 基础类只包含基本数据类型，不包含数组集合等
 * @author: zhang.zw
 * @date: 2020/10/22 8:32
 **/

@ApiModel
@XStreamAlias("Response")
public class XsteamDemo3ReqBean {

    @XStreamAlias("resultCode")
    @ApiModelProperty(value = "resultCode")
    private String resultCode;

    @XStreamAlias("resultDesc")
    @ApiModelProperty(value = "resultDesc")
    private String resultDesc;

    @XStreamAlias("returnTime")
    @ApiModelProperty(value = "returnTime")
    private String returnTime;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
}
