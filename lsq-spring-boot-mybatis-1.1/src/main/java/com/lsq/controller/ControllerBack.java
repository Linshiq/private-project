package com.lsq.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsq.db.dao.DpConsumerDetailsMapper;
import com.lsq.db.dao.DpUserBalanceMapper;
import com.lsq.db.model.DpConsumerDetails;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月13日 下午5:21:23 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       后台Controller控制		
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年6月13日-下午5:21:23</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/back")
public class ControllerBack {
	
	@Autowired
	private DpConsumerDetailsMapper consumerDetlService;
	
	@Autowired
	private DpUserBalanceMapper balanceService;
	
	@RequestMapping(value = "")
	public String getToIndex(Map<String, Object> map) {
		
		map.put("index", "yes");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		return "backstage/index";

	}
	
	@RequestMapping(value = "/widgets")
	public String getToWidgets(Map<String, Object> map) {
		
		map.put("index", "no");
		map.put("widgets", "yes");
		map.put("charts", "no");
		
		
		
		return "backstage/widgets";

	}
	
	@RequestMapping(value = "/charts")
	public String getToCharts(Map<String, Object> map) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "yes");
		
		return "backstage/charts";

	}
	
	@RequestMapping(value = "/day_query")
	public String getQueryDayPay(Map<String, Object> map) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		return "backstage/query/day_query";

	}
	
	@RequestMapping(value = "/day_query/query", method = RequestMethod.POST)
	public String getQueryDayPayResult(Map<String, Object> map,HttpServletRequest request) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		String date = request.getParameter("date");
		
		List<DpConsumerDetails> listConsumerDetls = consumerDetlService.selectByDate(date);
		
		BigDecimal allIncome = BigDecimal.ZERO;
		BigDecimal allExpenditure = BigDecimal.ZERO;
		
		for(DpConsumerDetails listConsumerDetl:listConsumerDetls){
			
			allIncome = allIncome.add(listConsumerDetl.getIncome());
			allExpenditure = allExpenditure.add(listConsumerDetl.getExpenditure());
		}
		
		map.put("consumerDetl", listConsumerDetls);
		map.put("allIncome", allIncome);
		map.put("allExpenditure", allExpenditure);
		map.put("date", date);
		
		return "backstage/query/day_query";

	}
	
	@RequestMapping(value = "/month_query")
	public String getQueryMonthPay(Map<String, Object> map) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		map.put("consumptionType", consumerDetlService.selectConsumptionType());
		
		return "backstage/query/month_query";

	}
	
	@RequestMapping(value = "/month_query/query", method = RequestMethod.POST)
	public String getQueryMonthPayResult(Map<String, Object> map,HttpServletRequest request) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		String month = request.getParameter("month");
		String consumptionType = request.getParameter("consumptionType");
		
		List<DpConsumerDetails> listConsumerDetls = consumerDetlService.selectByMonth(consumptionType,month);
		
		BigDecimal allIncome = BigDecimal.ZERO;
		BigDecimal allExpenditure = BigDecimal.ZERO;
		
		for(DpConsumerDetails listConsumerDetl:listConsumerDetls){
			
			allIncome = allIncome.add(listConsumerDetl.getIncome());
			allExpenditure = allExpenditure.add(listConsumerDetl.getExpenditure());
		}
		
		map.put("consumptionType", consumptionType);
		
		map.put("consumerDetl", listConsumerDetls);
		map.put("allIncome", allIncome);
		map.put("allExpenditure", allExpenditure);
		map.put("date", month);
		
		map.put("consumptionType", consumerDetlService.selectConsumptionType());
		
		return "backstage/query/month_query";

	}
	
	@RequestMapping(value = "/year_query")
	public String getQueryYearPay(Map<String, Object> map) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		map.put("consumptionType", consumerDetlService.selectConsumptionType());
		
		return "backstage/query/year_query";

	}
	
	@RequestMapping(value = "/year_query/query", method = RequestMethod.POST)
	public String getQueryYearPayResult(Map<String, Object> map,HttpServletRequest request) {
		
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		String year = request.getParameter("year");
		String consumptionType = request.getParameter("consumptionType");
		
		List<DpConsumerDetails> listConsumerDetls = consumerDetlService.selectByMonth(consumptionType,year);
		
		BigDecimal allIncome = BigDecimal.ZERO;
		BigDecimal allExpenditure = BigDecimal.ZERO;
		
		for(DpConsumerDetails listConsumerDetl:listConsumerDetls){
			
			allIncome = allIncome.add(listConsumerDetl.getIncome());
			allExpenditure = allExpenditure.add(listConsumerDetl.getExpenditure());
		}
		
		map.put("consumerDetl", listConsumerDetls);
		map.put("allIncome", allIncome);
		map.put("allExpenditure", allExpenditure);
		map.put("date", year);
		
		map.put("consumptionType", consumerDetlService.selectConsumptionType());
		
		return "backstage/query/year_query";

	}

}
