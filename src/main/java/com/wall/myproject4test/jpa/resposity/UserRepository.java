package com.wall.myproject4test.jpa.resposity;

import com.wall.myproject4test.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
