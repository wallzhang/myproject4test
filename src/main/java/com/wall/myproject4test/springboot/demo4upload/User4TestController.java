package com.wall.myproject4test.springboot.demo4upload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/** 
* @Description: 文件上传下载
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
@RestController
@RequestMapping(("/user4test"))
public class User4TestController {

    @RequestMapping("/upload")
    public String upload(MultipartFile upload,String username) throws IOException {
        System.out.println("username:"+username +" ,upload:" + upload.getOriginalFilename());
        upload.transferTo(new File("D:/"+upload.getOriginalFilename()));
        return "success";
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("D://test.png");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
        InputStream in = null;
        ServletOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = response.getOutputStream();
            // 循环读取
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = in.read(bytes))!=-1){
                out.write(bytes,0,length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            in.close();
            out.flush();
            out.close();
        }
    }
}
