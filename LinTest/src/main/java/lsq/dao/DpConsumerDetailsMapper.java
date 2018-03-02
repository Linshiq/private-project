package lsq.dao;

import java.util.Date;
import java.util.List;

import lsq.model.DpConsumerDetails;

public interface DpConsumerDetailsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DpConsumerDetails record);

    int insertSelective(DpConsumerDetails record);

    DpConsumerDetails selectByPrimaryKey(String id);
    
    List<DpConsumerDetails> selectAllInfo();
    
    List<DpConsumerDetails> selectByDate(Date date);
    
    List<DpConsumerDetails> selectByMonth(String month);
    
    List<DpConsumerDetails> selectByYear(String year);

    int updateByPrimaryKeySelective(DpConsumerDetails record);

    int updateByPrimaryKeyWithBLOBs(DpConsumerDetails record);

    int updateByPrimaryKey(DpConsumerDetails record);
}