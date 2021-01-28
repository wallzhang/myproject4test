package com.wall.myproject4test.assert4test;

import java.io.Serializable;

/**
 * 分页结果集
 * @author 郑昌蔚
 * @date 2020-11-13 13:00:00
 */
@SuppressWarnings("all")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5290272070619177919L;

    /**
     * 成功或者失败
     */
    private boolean success;
    /**
     * 提示消息
     */
    private String message;
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 表示数据
     */
    private T data;
    /**
     * 错误码，5位
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;

    private Result() {

    }

    private Result(ResultCode resultCode, Long total, T data) {
        this.message = resultCode.getMsg();
        this.success = resultCode.getSuccess();
        this.errorCode = resultCode.getErrorCode();
        this.errorMessage = resultCode.getMsg();
        this.total = total;
        this.data = data;
    }

    private Result(String message, ResultCode resultCode, Long total, T data) {
        this.message = message;
        this.success = resultCode.getSuccess();
        this.errorCode = resultCode.getErrorCode();
        this.errorMessage = resultCode.getMsg();
        this.total = total;
        this.data = data;
    }

    public Result(boolean success, String message, String errorCode, String errorMessage) {
        this.success =success;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.total = 0L;
        this.data = null;
    }

    public Result(boolean b, String message, String errorCode, String errorMessage, T obj) {
        this.success =success;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.total = 0L;
        this.data = obj;
    }

    public Result(String message, ResultCode resultCode, long l, T o) {
        this.message = message;
        this.errorMessage = resultCode.getMsg();
        this.success = resultCode.getSuccess();
        this.errorCode = resultCode.getErrorCode();
        this.total = l;
        this.data = o;
    }

    public static Result error(String message) {
        return new Result(false,"500",message);
    }




    private Result(Long total, T data) {
        this.message = ResultCode.SUCCESS_FOUND.getMsg();
        this.data = data;
        this.total = total;
        this.errorMessage = message;
        this.errorCode = ResultCode.SUCCESS_FOUND.getErrorCode();
    }

    /**
     * 成功,无数据返回,指定返回用户信息
     * 使用枚举类
     */
    public static Result ok(String message, ResultCode resultCode){
        return new Result(message, resultCode,(long)0,null);
    }

    /**
     * 成功,无数据返回
     * 使用枚举类
     */
    public static Result ok(ResultCode resultCode){
        return new Result(resultCode,(long)0,null);
    }

    /**
     * 服务器分页成功
     * 使用枚举类
     */
    public static <T> Result okByPage(Long total, T data){
        return new Result(total, data);
    }

    /**
     * 请求成功,返回参数
     * 使用枚举类
     */
    public static <T> Result ok(ResultCode resultCode,Long total, T data){
        return new Result(resultCode,total,data);
    }

    /**
     * 请求成功,返回参数,指定返回用户消息
     * 使用枚举类
     */
    public static <T> Result ok(String message ,ResultCode resultCode,Long total, T data){
        return new Result(message, resultCode,total,data);
    }

    /**
     * 请求失败,无参数返回
     * 使用枚举类
     */
    public static Result error(ResultCode resultCode){
        return new Result(resultCode,(long)0,null);
    }

    /**
     * 请求失败,有参数返回
     * 使用枚举类
     */
    public static <T> Result error(ResultCode resultCode, Long total, T data){
        return new Result(resultCode,total,data);
    }

    public static <T> Result error(String message, String errorMessage, String errorCode, T obj) {
        return new Result(false,message,errorCode, errorMessage,obj);
    }

    public static Result error(String errorMessage,String errorCode) {
        return new Result(false,errorCode, errorMessage);
    }

    public static Result error(String message, String errorMessage,String errorCode) {
        return new Result(false,message,errorCode, errorMessage);
    }

    public static <T> Result error(String message,String errorCode,T data) {
        return new Result(false,message,errorCode,message, data);
    }




    /**
     * 返回执行成功/失败
     */
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    /**
     * 返回执行成功/失败含状态码
     */
    public Result(boolean success, String errorCode, String errorMessage) {
        this.success = success;
        this.message = errorMessage;
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.total = 0L;
        this.data = null;
    }

    /**
     * 返回执行成功/失败含数据
     */
    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    /**
     * 返回执行成功/失败 含数据和状态码
     */
    public Result(boolean success, String message, T data, String errorCode, String errorMessage) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    /**
     * 分页查询返回结果
     */
    public Result(boolean success, String message, Long total, T data) {
        this.success = success;
        this.message = message;
        this.total = total;
        this.data = data;
    }

    /**
     * 分页查询返回结果含状态码
     */
    public Result(boolean success, String message, Long total, T data, String errorCode, String errorMessage) {
        this.success = success;
        this.message = message;
        this.total = total;
        this.data = data;
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Result(" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", total=" + total +
                ", data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ')';
    }
}