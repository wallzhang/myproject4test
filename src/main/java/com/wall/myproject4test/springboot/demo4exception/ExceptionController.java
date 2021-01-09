package com.wall.myproject4test.springboot.demo4exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/** 
* @Description: 异常页面
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
@Controller
@RequestMapping("/exception4demo")
public class ExceptionController {

    @RequestMapping("qry4error")
    public String qry4error(){
        String a = null;
        System.out.println(a.equals("1111"));
        return "success";
    }

    @RequestMapping("qry4error2")
    public String qry4error2(){
        int a = 0;
        int b = 1;
        int c = b/a;
        return "success";
    }
    @ExceptionHandler(value = {NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(Exception e){
        ModelAndView view = new ModelAndView();
        view.addObject("error",e.toString());
        view.setViewName("error1");
        return view;
    }
}
