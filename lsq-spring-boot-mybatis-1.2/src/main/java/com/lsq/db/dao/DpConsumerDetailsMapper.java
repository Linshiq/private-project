package com.lsq.db.dao;

import java.util.List;

import com.lsq.db.model.DpConsumerDetails;
import com.lsq.db.type.ConsumerDetailsType;

public interface DpConsumerDetailsMapper {
	int deleteByPrimaryKey(String id);

	int insert(DpConsumerDetails record);

	int insertSelective(DpConsumerDetails record);

	DpConsumerDetails selectByPrimaryKey(String id);

	List<DpConsumerDetails> selectByDate(String date);

	List<DpConsumerDetails> selectConsumerInfo(ConsumerDetailsType consumptionDetlType);

	List<String> selectConsumptionType();

	List<DpConsumerDetails> selectConsumerPropInfo(ConsumerDetailsType consumptionDetlType);
	
	int updateByPrimaryKeySelective(DpConsumerDetails record);

	int updateByPrimaryKeyWithBLOBs(DpConsumerDetails record);

	int updateByPrimaryKey(DpConsumerDetails record);
}