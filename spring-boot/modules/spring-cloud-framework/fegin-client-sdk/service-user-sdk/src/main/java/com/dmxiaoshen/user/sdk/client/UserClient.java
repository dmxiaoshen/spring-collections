package com.dmxiaoshen.user.sdk.client;

import com.dmxiaoshen.user.sdk.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hzhsg on 2018/8/21.
 */
@FeignClient("service-user")
@Component
public interface UserClient {

    @GetMapping("/api/user/get")
    UserDTO get(@RequestParam("id")String id);

    @PostMapping("/api/user")
    String add(@RequestBody UserDTO userDTO);
}
