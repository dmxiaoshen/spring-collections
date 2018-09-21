package com.dmxiaoshen.controller.api;

import com.dmxiaoshen.model.Record;
import com.dmxiaoshen.service.RecordService;
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
@RequestMapping("/api/demo3")
public class Demo3ApiController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/record")
    public void add(@RequestParam("productName")String productName, @RequestParam("userName")String userName, @RequestParam("money")BigDecimal money){
        Record record = new Record();
        record.setProductName(productName);
        record.setUserName(userName);
        record.setMoney(money);
        recordService.add(record);
    }
}
