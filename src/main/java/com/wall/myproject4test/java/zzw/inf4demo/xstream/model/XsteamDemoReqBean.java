package com.wall.myproject4test.java.zzw.inf4demo.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: Xstream测试demo类
 * 基础类只包含基本数据类型，不包含数组集合等
 * @author: zhang.zw
 * @date: 2020/10/22 8:32
 **/

@ApiModel
@XStreamAlias("xsteamDemo1")
public class XsteamDemoReqBean {

    @XStreamAlias("attr1")
    @ApiModelProperty(value = "基础属性1")
    private String attr1;

    @XStreamAlias("attr2")
    @ApiModelProperty(value = "基础属性2")
    private String attr2;

    @XStreamAlias("attr3")
    @ApiModelProperty(value = "基础属性3")
    private String attr3;

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }
}
