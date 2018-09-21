package com.dmxiaoshen.controller;

import com.dmxiaoshen.model.User;
import com.dmxiaoshen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by hzhsg on 2018/9/17.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private static int count=1;

    @Autowired
    private UserService userService;

    @PostMapping
    public void add(@RequestBody User user){
        log.info("请求次数="+count++);
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userService.addUser(user);
    }
}
