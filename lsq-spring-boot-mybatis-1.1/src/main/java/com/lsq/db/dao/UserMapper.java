package com.lsq.db.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lsq.db.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);
    
    @Select("Select * from tuser where id = #{id}")
    User selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}