package com.wall.myproject4test.spring.jpa;

import com.wall.myproject4test.jpa.pojo.User;
import com.wall.myproject4test.jpa.resposity.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaDemoTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void contextLoads() {
        Optional<User> userOptional =  repository.findById(1);
        if(userOptional.isPresent()){
            System.out.println("存在数据");
        }else {
            System.out.println("不存在数据");
        };
        User user = userOptional.get();
        System.out.println(user.toString());
    }
}
