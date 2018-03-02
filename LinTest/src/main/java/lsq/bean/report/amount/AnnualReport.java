package lsq.bean.report.amount;
/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月18日 上午9:24:41 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       			返回一日总消费金额
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月18日-上午9:24:41</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class AnnualReport {

	private float amout;
	private String date;
	private String year;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public float getAmout() {
		return amout;
	}
	public void setAmout(float amout) {
		this.amout = amout;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AnnualReport [amout=" + amout + ", date=" + date + ", year=" + year + "]";
	}
	
	
	
}
