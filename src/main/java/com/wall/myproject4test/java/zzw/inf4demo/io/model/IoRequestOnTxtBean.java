package com.wall.myproject4test.java.zzw.inf4demo.io.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * @description:获取txt所包含内容请求bean
 * @author: zhang.zw
 * @date: 2020/10/20 14:22
 **/
@ApiModel
public class IoRequestOnTxtBean {

    @ApiModelProperty(value = "txt文件所在目录",required = true)
    public String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
