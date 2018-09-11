package com.dmxiaoshen.activiti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzhsg on 2018/6/11.
 */
@RestController
@RequestMapping("/deployment")
public class DeploymentController {

    @GetMapping("/test")
    public String deploy(){
        return "success";
    }
}
