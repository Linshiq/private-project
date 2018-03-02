package api.bean.brainteasers;
/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月18日 上午10:46:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       脑筋急转弯实体类		
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月18日-上午10:46:15</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class BrainTeasers {

	/*ID*/
	private String id;
	/*问题*/
	private String quest;
	/*答复*/
	private String result;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "BrainTeasers [id=" + id + ", quest=" + quest + ", result=" + result + "]";
	}
	
	
}
