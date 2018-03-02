package com.lsq.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsq.db.dao.DpConsumerDetailsMapper;
import com.lsq.db.dao.DpUserBalanceMapper;
import com.lsq.db.model.DpConsumerDetails;
import com.lsq.db.type.ConsumerDetailsType;
import com.lsq.util.CommUtil;

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
 * 文件功能说明： 后台Controller控制
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
	public String getQueryDayPayResult(Map<String, Object> map, HttpServletRequest request) {

		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");

		String date = request.getParameter("date");

		List<DpConsumerDetails> listConsumerDetls = consumerDetlService.selectByDate(date);

		BigDecimal allIncome = BigDecimal.ZERO;
		BigDecimal allExpenditure = BigDecimal.ZERO;

		for (DpConsumerDetails listConsumerDetl : listConsumerDetls) {

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
	public String getQueryMonthPayResult(Map<String, Object> map, HttpServletRequest request) {

		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");

		String month = request.getParameter("month");
		String consumptionType = request.getParameter("consumptionType");

		ConsumerDetailsType consumptionDetlType = new ConsumerDetailsType();

		consumptionDetlType.setConsumptionType(consumptionType);
		consumptionDetlType.setDate(month+"%");

		List<DpConsumerDetails> listConsumerDetls = consumerDetlService.selectConsumerInfo(consumptionDetlType);

		BigDecimal allIncome = BigDecimal.ZERO;
		BigDecimal allExpenditure = BigDecimal.ZERO;

		for (DpConsumerDetails listConsumerDetl : listConsumerDetls) {

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
	public String getQueryYearPay(Map<String, Object> map,HttpServletRequest request) {
		
		 //获得当前页
        map.put("pageNum", 1);
        //获得一页显示的条数
        map.put("pageSize", 10);
        //是否是第一页
        map.put("isFirstPage", true);
        //获得总页数
        map.put("totalPages", 1);
        //是否是最后一页
        map.put("isLastPage", false);
		
        //获得第一条
        map.put("startPages", 1);
        //获得每次可选择最大条数
        map.put("endPages",1);
        
		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		map.put("consumptionType", consumerDetlService.selectConsumptionType());
		
		return "backstage/query/year_query";

	}

	@RequestMapping(value = "/year_query/query", method = {RequestMethod.POST,RequestMethod.GET})
	public String getQueryYearPayResult(Map<String, Object> map, HttpServletRequest request) {

		map.put("index", "no");
		map.put("widgets", "no");
		map.put("charts", "no");
		
		String year = request.getParameter("year");
		String consumptionType = request.getParameter("consumptionType");

		ConsumerDetailsType consumptionDetlType = new ConsumerDetailsType();

		consumptionDetlType.setConsumptionType(consumptionType);
		consumptionDetlType.setDate(year+"%");
		
		// 设置默认起始分页数
		int pageNum = 1;
		int pageSize = 10;
		
		// 不为null则取上一页或者下一页
		if(CommUtil.isNotNull(request.getParameter("pageSize"))){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		
		if(CommUtil.isNotNull(request.getParameter("pageNum"))){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		PageHelper.startPage(pageNum,pageSize);// 设置查询页数
		
		List<DpConsumerDetails> listConsumerDetls = consumerDetlService.selectConsumerInfo(consumptionDetlType);
		
		PageInfo<DpConsumerDetails> pageInfo = new PageInfo<DpConsumerDetails>(listConsumerDetls); // 加入分页
		
		System.out.println(pageInfo);
		
		/*处理翻页数据*/
		
		//获得当前页
        map.put("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        map.put("pageSize", pageInfo.getPageSize());
        //是否是第一页
        map.put("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        map.put("totalPages", pageInfo.getPages());
        //是否是最后一页
        map.put("isLastPage", pageInfo.isIsLastPage());
		
        int  startPages = pageInfo.getPageNum()- 5 > 0 ? pageInfo.getPageNum()- 5:1;
        
        if(pageInfo.getPages() - startPages < 10 && pageInfo.getPages() > 11){
        	
        	startPages = pageInfo.getPages() - 10;
        
        }else if(pageInfo.getPages() < 11){
        	
        	startPages = 1;
        }
        
        //获得第一条
        map.put("startPages", startPages);
        
        int  endPages = pageInfo.getPageNum()+5;
        
        if(endPages > pageInfo.getPages() && pageInfo.getPages() > 11){
        	
        	endPages = pageInfo.getPages();
        
        }else if(pageInfo.getPages() < 11){
        	
        	endPages = pageInfo.getPageNum();
        }
        
        //获得每次可选择最大条数
        map.put("endPages",endPages);
		
		BigDecimal allIncome = BigDecimal.ZERO;
		BigDecimal allExpenditure = BigDecimal.ZERO;

		for (DpConsumerDetails listConsumerDetl : consumerDetlService.selectConsumerInfo(consumptionDetlType)) {

			allIncome = allIncome.add(listConsumerDetl.getIncome());
			allExpenditure = allExpenditure.add(listConsumerDetl.getExpenditure());
		}
		
		map.put("consumerDetl", listConsumerDetls);
		map.put("allIncome", allIncome);
		map.put("allExpenditure", allExpenditure);
		map.put("year", year);
		map.put("pageConsumptionType", consumptionType);
		
		map.put("consumptionType", consumerDetlService.selectConsumptionType());

		return "backstage/query/year_query";

	}

}
