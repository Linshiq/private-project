package lsq.service.dao;

import java.util.Date;
import java.util.List;

import lsq.model.DpConsumerDetails;

public interface DpConsumerDetailsServiceDao {

	List<DpConsumerDetails> selectAllInfo();

	DpConsumerDetails selectByPrimaryKey(String id);

	List<DpConsumerDetails> selectByDate(Date date);

	List<DpConsumerDetails> selectByMonth(String month);
	
    List<DpConsumerDetails> selectByYear(String year);
	
	int insertSelective(DpConsumerDetails record);
	
}
