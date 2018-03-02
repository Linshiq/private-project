package com.lsq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.ReportUtil;
import com.lsq.db.dao.DpUserBalanceMapper;
import com.lsq.db.model.DpUserBalance;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月16日 下午5:12:50 
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
 *         <li>2017年6月16日-下午5:12:50</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/balance")
public class ControllerBackBalance {

	@Autowired
	private DpUserBalanceMapper balanceService;

	@RequestMapping("")
	public String getBalanceInfo(Map<String, Object> map) {
		// 获取账户余额信息
		List<DpUserBalance> balanceList = balanceService.selectAllInfo();

		StringBuffer allInfo = new StringBuffer();// 组装所有日期
		allInfo.append("{ \"name\": \"余额曲线\", \"data\":[");
		if (balanceList.size() > 0) {

			for (int i = 0; i < balanceList.size(); i++) {

				if (i != 0) {
					allInfo.append(",");
				}

				allInfo.append("" + balanceList.get(i).getBalance() + "");
			}

		}
		allInfo.append("]}");

		StringBuffer xTitle = new StringBuffer(); // 建立X轴
		xTitle.append(ReportUtil.getX("日期(日)"));

		StringBuffer xData = new StringBuffer(); // 建立X轴
		xData.append("{ \"data\" :[");
		if (balanceList.size() > 0) {

			for (int i = 0; i < balanceList.size(); i++) {

				if (i != 0) {
					xData.append(",");
				}

				xData.append("\"" + balanceList.get(i).getDate() + "\"");
			}
		}
		// for (int i = 0; i < 24; i++) // 小时
		// xSb.append("'" + i + "'").append(",");
		xData.append("]}");

		StringBuffer yTitle = new StringBuffer();
		yTitle.append(ReportUtil.getYHead("金额")); // 建立Y轴

		StringBuffer yData = new StringBuffer();
		yData.append("[");
		for (int i = 0; i <= 10; i = i + 1) // 金额
			yData.append("" + i + "").append(",");
		yData.append("]");
		
		map.put("balance", "yes");
		map.put("data", allInfo.toString());
		map.put("xTitle", xTitle.toString());
		map.put("xData", xData.toString());
		map.put("yTitle", yTitle.toString());
		map.put("yData", yData.toString());
		map.put("title", ReportUtil.getTitle("余额折线图"));// 设置报表标题
		return "backstage/query/balance";
	}

}
