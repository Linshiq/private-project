package lsq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import lsq.dao.HtmlMapper;
import lsq.model.Html;
import lsq.service.dao.HtmlServiceDao;

public class HtmlServiceImpl implements HtmlServiceDao{

	public HtmlMapper htmlMapper;

	
	public HtmlMapper getHtmlMapper() {
		return htmlMapper;
	}


   @Autowired
	public void seHtmlMapper(HtmlMapper htmlMapper) {
		this.htmlMapper = htmlMapper;
	}
	/* (non-Javadoc)
	 * @see lsq.service.dao.HtmlServiceDao#getHtmlAll()
	 */
	@Override
	public Html getHtmlAll(String htmlid) {
		
		return htmlMapper.selectByPrimaryKey(htmlid);
	}

}
