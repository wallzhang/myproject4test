package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:Irms系统请求bean
 * @author: zhang.zw
 * @date: 2020/10/21 15:29
 **/
@ApiModel
public class IrmsFlowReturnBean {

    @ApiModelProperty(value = "响应编码0成功1失败")
    private String resCode;

    @ApiModelProperty(value = "响应编结果")
    private String resMsg;

    @ApiModelProperty(value = "响应数据")
    private IrmsCallBackBean irmsCallBackBean;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public IrmsCallBackBean getIrmsCallBackBean() {
        return irmsCallBackBean;
    }

    public void setIrmsCallBackBean(IrmsCallBackBean irmsCallBackBean) {
        this.irmsCallBackBean = irmsCallBackBean;
    }
}
