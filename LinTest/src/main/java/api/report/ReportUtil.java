package api.report;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月20日 下午1:30:41 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 获取hcharts报表组装
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月20日-下午1:30:41</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ReportUtil {

	// 获得图标配置Chart
	public static void getChart() {

		StringBuffer chartSb = new StringBuffer();

		chartSb.append("chart:").append("{").append("\n");
		chartSb.append("type:").append("'").append("line").append("'").append(",").append("\n"); // 定义为折线
		chartSb.append("events:").append("{");
	}

	// 设置报表标题
	public static String getTitle(String title) {

		StringBuffer titleSb = new StringBuffer();

		titleSb.append(" title: {");
		titleSb.append("text:").append("'").append(title).append("',");
		titleSb.append(" }");

		return titleSb.toString();
	}

	// 设置数据提示框（Tooltip）
	public static String getTooltip(String valuePrefix, String valueSuffix, String shared) {
		StringBuffer tooltipSb = new StringBuffer();

		tooltipSb.append("tooltip: { ");
		tooltipSb.append("valuePrefix:").append("'").append(valuePrefix).append("',");
		tooltipSb.append("valueSuffix:").append("'").append(valueSuffix).append("',");
		tooltipSb.append("shared:").append(shared).append(",");
		tooltipSb.append("},");

		return tooltipSb.toString();
	}

	// 设置Y轴（ yAxis）
	public static String getYHead(String title) {
		
		StringBuffer ySb = new StringBuffer();
		ySb.append("title:{").append("text:'").append(title).append("'},");
		ySb.append("categories:");
		
		return ySb.toString();
	}
	public static String getYEnd(String title) {
		
		StringBuffer ySb = new StringBuffer();
		//ySb.append(str)
		
		return ySb.toString();
	}
	// 设置X轴（ xAxis）
	public static String getX(String title) {
		StringBuffer xSb = new StringBuffer();
		xSb.append("title:{").append("text:'").append(title).append("'},");
		xSb.append("categories:");
		
		return xSb.toString();
	}
}
