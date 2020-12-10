package com.wall.myproject4test.java.zzw.inf4demo.xstream.model.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @Description:综资request
* @Author: zhang.zw
* @Date: 2020/12/8
*/
@ApiModel
public class CommonRequestBeanOss {

    @ApiModelProperty(value = "工单类别")
    private String sheetType;

    @ApiModelProperty(value = "集团客户业务分类")
    private String serviceType;

    @ApiModelProperty(value = "BSS工单编号")
    private String serialNo;

    @ApiModelProperty(value = "服务提供方，格式为：省份编码_系统名称")
    private String serSupplier;

    @ApiModelProperty(value = "服务调用方，格式为：省份编码_系统名称")
    private String serCaller;

    @ApiModelProperty(value = "服务调用方密码(可选)")
    private String callerPwd;

    @ApiModelProperty(value = "服务调用时间")
    private String callTime;

    @ApiModelProperty(value = "附件信息列表，参见附件信息约定")
    private String attachRef;

    @ApiModelProperty(value = "操作人、派单人")
    private String opPerson;

    @ApiModelProperty(value = "操作人单位、派单人单位")
    private String opCorp;

    @ApiModelProperty(value = "操作人所属部门、派单人所属部门")
    private String opDepart;

    @ApiModelProperty(value = "操作人联系电话、派单人联系电话")
    private String opContact;

    @ApiModelProperty(value = "操作时间")
    private String opTime;

    @ApiModelProperty(value = "详细信息，参见详细信息约定")
    private OpDetailBeanOss opDetail;

    public String getSheetType() {
        return sheetType;
    }

    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSerSupplier() {
        return serSupplier;
    }

    public void setSerSupplier(String serSupplier) {
        this.serSupplier = serSupplier;
    }

    public String getSerCaller() {
        return serCaller;
    }

    public void setSerCaller(String serCaller) {
        this.serCaller = serCaller;
    }

    public String getCallerPwd() {
        return callerPwd;
    }

    public void setCallerPwd(String callerPwd) {
        this.callerPwd = callerPwd;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getAttachRef() {
        return attachRef;
    }

    public void setAttachRef(String attachRef) {
        this.attachRef = attachRef;
    }

    public String getOpPerson() {
        return opPerson;
    }

    public void setOpPerson(String opPerson) {
        this.opPerson = opPerson;
    }

    public String getOpCorp() {
        return opCorp;
    }

    public void setOpCorp(String opCorp) {
        this.opCorp = opCorp;
    }

    public String getOpDepart() {
        return opDepart;
    }

    public void setOpDepart(String opDepart) {
        this.opDepart = opDepart;
    }

    public String getOpContact() {
        return opContact;
    }

    public void setOpContact(String opContact) {
        this.opContact = opContact;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public OpDetailBeanOss getOpDetail() {
        return opDetail;
    }

    public void setOpDetail(OpDetailBeanOss opDetail) {
        this.opDetail = opDetail;
    }
}
