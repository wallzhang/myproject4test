package com.wall.myproject4test.java.zzw.inf4demo.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.wall.myproject4test.java.zzw.inf4demo.utils.ParseUtil;
import com.wall.myproject4test.java.zzw.inf4demo.xstream.model.XsteamDemo2ReqBean;
import com.wall.myproject4test.java.zzw.inf4demo.xstream.model.XsteamDemo3ReqBean;
import com.wall.myproject4test.java.zzw.inf4demo.xstream.model.XsteamDemoReqBean;
import com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel.FieldInfoBeanFjIrms;
import com.wall.myproject4test.java.zzw.inf4demo.xstream.model.irmsmodel.OpDetailBeanFjIrms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.lang.StringUtils;
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
 * @description:基于Xstream的测试类
 * @author: zhang.zw
 * @date: 2020/10/22 8:26
 **/
@Api
@RestController
@RequestMapping("/mySwaggerInf4Xstream")
public class MySwaggerInf4Xstream {
    private static Logger logger = LoggerFactory.getLogger(MySwaggerInf4Xstream.class);


    @RequestMapping(value = "tranXmlByBaseBean",method = RequestMethod.POST)
    @ApiOperation(value = "基于javaBean(只包含基础属性，不包含数组集合)，按行xml",notes = "基于javaBean基于javaBean(只包含基础属性，不包含数组集合)，按行xml")
    public String tranXmlByBaseBean(@ApiParam(name = "tranXmlByBean",value = "基于javaBean，按行xml",required = true) @RequestBody XsteamDemoReqBean xsteamDemoReqBean) {
        long startTime = System.currentTimeMillis();
        XStream xstream = new XStream();
        xstream.processAnnotations(XsteamDemoReqBean.class);
        String xml = xstream.toXML(xsteamDemoReqBean);
        long costTime = System.currentTimeMillis() -  startTime;
        if(logger.isInfoEnabled()){
            logger.info("MySwaggerInf4Xstream.tranXmlByBaseBean共计耗时:" + costTime);
            logger.info("MySwaggerInf4Xstream.tranXmlByBaseBean返回XML:" + xml);
        }
        return xml;
    }

    @RequestMapping(value = "tranXmlByComplexBean",method = RequestMethod.POST)
    @ApiOperation(value = "基于javaBean(包含数组队列等)，按行xml",notes = "基于javaBean基于javaBean(包含数组队列等)，按行xml")
    public String tranXmlByComplexBean(@ApiParam(name = "tranXmlByBean",value = "基于javaBean，按行xml",required = true) @RequestBody XsteamDemo2ReqBean xsteamDemo2ReqBean) {
        long startTime = System.currentTimeMillis();
        XStream xstream = new XStream(new Xpp3Driver(new NoNameCoder()));
        xstream.processAnnotations(XsteamDemo2ReqBean.class);
        String xml = xstream.toXML(xsteamDemo2ReqBean);
        long costTime = System.currentTimeMillis() -  startTime;
        if(logger.isInfoEnabled()){
            logger.info("MySwaggerInf4Xstream.tranXmlByComplexBean共计耗时:" + costTime);
            logger.info("MySwaggerInf4Xstream.tranXmlByComplexBean返回XML:" + xml);
        }
        return xml;
    }

    @RequestMapping(value = "tranXmlToBean",method = RequestMethod.POST)
    @ApiOperation(value = "将xml转换成javabean",notes = "将xml转换成javabean")
    public OpDetailBeanFjIrms tranXmlToBean(@ApiParam(name = "tranXmlToBean",value = "将xml转换成javabean",required = true) @RequestBody String xmlStr) {
        long startTime = System.currentTimeMillis();
        try {
            String xml2Json = ParseUtil.xml2Json(xmlStr);
            logger.info("xml2Json:"+xml2Json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        XStream xstream = new XStream();

        xstream.processAnnotations(OpDetailBeanFjIrms.class);
        OpDetailBeanFjIrms opDetailBeanFjIrms = (OpDetailBeanFjIrms)xstream.fromXML(xmlStr);
        long costTime = System.currentTimeMillis() -  startTime;
        if(logger.isInfoEnabled()){
            logger.info("MySwaggerInf4Xstream.tranXmlToBean共计耗时:" + costTime);
            logger.info("MySwaggerInf4Xstream.tranXmlToBean返回XML:" + opDetailBeanFjIrms);
        }
        return opDetailBeanFjIrms;
    }
}
