package lsq.dao;

import lsq.model.DpUserInfo;

public interface DpUserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DpUserInfo record);

    int insertSelective(DpUserInfo record);

    DpUserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DpUserInfo record);

    int updateByPrimaryKey(DpUserInfo record);
}