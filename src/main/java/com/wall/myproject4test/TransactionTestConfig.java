package com.wall.myproject4test;

import com.wall.myproject4test.spring.transaction4study.model.WallDemo;
import com.wall.myproject4test.spring.transaction4study.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan("com.wall.myproject4test.spring.*")
public class TransactionTestConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("zZW@1993");
        return dataSource;
    }

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(TransactionTestConfig.class);
        IUserService bean = app.getBean(IUserService.class);
//        WallDemo wallDemo = new WallDemo();
//        wallDemo.setId(1);
//        wallDemo.setAge(18);
//        wallDemo.setName("wall");
//        bean.insertWallDemo(wallDemo);
        List<WallDemo> list = bean.queryWallDemoAll();
        System.out.println("list:" +list);

    }
}
