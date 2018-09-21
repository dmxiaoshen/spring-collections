package com.dmxiaoshen.service;
import com.dmxiaoshen.model.User;
import com.github.pagehelper.PageInfo;

/**
 * Created by hzhsg on 2018/1/9.
 */
public interface UserService {

    User getUser(String id);

    int addUser(User user);

    int updateUser(User user);

    PageInfo<User> page(int pageNum, int pageSize);
}
