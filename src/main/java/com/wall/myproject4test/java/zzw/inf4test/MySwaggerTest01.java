package com.wall.myproject4test.java.zzw.inf4test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(description = "测试01")
@RestController
@RequestMapping("/test")
public class MySwaggerTest01 {

    private static Logger logger =  LoggerFactory.getLogger(MySwaggerTest01.class);
    @ApiOperation(value = "test01", notes = "test01")
    @RequestMapping(value = "mytest/{version}/id",method = RequestMethod.POST)
    public String myTest001(@ApiParam(name = "reqStr",required = true)@RequestBody String reqStr, @PathVariable String version){
        if(logger.isInfoEnabled()){
            logger.info("reqStr:"+reqStr);
            logger.info("version:"+version);
        }
        return reqStr;
    }
}
