package com.wall.myproject4test.java.zzw.inf4demo.localdate;

import com.thoughtworks.xstream.XStream;
import com.wall.myproject4test.java.zzw.inf4demo.xstream.model.XsteamDemoReqBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:个人定制接口-localdate(jdk1.8版本新增)
 * 可以减少new Date操作，多线程也安全
 * @author: zhang.zw
 * @date: 2020/11/3 14:19
 **/
@Api(description = "个人定制接口-localdate")
@RestController
@RequestMapping("/mylocaldate")
public class MySwaggerInf4LocalDate {

    private static Logger logger = LoggerFactory.getLogger(MySwaggerInf4LocalDate.class);


    @RequestMapping(value = "qryLocalDate",method = RequestMethod.POST)
    @ApiOperation(value = "查询时间输出格式yyyy-MM-dd",notes = "查询时间输出格式yyyy-MM-dd")
    public String qryLocalDate() {
        long startTime = System.currentTimeMillis();
        LocalDate localDate = LocalDate.now();
        if(logger.isInfoEnabled()){
            logger.info("localDate:" + localDate);
            logger.info("共计耗时:" + String.valueOf(System.currentTimeMillis()-startTime));
        }
        return "localDate:" + localDate;
    }

    @RequestMapping(value = "qryLocalTime",method = RequestMethod.POST)
    @ApiOperation(value = "查询时间输出格式hh-mm-ss.zzz",notes = "查询时间输出格式hh-mm-ss.zzz")
    public String qryLocalTime() {
        long startTime = System.currentTimeMillis();
        LocalTime localTime = LocalTime.now();
        String format = localTime.format(DateTimeFormatter.ofPattern("HH:ss:mm"));
        if(logger.isInfoEnabled()){
            logger.info("localTime:" + localTime);
            logger.info("共计耗时:" + String.valueOf(System.currentTimeMillis()-startTime));
        }
        return "localTime:" + localTime;
    }

    @RequestMapping(value = "qryLocalDateTimeByType",method = RequestMethod.POST)
    @ApiOperation(value = "查询时间输出格式yyyy-mm-dd hh-mm-ss",notes = "查询时间输出格式yyyy-mm-dd hh-mm-ss")
    public String qryLocalDateTime() {
        long startTime = System.currentTimeMillis();
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if(logger.isInfoEnabled()){
            logger.info("localDateTime:" + format);
            logger.info("共计耗时:" + String.valueOf(System.currentTimeMillis()-startTime));
        }
        return "localDateTime:" + format;
    }
}
