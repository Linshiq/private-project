package com.lsq.db.dao;

import java.util.Date;
import java.util.List;

import com.lsq.db.model.DpUserBalance;
import com.lsq.db.model.PersonBalance;

public interface PersonBalanceMapper {

	int deleteByPrimaryKey(Date date);

	int insert(PersonBalance record);

	int insertSelective(PersonBalance record);

	DpUserBalance selectByPrimaryKey(Date date);

	List<PersonBalance> selectAllInfo();

	int updateByPrimaryKeySelective(PersonBalance record);

	int updateByPrimaryKeyWithBLOBs(PersonBalance record);

	int updateByPrimaryKey(PersonBalance record);
}