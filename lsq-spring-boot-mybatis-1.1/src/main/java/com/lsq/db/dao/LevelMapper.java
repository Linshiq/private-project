package com.lsq.db.dao;

import com.lsq.db.model.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}