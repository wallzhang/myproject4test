package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.common;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* @Description: 详细信息
* @Author: zhang.zw
* @Date: 2020/12/8 
*/
@ApiModel
@XStreamAlias("opDetail")
public class OpDetailBeanOss {

    @XStreamAlias("recordInfo")
    @ApiModelProperty("记录内容")
    private RecordInfoBeanOss recordInfo;

    public RecordInfoBeanOss getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(RecordInfoBeanOss recordInfo) {
        this.recordInfo = recordInfo;
    }
}
