package com.dmxiaoshen.message.controller.admin;

import com.dmxiaoshen.user.sdk.client.UserClient;
import com.dmxiaoshen.user.sdk.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hzhsg on 2018/8/21.
 */
@RestController
@RequestMapping("/admin/sms")
public class AdminSMSController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/get_user")
    public UserDTO getSMS(@RequestParam("id")String id){
        UserDTO result = userClient.get(id);
        return result;
    }

    @GetMapping("/add_user")
    public UserDTO addSMS(){
        UserDTO dto = new UserDTO();
        dto.setId("2");
        dto.setName("Tom");
        userClient.add(dto);
        return userClient.get("2");
    }
}
