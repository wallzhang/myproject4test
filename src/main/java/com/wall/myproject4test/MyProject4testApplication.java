package com.wall.myproject4test;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MyProject4testApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MyProject4testApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
//        SpringApplication.run(MyProject4testApplication.class, args);
    }

}
