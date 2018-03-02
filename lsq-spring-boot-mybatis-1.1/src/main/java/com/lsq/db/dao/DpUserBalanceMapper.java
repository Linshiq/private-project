package com.lsq.db.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lsq.db.model.DpUserBalance;

public interface DpUserBalanceMapper {
    int deleteByPrimaryKey(Date date);

    int insert(DpUserBalance record);

    int insertSelective(DpUserBalance record);

    DpUserBalance selectByPrimaryKey(Date date);
    
    @Select("Select * from dp_user_balance order by date")
    List<DpUserBalance> selectAllInfo();
    
    int updateByPrimaryKeySelective(DpUserBalance record);

    int updateByPrimaryKeyWithBLOBs(DpUserBalance record);

    int updateByPrimaryKey(DpUserBalance record);
}