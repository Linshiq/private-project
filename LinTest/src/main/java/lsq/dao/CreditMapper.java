package lsq.dao;

import lsq.model.Credit;

public interface CreditMapper {
    int deleteByPrimaryKey(String id);

    int insert(Credit record);

    int insertSelective(Credit record);

    Credit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Credit record);

    int updateByPrimaryKey(Credit record);
}