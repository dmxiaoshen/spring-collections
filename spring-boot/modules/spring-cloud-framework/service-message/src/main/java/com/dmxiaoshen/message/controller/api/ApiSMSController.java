package com.dmxiaoshen.message.controller.api;

import com.dmxiaoshen.message.domain.SMSMessage;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhsg on 2018/8/21.
 */
@RestController
@RequestMapping("/api/sms")
public class ApiSMSController {

    public static Map<String,SMSMessage> smsMessageMap = new HashMap<>();

    static{
        SMSMessage smsMessage = new SMSMessage();
        smsMessage.setId("1");
        smsMessage.setContent("hello world");
        smsMessage.setSendBy("admin");
        smsMessage.setReceiveCellphone("13567895645");
        smsMessage.setRemarks("remarks1");
        smsMessageMap.put(smsMessage.getId(),smsMessage);
    }

    @GetMapping("/get")
    public SMSMessage get(@RequestParam("id")String id){
        return smsMessageMap.get(id);
    }

    @PostMapping
    public String add(@RequestBody SMSMessage smsMessage){
        smsMessageMap.put(smsMessage.getId(),smsMessage);
        return smsMessage.getId();
    }
}
