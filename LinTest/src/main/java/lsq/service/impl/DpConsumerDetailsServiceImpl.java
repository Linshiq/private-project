package lsq.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsq.dao.DpConsumerDetailsMapper;
import lsq.model.DpConsumerDetails;
import lsq.service.dao.DpConsumerDetailsServiceDao;

@Service("ldpaMtxfjlService")
public class DpConsumerDetailsServiceImpl implements DpConsumerDetailsServiceDao {

	@Autowired
	private DpConsumerDetailsMapper ldpaMtxfjlbMapper; //必须为私有 视频教程55:47处
	
	
	public DpConsumerDetailsMapper getLdpaMtxfjlbMapper() {
		return ldpaMtxfjlbMapper;
	}

//	@Autowired
//	public void setLdpaMtxfjlbMapper(DpConsumerDetailsMapper ldpaMtxfjlbMapper) {
//		DpConsumerDetailsServiceImpl.ldpaMtxfjlbMapper = ldpaMtxfjlbMapper;
//	}


	@Override
	public List<DpConsumerDetails> selectAllInfo() {
		
		return ldpaMtxfjlbMapper.selectAllInfo();
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.DpConsumerDetailsServiceDao#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public DpConsumerDetails selectByPrimaryKey(String id) {

		return ldpaMtxfjlbMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.DpConsumerDetailsServiceDao#selectByDate(java.util.Date)
	 */
	@Override
	public List<DpConsumerDetails> selectByDate(Date date) {

		return ldpaMtxfjlbMapper.selectByDate(date);
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.DpConsumerDetailsServiceDao#selectByMonth(java.lang.String)
	 */
	@Override
	public List<DpConsumerDetails> selectByMonth(String month) {

		return ldpaMtxfjlbMapper.selectByMonth(month);
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.DpConsumerDetailsServiceDao#insertSelective(lsq.model.DpConsumerDetails)
	 */
	@Override
	public int insertSelective(DpConsumerDetails record) {

		return ldpaMtxfjlbMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see lsq.service.dao.DpConsumerDetailsServiceDao#selectByYear(java.lang.String)
	 */
	@Override
	public List<DpConsumerDetails> selectByYear(String year) {

		return ldpaMtxfjlbMapper.selectByYear(year);
	}


}
