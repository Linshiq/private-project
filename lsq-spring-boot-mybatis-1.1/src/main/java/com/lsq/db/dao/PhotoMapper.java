package com.lsq.db.dao;

import com.lsq.db.model.Photo;

public interface PhotoMapper {
    int insert(Photo record);

    int insertSelective(Photo record);
}