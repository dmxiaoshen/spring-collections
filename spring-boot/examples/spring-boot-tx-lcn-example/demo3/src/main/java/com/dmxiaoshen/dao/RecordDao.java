package com.dmxiaoshen.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Mapper
public interface RecordDao {

    @Insert("insert into record(product_name,user_name,money) values(#{productName},#{userName},#{money})")
    int insert(@Param("productName")String productName, @Param("userName")String userName, @Param("money")BigDecimal money);
}
