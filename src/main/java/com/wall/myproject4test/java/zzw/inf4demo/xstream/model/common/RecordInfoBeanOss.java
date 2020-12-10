package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.common;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
* @Description: 记录内容
* @Author: zhang.zw
* @Date: 2020/12/8 
*/
@ApiModel
@XStreamAlias("recordInfo")
public class RecordInfoBeanOss {


    @XStreamImplicit(itemFieldName = "fieldInfo")
    @ApiModelProperty(value = "字段内容")
    private List<FieldInfoBeanOss> fieldInfo;

    public List<FieldInfoBeanOss> getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(List<FieldInfoBeanOss> fieldInfo) {
        this.fieldInfo = fieldInfo;
    }
}
