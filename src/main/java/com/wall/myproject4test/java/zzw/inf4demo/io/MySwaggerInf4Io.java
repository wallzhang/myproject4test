package com.wall.myproject4test.java.zzw.inf4demo.io;
import com.wall.myproject4test.java.zzw.inf4demo.io.model.IoRequestOnTxtBean;
import com.wall.myproject4test.java.zzw.inf4demo.io.model.IoRequestOnXlsBean;
import com.wall.myproject4test.java.zzw.inf4demo.io.model.IoReturnBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:个人定制接口-针对IO相关
 * @author: zhang.zw
 * @date: 2020/10/20 14:19
 **/
@Api(description = "个人定制接口-针对IO相关")
@RestController
@RequestMapping("/mySwagger4Io")
public class MySwaggerInf4Io {
    private static Logger logger = LoggerFactory.getLogger(MySwaggerInf4Io.class);
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 数据类型反射map
     **/
    private static Map<String,String> typeMap = new HashMap<>();

    static {
        typeMap.put("Number","Integer");
        typeMap.put("int","Integer");
    }
    @RequestMapping(value = "readFileOnTxt",method = RequestMethod.POST)
    @ApiOperation(value = "读txt文件，按行输出",notes = "读txt文件，按行输出")
    public IoReturnBean readFileOnTxt(@ApiParam(name = "ioRequestOnTxtBean",required = true) @RequestBody IoRequestOnTxtBean ioRequestOnTxtBean){
        long startTime = System.currentTimeMillis();
        IoReturnBean ioReturnBean = new IoReturnBean();
        JSONObject jsonObjectStr = JSONObject.fromObject(ioRequestOnTxtBean);
        if(logger.isInfoEnabled()){
            logger.info("读txt文件，按行输出入参ioRequestOnTxtBean为:"+jsonObjectStr);
        }
        try {
            File file = new File(ioRequestOnTxtBean.getFilePath());
            if(file.exists()){
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line;
                while ((line=br.readLine())!=null){
                    if(logger.isInfoEnabled()){
                        logger.info("line:"+line);
                    }
                }
                br.close();
            }else {
                throw new Exception("传入的文件路径为:" + ioRequestOnTxtBean.getFilePath() + "存在问题请检查！");
            }
            ioReturnBean.setCode("0");
            ioReturnBean.setRes("处理成功");
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            ioReturnBean.setCode("1");
            ioReturnBean.setCode(e.toString());
        }
        long time = System.currentTimeMillis() - startTime;
        ioReturnBean.setDealTime(String.valueOf(time));
        return ioReturnBean;
    }


