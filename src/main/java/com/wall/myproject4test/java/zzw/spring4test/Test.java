package com.wall.myproject4test.java.zzw.spring4test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Api
@Controller
@RequestMapping("test")
public class Test {

    @RequestMapping("qryByMap")
    @ApiOperation("qryByMap")
    public void qryByMap(Map map){
        System.out.println(map);
    }

//    static String str = "{\n" +
//            "    \"RemNewPon\": {\n" +
//            "        \" cityId\": \"108\",\n" +
//            "        \" exchId\": \" 10801\",\n" +
//            "        \" flowId\": \"10001221\",\n" +
//            "\" deviceCode\": \"H2-01\",\n" +
//            "\" deviceIP\": \"119.1.1.2\",\n" +
//            "        \" address \": \"海口市_龙华区_南海大道58号海口电信局\",\n" +
//            "        \" description\": \" OLT设备往上（包含OLT设备）可能出现故障\",\n" +
//            "        \" faultReason\": \"可能原因为该设备光衰超阀\"\n" +
//            "    }\n" +
//            "}";
//    public static void main(String[] args) {
//        Map map = GsonUtils.toMap(str);
//    }
}
