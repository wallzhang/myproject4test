package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @description:记录内容-irms
 * @author: zhang.zw
 * @date: 2020/10/21 15:33
 **/
@ApiModel
@XStreamAlias("recordInfo")
public class RecordInfoBeanFJIrms {

    @ApiModelProperty(value = "字段内容")
    @XStreamImplicit(itemFieldName = "fieldInfo")
    private List<FieldInfoBeanFjIrms> fieldInfo;

    public List<FieldInfoBeanFjIrms> getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(List<FieldInfoBeanFjIrms> fieldInfo) {
        this.fieldInfo = fieldInfo;
    }
}