    @RequestMapping(value = "createCloudBeanCodeByXls",method = RequestMethod.POST)
    @ApiOperation(value = "针对云网业务,输出javaBean属性值",notes = "针对云网业务,输出javaBean属性值")
    public IoReturnBean createCloudBeanCodeByXls(@ApiParam(name = "ioRequestOnXlsBean",required = true) @RequestBody IoRequestOnXlsBean ioRequestOnXlsBean){
        long startTime = System.currentTimeMillis();
        IoReturnBean ioReturnBean = new IoReturnBean();
        JSONObject jsonObjectStr = JSONObject.fromObject(ioRequestOnXlsBean);
        if(logger.isInfoEnabled()){
            logger.info("读xls文件，按行输出入参ioRequestOnXlsBean为:"+jsonObjectStr);
        }
        try {
            String filePath = ioRequestOnXlsBean.getFilePath();
            File excelFile = new File(filePath);
            if(excelFile.exists()){
                // 获取Excel工作簿
                String fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
                FileInputStream inputStream = new FileInputStream(excelFile);
                Workbook workbook = null;
                if (fileType.equalsIgnoreCase(XLS)) {
                    workbook = new HSSFWorkbook(inputStream);
                } else if (fileType.equalsIgnoreCase(XLSX)) {
                    workbook = new XSSFWorkbook(inputStream);
                }else {
                    throw new Exception("文件类型为："+fileType+"错误，请检查!");
                }
                //开始解析,默认读取第一页
                Sheet sheet = workbook.getSheetAt(0);
                StringBuilder st = new StringBuilder();
                // 默认规则第一行第一列为类名
                String ClassName = sheet.getRow(0).getCell(0).getStringCellValue();
                st.append("\n@ApiModel\n" +
                        "public class "+ClassName+" {\n"+
                        "\n");
                // 从第二行开始解析，数据demo：     张三||姓名||String
                Row row = null;
                String templateStr = "    @ApiModelProperty(value = \"{arg0}\",required = true)\n" +
                        "    public {arg1} {arg2};\n" +
                        "\n";
                String resStr = "";
                for (int i = 1; i < sheet.getLastRowNum(); i++){
                    row = sheet.getRow(i);
                    // 属性值
                    String propertyValue = row.getCell(0).getStringCellValue();
                    // 中文描述
                    String propertyDesc = row.getCell(1).getStringCellValue();
                    // 数据类型
                    String propertyType = row.getCell(2).getStringCellValue();
                    // 因为文档内的类型常常存在特别的形式，如String(123)
                    // 所以这边需要做一次校验
                    propertyType = qryTruePropertyType(propertyType);
                    resStr = templateStr.replace("{arg0}",propertyDesc).replace("{arg1}",propertyType)
                            .replace("{arg2}",propertyValue);
                    st.append(resStr);
                }
                st.append("}");
                if(logger.isInfoEnabled()){
                    logger.info("完成类型转换！！转行结果如下");
                    logger.info(st.toString());
                }
            }else {
                throw new Exception("传入的文件路径为:" + ioRequestOnXlsBean.getFilePath() + "存在问题请检查！");
            }
            ioReturnBean.setCode("0");
            ioReturnBean.setRes("处理成功");
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            ioReturnBean.setCode("1");
            ioReturnBean.setCode(e.toString());
        }
        long time = System.currentTimeMillis() - startTime;
        ioReturnBean.setDealTime(String.valueOf(time));
        return ioReturnBean;
    }

    @RequestMapping(value = "createCloudBeanCodeByXls2Sql",method = RequestMethod.POST)
    @ApiOperation(value = "Sql",notes = "Sql")
    public IoReturnBean createCloudBeanCodeByXls2Sql(@ApiParam(name = "ioRequestOnXlsBean",required = true) @RequestBody IoRequestOnXlsBean ioRequestOnXlsBean){
        long startTime = System.currentTimeMillis();
        IoReturnBean ioReturnBean = new IoReturnBean();
        JSONObject jsonObjectStr = JSONObject.fromObject(ioRequestOnXlsBean);
        if(logger.isInfoEnabled()){
            logger.info("读xls文件，按行输出入参ioRequestOnXlsBean为:"+jsonObjectStr);
        }
        try {
            String filePath = ioRequestOnXlsBean.getFilePath();
            File excelFile = new File(filePath);
            if(excelFile.exists()){
                // 获取Excel工作簿
                String fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
                FileInputStream inputStream = new FileInputStream(excelFile);
                Workbook workbook = null;
                if (fileType.equalsIgnoreCase(XLS)) {
                    workbook = new HSSFWorkbook(inputStream);
                } else if (fileType.equalsIgnoreCase(XLSX)) {
                    workbook = new XSSFWorkbook(inputStream);
                }else {
                    throw new Exception("文件类型为："+fileType+"错误，请检查!");
                }
                //开始解析,默认读取第一页
                Sheet sheet = workbook.getSheetAt(0);
                StringBuilder st = new StringBuilder();
                Row row = null;
                String templateStr = "INSERT INTO ISA_COMPANY_NOTE_ASSIGN_MAP SET COMPANY_NAME = '{arg0}' ,NAME = '{arg1}' ,TELEPHONE = '{arg2}',STATE = '10A';\n";
                String resStr = "";
                for (int i = 0; i < sheet.getLastRowNum(); i++){
                    row = sheet.getRow(i);
                    // 公司名
                    String arg0 = row.getCell(0).getStringCellValue();
                    // 主管名称
                    String arg1 = row.getCell(1).getStringCellValue();
                    // 主管电话
                    String arg2 = row.getCell(2).getStringCellValue();
                    // 因为文档内的类型常常存在特别的形式，如String(123)
                    // 所以这边需要做一次校验
//                    propertyType = qryTruePropertyType(propertyType);
                    resStr = templateStr.replace("{arg0}",arg0).replace("{arg1}",arg1)
                            .replace("{arg2}",arg2);
                    st.append(resStr);
                }
                st.append("}");
                if(logger.isInfoEnabled()){
                    logger.info("完成类型转换！！转行结果如下");
                    logger.info(st.toString());
                }
            }else {
                throw new Exception("传入的文件路径为:" + ioRequestOnXlsBean.getFilePath() + "存在问题请检查！");
            }
            ioReturnBean.setCode("0");
            ioReturnBean.setRes("处理成功");
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            ioReturnBean.setCode("1");
            ioReturnBean.setCode(e.toString());
        }
        long time = System.currentTimeMillis() - startTime;
        ioReturnBean.setDealTime(String.valueOf(time));
        return ioReturnBean;
    }

