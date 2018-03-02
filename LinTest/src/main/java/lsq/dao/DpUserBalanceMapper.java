package lsq.dao;

import java.util.Date;
import java.util.List;

import lsq.model.DpUserBalance;

public interface DpUserBalanceMapper {
    int deleteByPrimaryKey(Date date);

    int insert(DpUserBalance record);

    int insertSelective(DpUserBalance record);

    DpUserBalance selectByPrimaryKey(Date date);
    
    List<DpUserBalance> selectAllInfo();
    
    List<DpUserBalance> selectByMonth(String month);

    int updateByPrimaryKeySelective(DpUserBalance record);

    int updateByPrimaryKeyWithBLOBs(DpUserBalance record);

    int updateByPrimaryKey(DpUserBalance record);
}