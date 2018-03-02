package com.lsq.db.dao;

import java.util.List;

import com.lsq.db.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);
    
    User selectByPrimaryKey(String id);
    
    List<User> selectAllInfo();
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}