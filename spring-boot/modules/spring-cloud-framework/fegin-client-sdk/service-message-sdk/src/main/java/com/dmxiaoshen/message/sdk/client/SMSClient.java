package com.dmxiaoshen.message.sdk.client;

import com.dmxiaoshen.message.sdk.dto.SMSMessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzhsg on 2018/8/21.
 */
@FeignClient("service-message")
@Component
public interface SMSClient {

    @GetMapping("/api/sms/get")
    SMSMessageDTO get(@RequestParam("id")String id);

    @PostMapping("/api/sms")
    String add(@RequestBody SMSMessageDTO smsMessageDTO);
}
