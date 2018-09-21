package com.dmxiaoshen.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@FeignClient("demo3")
@Component
public interface Demo3Client {

    @GetMapping("/api/demo3/record")
    void add(@RequestParam("productName")String productName, @RequestParam("userName")String userName, @RequestParam("money")BigDecimal money);
}
