package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:Crm请求opDetail节点
 * @author: zhang.zw
 * @date: 2020/10/21 15:32
 **/
@ApiModel
@XStreamAlias("opDetail")
public class OpDetailBeanFjIrms {

    @XStreamAlias("recordInfo")
    @ApiModelProperty(value = "记录内容")
    private RecordInfoBeanFJIrms recordInfo;

    public RecordInfoBeanFJIrms getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(RecordInfoBeanFJIrms recordInfo) {
        this.recordInfo = recordInfo;
    }
}
