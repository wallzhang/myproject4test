package com.wall.myproject4test.exam;

import com.wall.myproject4test.java.zzw.io.dto.User;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

public class TestMain {

    @NotNull
    private String abc;
    public static void main(String[] args) {
        String a = null;
        Assert.notNull(a,"为null");
        User user = new User("zs",16);
        Assert.notNull(user,"user null");
    }
}
