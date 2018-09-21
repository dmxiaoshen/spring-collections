package com.dmxiaoshen.service.impl;


import com.dmxiaoshen.dao.UserDao;
import com.dmxiaoshen.model.User;
import com.dmxiaoshen.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.mengyun.tcctransaction.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;

/**
 * Created by hzhsg on 2018/1/9.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    @Compensable(cancelMethod = "cancel")
    public int addUser(User user) {
        log.info("add user id="+user.getId());
        if(new Random().nextInt(100)<50){
            throw new RuntimeException("add system error userId="+user.getId());
        }
        return userDao.insertSelective(user);
    }

    public int cancel(User user){
        log.info("cancel user id="+user.getId());
        if(new Random().nextInt(100)<2){
            throw new RuntimeException("cancel system error userId="+user.getId());
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
