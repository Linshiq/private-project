package lsq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsq.dao.DpUserBalanceMapper;
import lsq.model.DpUserBalance;
import lsq.service.dao.DpUserBalanceServiceDao;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月22日 上午11:15:14 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月22日-上午11:15:14</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Service("ldpaZhhaoyeService")
public class DpUserBalanceServiceImpl implements DpUserBalanceServiceDao {
	@Autowired
	private DpUserBalanceMapper ldpaZhhaoyeMapper;
	
	public DpUserBalanceMapper getLdpaZhhaoyeMapper() {
		return ldpaZhhaoyeMapper;
	}
//	@Autowired
//	public void setLdpaZhhaoyeMapper(DpUserBalanceMapper ldpaZhhaoyeMapper) {
//		this.ldpaZhhaoyeMapper = ldpaZhhaoyeMapper;
//	}
	@Override
	public int insertSelective(DpUserBalance record) {
		// TODO Auto-generated method stub
		return ldpaZhhaoyeMapper.insertSelective(record);
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.DpUserBalanceServiceDao#insert(lsq.model.DpUserBalance)
	 */
	@Override
	public int insert(DpUserBalance record) {
		// TODO Auto-generated method stub
		return ldpaZhhaoyeMapper.insert(record);
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.DpUserBalanceServiceDao#selectAllInfo()
	 */
	@Override
	public List<DpUserBalance> selectAllInfo() {
		// TODO Auto-generated method stub
		return ldpaZhhaoyeMapper.selectAllInfo();
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.DpUserBalanceServiceDao#selectByMonth(java.lang.String)
	 */
	@Override
	public List<DpUserBalance> selectByMonth(String month) {
		// TODO Auto-generated method stub
		return ldpaZhhaoyeMapper.selectByMonth("%-"+month+"-%");
	}

}
