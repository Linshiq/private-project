package service.newsMessge;

import java.util.ArrayList;
import java.util.List;

import com.message.resp.Article;
import com.message.resp.Music;

public class ArticleNews {

	public static Article onlyArticeNews() {
		Article article = new Article();  
        article.setTitle("南林风采!");  
        article.setDescription("南京林业大学（Nanjing Forestry University）简称“南林、南林大”，位于江苏南京，是一所以林科为特色，以资源、生态和环境类学科为优势的多科性大学，是国家林业局和江苏省人民政府共建的高等农林类院校，设有研究生院，国家首批“卓越农林人才教育培养计划”改革项目试点高校[1]  ，是74所国家“特色重点学科项目”建设高校之一，是“国家公派优秀本科生国际交流项目”高校，江苏省十五所重点建设大学成员，"+
        		 "江苏省“2011协同创新中心”高校，江苏省“卓越工程师教育培养计划”高校，亦是全国首批具有博士和硕士学位授予权、具有教授和副教授任职资格评审权、博士生导师自主审批权和最早实行对外开放的高校之一，是具有江苏省属具有研究生推免资格的十四所高校之一，是中国最早建立的林业高等学府，在中国林业院校中享有较高声誉，是孕育林业顶尖人才的摇篮。南京林业大学前身为南京大学森林系和金陵大学森林系，1952年合并组建南京林学院，是当时中国仅有的三所高等林业院校之一。1985年更名为南京林业大学。"+
                 "学校现有专任教师1100余人，开设23个学院（部），本科专业72个。学校占地面积10295亩，其中，新庄主校区占地1257亩，句容下蜀校区占地4370亩，南方学院淮安校区占地1327亩，白马教学科研基地占地3300亩，江宁工程培训中心等占地41亩。现有教学科研仪器设备总值3.28亿元，图书馆纸质文献总量为150万册。校园网络以千兆带宽为主干，覆盖全校。（2015年6月数据）");  
        article.setPicUrl("");  
        article.setUrl("http://www.njfu.edu.cn/");
        return article;
	}
	
	public static List<Article> moreArticeNews(List<Music> musicList) {
		
		List<Article> articlesList = new ArrayList<Article>();
		
		for (Music m : musicList) {
			Article article = new Article();
			article.setTitle("歌名:"+m.getSongName()+" 演唱者:"+m.getUserName());
			article.setDescription("");
			article.setPicUrl(m.getAlbumPic());
			article.setUrl(m.getSongUrl());
			articlesList.add(article);
		}
        
        return articlesList;
	}
}
