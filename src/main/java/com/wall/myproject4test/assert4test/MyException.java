package com.wall.myproject4test.assert4test;

/**
 * 自定义异常
 * @author 郑昌蔚
 * @date 2020-11-24 10:46
 */
public class MyException extends RuntimeException {
    private String code ;
    private Object data ;

    public MyException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getErrorCode();
    }

    public MyException(String msg, ResultCode resultCode) {
        super(msg);
        this.code = resultCode.getErrorCode();
    }

    public <T> MyException(String msg, ResultCode resultCode,T data) {
        super(msg);
        this.data = data;
        this.code = resultCode.getErrorCode();
    }

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

}
