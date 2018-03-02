package com.lsq.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.lsq.db.model.DpConsumerDetails;
import com.lsq.db.sql.DynamicQuery;

public interface DpConsumerDetailsMapper {
	int deleteByPrimaryKey(String id);

	int insert(DpConsumerDetails record);

	int insertSelective(DpConsumerDetails record);

	DpConsumerDetails selectByPrimaryKey(String id);

	@Select("Select * from dp_consumer_details where date = #{date,jdbcType=DATE}")
	List<DpConsumerDetails> selectByDate(String data);

	/*
	 * @Select(
	 * "Select * from dp_consumer_details where date like #{month,jdbcType=DATE}"
	 * )
	 */
	@SelectProvider(type = DynamicQuery.class, method = "findConsumerDetailsDateSql")
	List<DpConsumerDetails> selectByMonth(String consumerType,String date);

	@Select("Select DISTINCT CONSUMPTION_TYPE from dp_consumer_details order by CONSUMPTION_TYPE")
	List<String> selectConsumptionType();

	int updateByPrimaryKeySelective(DpConsumerDetails record);

	int updateByPrimaryKeyWithBLOBs(DpConsumerDetails record);

	int updateByPrimaryKey(DpConsumerDetails record);
}