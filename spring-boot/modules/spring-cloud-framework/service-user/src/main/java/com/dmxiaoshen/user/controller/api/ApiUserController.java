package com.dmxiaoshen.user.controller.api;

import com.dmxiaoshen.user.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhsg on 2018/8/21.
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    public static Map<String,User> userMap = new HashMap<>();
    static {
        User u1 = new User();
        u1.setId("1");
        u1.setName("lucy");
        u1.setCellphone("13565657890");
        u1.setAge(13);
        u1.setAddress("shang hai");
        userMap.put(u1.getId(),u1);
    }

    @GetMapping("/get")
    public User get(@RequestParam("id")String id){
        return userMap.get(id);
    }

    @PostMapping
    public String add(@RequestBody User user){
        userMap.put(user.getId(),user);
        return user.getId();
    }
}
