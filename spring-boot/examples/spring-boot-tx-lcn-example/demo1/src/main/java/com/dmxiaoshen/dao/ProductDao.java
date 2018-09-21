package com.dmxiaoshen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Mapper
public interface ProductDao {

    @Update("update product set amount = amount-#{count} where id = #{id}")
    int decrease(@Param("id")String id,@Param("count")int count);
}
