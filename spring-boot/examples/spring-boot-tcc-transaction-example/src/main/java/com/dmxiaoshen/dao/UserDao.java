package com.dmxiaoshen.dao;



import com.dmxiaoshen.model.User;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    User getUserSimple(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();
}