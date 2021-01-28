package com.wall.myproject4test.assert4test;

/**
 * 统一返回错误码枚举类
 * @author 郑昌蔚
 * @date 2020/11/13 13:13
 */
public enum ResultCode {
    /**
     * 用于查询成功后
     */
    SUCCESS_FOUND("查询成功","A0000",true),
    /**
     * 用于Excel导入成功后
     */
    SUCCESS_UPLOAD_EXCEL("Excel导入成功","A0000",true),

    /**
     * 用于删除成功后
     */
    SUCCESS_DELETE("删除成功","A0000",true),
    /**
     * 用于修改成功后
     */
    SUCCESS_UPDATE("修改成功","A0000",true),
    /**
     * 用于添加成功后
     */
    SUCCESS_INSERT("添加成功","A0000",true),
    /**
     * 用于上传成功后
     */
    SUCCESS_UPLOAD("上传成功","A0000",true),
    /**
     * 字段校验类异常
     */
    ERROR_VALID("字段校验异常","A0001",false),
    /**
     * 未找到异常
     */
    NOT_FOUND("请求资源未找到","A0404",false),
    /**
     * 输入参数空指针异常
     */
    NOT_EMPTY("参数不能为空","A0002",false),
    /**
     * 时间类异常
     */
    TIME_NOT_EMPTY("时间不能为空","A0003",false),
    /**
     * 时间类超出范围异常
     */
    TIME_MORE_THAN_DAYS("输入时间超出范围","A0004",false),
    /**
     * openId不能为空
     */
    OPENID_NOT_EMPTY("OpenId不能为空","A0005",false),
    /**
     * token为空
     */
    TOKEN_NOT_EMPTY("token不能为空","A0006",false),
    /**
     * token验证异常
     */
    TOKEN_VALID_ERROR("token验证异常","A0007",false),
    /**
     * 数据库异常
     */
    ERROR_DATABASE("数据库异常","A0008",false),
    /**
     * 参数类型错误
     */
    ERROR_PARAM_TYPE("参数类型错误,请检查传入参数类型","A0009",false),
    /**
     * 参数只能为空
     */
    PARAM_ONLY_NULL("该参数参数只能为空","A0010",false),
    /**
     * 不能为空并且必须要有参数
     */
    NO_NULL_ELEMENTS("传入数组中元素不能为空","A0011",false),
    /**
     * 传入的集合不能为空
     */
    COLLECTION_NOT_NULL("传入集合不能为空","A0012",false),
    /**
     * 用于Excel导入失败
     */
    ERROR_UPLOAD_EXCEL("Excel导入失败","A00013",false),
    /**
     * 没有数据时返回
     */
    NO_ELEMENT("没有任何数据","A0014",true),
    /**
     * json转化异常
     */
    JSON_FORMAT_EXCEPT("json转化异常,请确定传入是否json格式","A0015",false),
    /**
     * 上传失败
     */
    ERROR_UPLOAD("上传失败","A0016",false),
    /**
     * 上传部分失败
     */
    PART_ERROR_UPLOAD("部分上传失败","A00017",false),
    /**
     * 用于删除成功后
     */
    ERROR_DELETE("删除失败","A0018",false);

    private  String msg;
    private  String errorCode;
    private boolean success;

    ResultCode() {
    }

    ResultCode(String msg, String errorCode, boolean success) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.success = success;
    }

    public  String getMsg() {
        return msg;
    }


    public String getErrorCode() {
        return errorCode;
    }


    @Override
    public String toString() {
        return "ResultCode{" +
                "msg='" + msg + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

    public boolean getSuccess() {
        return success;
    }
}
