package com.dmxiaoshen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Mapper
public interface AccountDao {

    @Update("update account set balance=balance - #{amount} where id = #{id}")
    int decrease(@Param("id")String id, @Param("amount")BigDecimal amount);
}
