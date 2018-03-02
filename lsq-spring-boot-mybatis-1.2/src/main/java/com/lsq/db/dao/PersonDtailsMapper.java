package com.lsq.db.dao;

import java.util.List;

import com.lsq.db.model.DpConsumerDetails;
import com.lsq.db.model.PersonDtails;
import com.lsq.db.type.ConsumerDetailsType;

public interface PersonDtailsMapper {
    int insert(PersonDtails record);

    int insertSelective(PersonDtails record);
    
    int deleteByPrimaryKey(String id);

	int insert(DpConsumerDetails record);

	int insertSelective(DpConsumerDetails record);

	DpConsumerDetails selectByPrimaryKey(String id);

	List<PersonDtails> selectByDate(String date);

	List<PersonDtails> selectConsumerInfo(ConsumerDetailsType consumptionDetlType);

	List<String> selectConsumptionType();

	List<PersonDtails> selectConsumerPropInfo(ConsumerDetailsType consumptionDetlType);
	
	int updateByPrimaryKeySelective(PersonDtails record);

	int updateByPrimaryKeyWithBLOBs(PersonDtails record);

	int updateByPrimaryKey(PersonDtails record);
}