    /**
     * 基于propertyType进行校验
     * @param propertyType
     * @return
     */
    private String qryTruePropertyType(String propertyType) {
        // 第一步删除(之后的数据
        if(propertyType.contains("(")){
            propertyType =  propertyType.substring(0,propertyType.lastIndexOf("("));
        }
        // 第二步用现有的map做一次反射处理
        if(typeMap.containsKey(propertyType)){
            return MapUtils.getString(typeMap,propertyType);
        }else {
            return propertyType;
        }
    }

    @RequestMapping(value = "createMapInput",method = RequestMethod.POST)
    @ApiOperation(value = "海南map插入值",notes = "海南map插入值")
    public IoReturnBean createMapInput(@ApiParam(name = "createMapInput",required = true) @RequestBody IoRequestOnXlsBean ioRequestOnXlsBean){
        long startTime = System.currentTimeMillis();
        IoReturnBean ioReturnBean = new IoReturnBean();
        JSONObject jsonObjectStr = JSONObject.fromObject(ioRequestOnXlsBean);
        if(logger.isInfoEnabled()){
            logger.info("读xls文件，按行输出入参ioRequestOnXlsBean为:"+jsonObjectStr);
        }
        try {
            String filePath = ioRequestOnXlsBean.getFilePath();
            File excelFile = new File(filePath);
            if(excelFile.exists()){
                // 获取Excel工作簿
                String fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
                FileInputStream inputStream = new FileInputStream(excelFile);
                Workbook workbook = null;
                if (fileType.equalsIgnoreCase(XLS)) {
                    workbook = new HSSFWorkbook(inputStream);
                } else if (fileType.equalsIgnoreCase(XLSX)) {
                    workbook = new XSSFWorkbook(inputStream);
                }else {
                    throw new Exception("文件类型为："+fileType+"错误，请检查!");
                }
                //开始解析,默认读取第一页
                Sheet sheet = workbook.getSheetAt(0);
                StringBuilder st = new StringBuilder();
                // 从第二行开始解析，数据demo：     张三||姓名||String
                Row row = null;
//                String templateStr = "paramMap.put(\"{arg0}\",\"{arg1}\");";
                String templateStr = "paramMap.put(\"{arg0}\",{arg1});";
                String resStr = "";
                st.append("\n");
                for (int i = 1; i < sheet.getLastRowNum(); i++){
                    row = sheet.getRow(i);
                    // 属性名
                    String arg0 = row.getCell(0).getStringCellValue();
                    // 属性值
                    String arg1 = row.getCell(1).getStringCellValue();
                    resStr = templateStr.replace("{arg0}",arg0).replace("{arg1}",arg1);
                    st.append(resStr+"\n");
                }
                if(logger.isInfoEnabled()){
                    logger.info("完成类型转换！！转行结果如下");
                    logger.info(st.toString());
                }
            }else {
                throw new Exception("传入的文件路径为:" + ioRequestOnXlsBean.getFilePath() + "存在问题请检查！");
            }
            ioReturnBean.setCode("0");
            ioReturnBean.setRes("处理成功");
        }catch (Exception e){
            logger.error(e.getLocalizedMessage(),e);
            ioReturnBean.setCode("1");
            ioReturnBean.setCode(e.toString());
        }
        long time = System.currentTimeMillis() - startTime;
        ioReturnBean.setDealTime(String.valueOf(time));
        return ioReturnBean;
    }

}
