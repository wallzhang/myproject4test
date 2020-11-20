package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:字段内容
 * @author: zhang.zw
 * @date: 2020/10/21 15:35
 **/
@ApiModel
@XStreamAlias("fieldInfo")
public class FieldInfoBeanFjIrms {

    @XStreamAlias("fieldEnName")
    @ApiModelProperty(value = "字段中文名")
    private String fieldEnName;

    @XStreamAlias("fieldContent")
    @ApiModelProperty(value = "字段英文名")
    private String fieldContent;

    @XStreamAlias("fieldChName")
    @ApiModelProperty(value = "字段内容")
    private String fieldChName;

    public String getFieldEnName() {
        return fieldEnName;
    }

    public void setFieldEnName(String fieldEnName) {
        this.fieldEnName = fieldEnName;
    }

    public String getFieldContent() {
        return fieldContent;
    }

    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent;
    }

    public String getFieldChName() {
        return fieldChName;
    }

    public void setFieldChName(String fieldChName) {
        this.fieldChName = fieldChName;
    }
}
