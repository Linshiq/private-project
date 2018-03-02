package com.lsq.db.sql;

import org.apache.ibatis.jdbc.SQL;

import com.lsq.util.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月19日 下午7:31:20 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年6月19日-下午7:31:20</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class DynamicQuery {

	public String findConsumerDetailsDateSql(final String consumerType,final String date) {
		
		return new SQL() {
			{
				SELECT("*");
				FROM("dp_consumer_details");
				
				StringBuffer sb = new StringBuffer();
				
				sb.append("'1' = '1'").append(" ");
				
				if(CommUtil.isNotNull(consumerType)){
					
					sb.append(" and consumption_type = '" + consumerType + "'");
				}
				
				if(CommUtil.isNotNull(date)){
					
					sb.append("and date like '" + date +"%'");
				}
								
				WHERE(sb.toString());
				ORDER_BY("date");
			}
		}.toString();
	}

}
