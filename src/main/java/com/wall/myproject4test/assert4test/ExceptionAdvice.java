package com.wall.myproject4test.assert4test;

import com.alibaba.fastjson.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 统一异常处理
 * @author 郑昌蔚
 * @date 2020/9/9 14:05
 */
@RestControllerAdvice
public class ExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(MyException.class)
    public Result myException( MyException ex) {
        // 获取除了错误码的信息
        log.error("异常为消息为: "+ex.getMessage());

        // 如果异常中有数据
        if (ex.getData()!=null){
            return Result.error(ex.getMessage(),ex.getCode(),ex.getData());
        }

        return Result.error(ex.getMessage(),ex.getCode());
    }

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result illegalArgumentException( IllegalArgumentException ex) {
        // 获取除了错误码的信息
        log.error("异常为消息为: "+ex.getMessage());

        return Result.error(ex.getMessage());
    }

    /**
     * 数据库异常处理
     *
     */
    @ExceptionHandler(SQLException.class)
    public Result sqlException(SQLException e) {
        log.error("异常为消息为: "+e.getMessage()+" 异常sql: "+e.getSQLState());
        return Result.error(ResultCode.ERROR_DATABASE);
    }

    /**
     * 空指针异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerException(NullPointerException e) {
        log.error("异常为消息为: "+e.getMessage());
        return Result.error(ResultCode.NOT_EMPTY);
    }
    /**
     * json转化异常
     */
    @ExceptionHandler(JSONException.class)
    public Result jsonException(JSONException e) {
        log.error("异常为消息为: "+e.getMessage());
        return Result.error(ResultCode.JSON_FORMAT_EXCEPT);
    }

    /**
     * 数组越界异常
     * @param e 异常
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsException(IndexOutOfBoundsException e) {
        log.error("异常为消息为: "+e.getMessage());

        return Result.error("数组越界，请查询所办任务是否已完成!");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("异常为消息为: "+e.getMessage());

        return Result.error("请求方式出现错误,请检查接口访问方式,例如:GET,POST,PUT,DELETE...");
    }

    /**
     * 数据转化异常处理
     */
    @ExceptionHandler(NumberFormatException.class)
    public Result numberFormatException(NumberFormatException e) {
        log.error("异常为消息为: "+e.getMessage());

        return Result.error(ResultCode.ERROR_PARAM_TYPE);
    }

    /**
     * 系统未处理到的异常
     */
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        log.error("异常为消息为: "+e.getMessage());

        return Result.error("系统出现异常,请联系管理员!");
    }




}
