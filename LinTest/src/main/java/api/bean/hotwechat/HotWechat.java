package api.bean.hotwechat;
/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月16日 下午5:29:33 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *     热门微信文章实体类	
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月16日-下午5:29:33</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class HotWechat {

	/*图片路径*/
	private String picUrl;
	/*文章发布时间*/
	private String ctime;
	/*内容描述*/
	private String description;
	/*文章标题*/
	private String title;
	/*文章路径*/
	private String url;
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "HotWechat [picUrl=" + picUrl + ", ctime=" + ctime + ", description=" + description + ", title=" + title
				+ ", url=" + url + "]";
	}
	
	
}
