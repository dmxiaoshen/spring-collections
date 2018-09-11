package com.dmxiaoshen.service.impl;


import com.dmxiaoshen.dao.UserDao;
import com.dmxiaoshen.model.User;
import com.dmxiaoshen.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by hzhsg on 2018/1/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        if(user.getId()==null || "".equals(user.getId().trim())) {
            user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        return userDao.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public PageInfo<User> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(userDao.selectAll());
    }
}
