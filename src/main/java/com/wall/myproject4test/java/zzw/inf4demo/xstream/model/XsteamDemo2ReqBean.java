package com.wall.myproject4test.java.zzw.inf4demo.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @description: Xstream测试demo类
 * 基础类只包含基本数据类型，包含数组集合等
 * @author: zhang.zw
 * @date: 2020/10/22 8:32
 **/

@ApiModel
@XStreamAlias("xsteamDemo2")
public class XsteamDemo2ReqBean {

    @XStreamAlias("attr1")
    @ApiModelProperty(value = "基础属性1")
    private String attr1;

    @XStreamAlias("attr_att2")
    @ApiModelProperty(value = "基础属性2")
    private String attr_att2;

    @XStreamAlias("attr3")
    @ApiModelProperty(value = "基础属性3")
    private String attr3;

    @XStreamAlias("attrList1")
    @ApiModelProperty(value = "基础属性队列1")
    private List<String> attrList1;

    @XStreamImplicit(itemFieldName = "beanList1")
    @ApiModelProperty(value = "bean属性队列1")
    private List<XsteamDemoReqBean> beanList1;
    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr_att2() {
        return attr_att2;
    }

    public void setAttr_att2(String attr_att2) {
        this.attr_att2 = attr_att2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public List<String> getAttrList1() {
        return attrList1;
    }

    public void setAttrList1(List<String> attrList1) {
        this.attrList1 = attrList1;
    }

    public List<XsteamDemoReqBean> getBeanList1() {
        return beanList1;
    }

    public void setBeanList1(List<XsteamDemoReqBean> beanList1) {
        this.beanList1 = beanList1;
    }
}
