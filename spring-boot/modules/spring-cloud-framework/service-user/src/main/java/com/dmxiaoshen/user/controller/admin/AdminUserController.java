package com.dmxiaoshen.user.controller.admin;

import com.dmxiaoshen.message.sdk.client.SMSClient;
import com.dmxiaoshen.message.sdk.dto.SMSMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzhsg on 2018/8/21.
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private SMSClient smsClient;


    @GetMapping("/get_sms")
    public SMSMessageDTO getSMS(@RequestParam("id")String id){
        SMSMessageDTO result = smsClient.get(id);
        return result;
    }

    @GetMapping("/add_sms")
    public SMSMessageDTO addSMS(){
        SMSMessageDTO dto = new SMSMessageDTO();
        dto.setId("2");
        dto.setContent("fegin_add");
        smsClient.add(dto);
        return smsClient.get("2");
    }
}
