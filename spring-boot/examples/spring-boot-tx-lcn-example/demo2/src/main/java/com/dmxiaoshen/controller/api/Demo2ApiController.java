package com.dmxiaoshen.controller.api;

import com.dmxiaoshen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@RestController
@RequestMapping("/api/demo2")
public class Demo2ApiController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/balance")
    public void decreaseBalance(@RequestParam("id")String id, @RequestParam("amount")BigDecimal amount){
        accountService.decreaseBalance(id,amount);
    }
}
