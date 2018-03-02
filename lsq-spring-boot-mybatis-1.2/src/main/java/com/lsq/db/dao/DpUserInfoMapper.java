package com.lsq.db.dao;

import com.lsq.db.model.DpUserInfo;
import com.lsq.db.model.DpUserInfoKey;

public interface DpUserInfoMapper {
    int deleteByPrimaryKey(DpUserInfoKey key);

    int insert(DpUserInfo record);

    int insertSelective(DpUserInfo record);

    DpUserInfo selectByPrimaryKey(DpUserInfoKey key);

    int updateByPrimaryKeySelective(DpUserInfo record);

    int updateByPrimaryKey(DpUserInfo record);
}