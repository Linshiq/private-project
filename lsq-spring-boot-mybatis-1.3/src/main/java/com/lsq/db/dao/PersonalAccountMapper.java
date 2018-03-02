package com.lsq.db.dao;

import java.util.List;

import com.lsq.db.model.PersonalAccount;

public interface PersonalAccountMapper {

	List<PersonalAccount> selectInfo(PersonalAccount personalAccount);
	
	int selectMaxSortNo(String name);
	
	int insert(PersonalAccount record);

	int insertSelective(PersonalAccount record);

}