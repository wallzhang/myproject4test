package com.wall.myproject4test.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author: zhang.zw
 * @date: 2020/10/20 10:22
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createShanghaiSdnProxyInterface() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(shanghaiSdnProxyInterface())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wall.myproject4test.java.zzw"))
                .paths(PathSelectors.any())
                .build()
                .groupName("个人定制接口");
    }

    private ApiInfo shanghaiSdnProxyInterface() {
        return new ApiInfoBuilder().title("个人定制接口")
                .description("个人定制接口")
                .termsOfServiceUrl("no terms of service")
                .version("1.0")
                .build();
    }
}
