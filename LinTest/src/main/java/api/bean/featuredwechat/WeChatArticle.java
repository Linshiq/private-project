package api.bean.featuredwechat;
/** 
* @author  Linshiq: 
* @date 创建时间：2016年12月14日 上午10:46:50 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *      微信精选文章 			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年12月14日-上午10:46:50</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class WeChatArticle {

	private String contentImg;
	private String date;
	private String id;
	private String title;
	private String typeId;
	private String typeName;
	private String url;
	private String userLogo;
	private String userLogo_code;
	private String userName;
	public String getContentImg() {
		return contentImg;
	}
	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserLogo() {
		return userLogo;
	}
	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}
	public String getUserLogo_code() {
		return userLogo_code;
	}
	public void setUserLogo_code(String userLogo_code) {
		this.userLogo_code = userLogo_code;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "WeChatArticle [contentImg=" + contentImg + ", date=" + date + ", id=" + id + ", title=" + title
				+ ", typeId=" + typeId + ", typeName=" + typeName + ", url=" + url + ", userLogo=" + userLogo
				+ ", userLogo_code=" + userLogo_code + ", userName=" + userName + "]";
	}
	
}
