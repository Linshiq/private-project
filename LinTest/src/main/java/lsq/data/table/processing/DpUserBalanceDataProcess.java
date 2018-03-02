package lsq.data.table.processing;

import java.util.List;

import lsq.model.DpUserBalance;
import lsq.service.dao.DpUserBalanceServiceDao;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月27日 下午2:25:45 
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
 *         <li>2016年10月27日-下午2:25:45</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class DpUserBalanceDataProcess {
	
	private static  DpUserBalanceServiceDao ldpaZhhaoyeService;

	public  DpUserBalanceServiceDao getLdpaZhhaoyeService() {
		return ldpaZhhaoyeService;
	}
	public  void setLdpaZhhaoyeService(DpUserBalanceServiceDao ldpaZhhaoyeService) {
		DpUserBalanceDataProcess.ldpaZhhaoyeService = ldpaZhhaoyeService;
	}
	
	//获取每天消费支出数据
	public static List<DpUserBalance> getOneMonthData(String month){
		
		return ldpaZhhaoyeService.selectByMonth(month);
	}
}
