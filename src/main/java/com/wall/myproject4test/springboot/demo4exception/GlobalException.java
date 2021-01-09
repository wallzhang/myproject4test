package com.wall.myproject4test.springboot.demo4exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/** 
* @Description: 全局异常统一管理
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
@ControllerAdvice
public class GlobalException {

    /**
     * 如果当前类中出现了ArithmeticException异常就会跳转到本方法对应的view中
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView view = new ModelAndView();
        view.addObject("error",e.toString());
        view.setViewName("error2");
        return view;
    }
}
