package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:Irms系统请求bean
 * @author: zhang.zw
 * @date: 2020/10/21 15:29
 **/
@ApiModel
public class IrmsFlowRequestBean {

    @ApiModelProperty(value = "详细信息，参见详细信息约定")
    private OpDetailBeanFjIrms opDetail;

    public OpDetailBeanFjIrms getOpDetail() {
        return opDetail;
    }

    public void setOpDetail(OpDetailBeanFjIrms opDetail) {
        this.opDetail = opDetail;
    }
}
