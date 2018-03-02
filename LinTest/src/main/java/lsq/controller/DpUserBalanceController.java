package lsq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import api.report.ReportUtil;
import lsq.data.table.processing.DpUserBalanceDataProcess;
import lsq.model.DpUserBalance;
import lsq.service.dao.DpUserBalanceServiceDao;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月22日 上午11:17:57 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：账户余额返回
 *       			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月22日-上午11:17:57</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：直接通过Controller访问,Autowired会注入失败,不知道什么原因</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/")
public class DpUserBalanceController {

	private static  DpUserBalanceServiceDao ldpaZhhaoyeService;

	public  DpUserBalanceServiceDao getLdpaZhhaoyeService() {
		return ldpaZhhaoyeService;
	}
	@Autowired
	public  void setLdpaZhhaoyeService(DpUserBalanceServiceDao ldpaZhhaoyeService) {
		DpUserBalanceController.ldpaZhhaoyeService = ldpaZhhaoyeService;
		DpUserBalanceDataProcess ldpaZhhaoyeDataProcess = new DpUserBalanceDataProcess();
		ldpaZhhaoyeDataProcess.setLdpaZhhaoyeService(ldpaZhhaoyeService);
	}
	
	@RequestMapping("/table/yue")
	public String getYueReport(Model model) {
		//获取账户余额信息
		List<DpUserBalance> ldpaZhhaoyeList = DpUserBalanceController.getLdpaZhhaoyeAllInfo();
		
		StringBuffer allInfo = new StringBuffer();// 组装所有日期
		allInfo.append("series: ["); // 组装报表数据
		allInfo.append("{");
		allInfo.append("name: '" + "余额" + "'").append(",");
		allInfo.append("data:[");
		if(ldpaZhhaoyeList.size() > 0){
			for(DpUserBalance l : ldpaZhhaoyeList){
				
				allInfo.append(l.getBalance()).append(",");
			}
		}
		allInfo.append("]},");
		allInfo.append("]");
		
		StringBuffer xSb = new StringBuffer(); // 建立X轴
		xSb.append(ReportUtil.getX("日期(日)")).append("[");
		if(ldpaZhhaoyeList.size() > 0){
			for(DpUserBalance l : ldpaZhhaoyeList){
				xSb.append("'" + CommUtil.getSimpleDateFormat(l.getDate())+ "'").append(",");
			}
		}
//		for (int i = 0; i < 24; i++) // 小时
//			xSb.append("'" + i + "'").append(",");
		xSb.append("]");
		StringBuffer ySb = new StringBuffer();
		ySb.append(ReportUtil.getYHead("金额")).append("["); // 建立Y轴
		for (int i = 0; i <= 10; i = i + 1) // 金额
			ySb.append("'" + i + "'").append(",");
		ySb.append("]");

		model.addAttribute("data2", allInfo.toString());
		model.addAttribute("x", xSb.toString());
		model.addAttribute("y", ySb.toString());
		model.addAttribute("title",ReportUtil.getTitle("余额折线图"));//设置报表标题
		return "/WEB-INF/jsp/report/balance_report";
	}
	
	private static List<DpUserBalance> getLdpaZhhaoyeAllInfo(){
		
		System.out.println(ldpaZhhaoyeService);
		
		List<DpUserBalance> ldpaZhhaoyeList = ldpaZhhaoyeService.selectAllInfo();
		
		return ldpaZhhaoyeList;
	}
	
}
