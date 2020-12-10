package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/** 
* @Description: 字段内容
* @Author: zhang.zw
* @Date: 2020/12/8 
*/
@ApiModel
@XStreamAlias("fieldInfo")
public class FieldInfoBeanOss {

    @XStreamAlias("fieldChName")
    @ApiModelProperty(value = "字段中文名")
    private String fieldChName;

    @XStreamAlias("fieldEnName")
    @ApiModelProperty(value = "字段英文名")
    private String fieldEnName;

    @XStreamAlias("fieldContent")
    @ApiModelProperty(value = "字段内容")
    private String fieldContent;

    public String getFieldChName() {
        return fieldChName;
    }

    public void setFieldChName(String fieldChName) {
        this.fieldChName = fieldChName;
    }

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
}
