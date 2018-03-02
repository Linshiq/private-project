package lsq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsq.dao.ArticleMapper;
import lsq.model.Article;
import lsq.service.dao.ArticleServiceDao;

@Service("articleService")
public class ArticleServiceImpl implements ArticleServiceDao {

	public ArticleMapper articleMapper;

	
	public ArticleMapper getArticleMapper() {
		return articleMapper;
	}


   @Autowired
	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}



	public int getArticleById(String id) {
		
		System.out.println("======ss=====");
		Article record = new Article();
		record.setAuthor("2");
		record.setContent("2313");
		record.setId("3");
		
		return articleMapper.insert(record);
	}

}
