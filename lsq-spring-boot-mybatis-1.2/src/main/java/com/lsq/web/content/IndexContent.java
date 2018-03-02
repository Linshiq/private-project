package com.lsq.web.content;

import java.util.Map;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月9日 下午1:23:06 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *      首页内容填充 			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年6月9日-下午1:23:06</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class IndexContent {
	
	/**
	 * @param map 
	 * @Author linshiqin
	 *         <p>
	 *         <li>2017年6月9日-下午1:25:16</li>
	 *         <li>功能说明：定义首页内容返回</li>
	 *         </p>
	 */
	public static Map<String,Object> getIndexConten(Map<String, Object> map) {
		
		map.put("Introduction_title", "Bootstrap");
		map.put("Introduction_conten", "这是基于 Bootstrap 建立的一个网站.目前呢,也没有啥内容可以补充,就放一些个人照片和个人数据~");
		
		return map;

	}
	
}
