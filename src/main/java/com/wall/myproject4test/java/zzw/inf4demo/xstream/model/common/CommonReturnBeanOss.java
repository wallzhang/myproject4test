package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* @Description: 综资return
* @Author: zhang.zw
* @Date: 2020/12/9
*/
@ApiModel
public class CommonReturnBeanOss {

    @ApiModelProperty("response")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
