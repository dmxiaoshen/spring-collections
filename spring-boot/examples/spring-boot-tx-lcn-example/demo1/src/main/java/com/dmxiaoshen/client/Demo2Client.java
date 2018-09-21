package com.dmxiaoshen.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@FeignClient("demo2")
@Component
public interface Demo2Client {

    @GetMapping("/api/demo2/balance")
    void decreaseBalance(@RequestParam("id")String id, @RequestParam("amount")BigDecimal amount);

}
