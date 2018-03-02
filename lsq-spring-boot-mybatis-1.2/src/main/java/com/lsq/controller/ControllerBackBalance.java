package com.lsq.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api.ReportUtil;
import com.lsq.db.dao.DpConsumerDetailsMapper;
import com.lsq.db.dao.DpUserBalanceMapper;
import com.lsq.db.dao.PersonBalanceMapper;
import com.lsq.db.dao.PersonDtailsMapper;
import com.lsq.db.model.PersonBalance;
import com.lsq.db.model.PersonDtails;
import com.lsq.db.type.ConsumerDetailsType;
import com.lsq.util.CommUtil;

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

	@Autowired
	private DpConsumerDetailsMapper consumerDetlService;
	
	@Autowired
	private PersonBalanceMapper personBalanceMapper;
	
	@Autowired
	private PersonDtailsMapper personDtailsMapper;
	
	/*@Autowired
	private DpUserBalanceMapper balanceService;*/

	@RequestMapping("")
	public String getBalanceInfo(Map<String, Object> map) {
		// 获取账户余额信息
		List<PersonBalance> balanceList = personBalanceMapper.selectAllInfo();

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

	@RequestMapping(value = "/consumeProp", method = {RequestMethod.POST,RequestMethod.GET})
	public String qryConsumeProportion(Map<String, Object> map, HttpServletRequest request) {

		String minDate = request.getParameter("minDate");
		String maxDate = request.getParameter("maxDate");

		ConsumerDetailsType consumptionDetlType = new ConsumerDetailsType();

		if (CommUtil.isNotNull(minDate)) {

			consumptionDetlType.setMinDate(minDate);
		}

		if (CommUtil.isNotNull(maxDate)) {

			consumptionDetlType.setMaxDate(maxDate);
		}

		List<PersonDtails> list = personDtailsMapper.selectConsumerPropInfo(consumptionDetlType);
		
		for (PersonDtails conSuType : list) {

			System.out.println(conSuType + " :" + conSuType.getDetailType());
		}
		
		List<String> consuTypeList = personDtailsMapper.selectConsumptionType();

		Map<String, BigDecimal> consuMap = new HashMap<>();

		// 初始化键值对
		for (String conSuType : consuTypeList) {

			consuMap.put(conSuType, BigDecimal.ZERO);
		}

		// 将重复类型的消费类型合并
		for (PersonDtails consDetl : list) {
			
			if(consDetl.getAmount().compareTo(BigDecimal.ZERO) <=0){// 因为是看消费比重,所以收入可以不计
				continue;
			}
			
			for (String conSuType : consuTypeList) {

				if (consDetl.getDetailType().equals(conSuType)) {

					consuMap.put(conSuType, consuMap.get(conSuType).add(consDetl.getAmount()));
				}
			}
		}

		/*for (String conSuType : consuTypeList) {

			System.out.println(conSuType + " :" + consuMap.get(conSuType));
		}*/

		BigDecimal sum = BigDecimal.ZERO;

		StringBuffer allInfo = new StringBuffer();// 组装当天所有数据
		allInfo.append("{"); // 组装报表数据
		allInfo.append("\"type\": 'pie'").append(",");
		allInfo.append("\"name\": '" + "目前为止" + "'").append(",");
		allInfo.append("\"data\":[");

		for (int i = 0; i < consuTypeList.size(); i++) {
			
			if (consuMap.get(consuTypeList.get(i)).compareTo(BigDecimal.ZERO) <= 0){
				continue;
			}
			
			allInfo.append("[").append("'" + consuTypeList.get(i) + " ￥" + consuMap.get(consuTypeList.get(i)) + "元'").append(",");
			allInfo.append(consuMap.get(consuTypeList.get(i))).append(",");

			if (i < consuTypeList.size() - 1) {

				allInfo.append("],");
			} else {
				allInfo.append("]");
			}

			sum = sum.add(consuMap.get(consuTypeList.get(i)));
		}
		allInfo.append("]");
		allInfo.append("}");

		System.out.println(allInfo.toString());

		map.put("data", allInfo.toString());
		map.put("sum", sum);
		map.put("dateToDate", "从"+(CommUtil.isNotNull(minDate) ? minDate : " 未知 ")+"至"+ (CommUtil.isNotNull(maxDate) ? maxDate : " 未知 "));
		
		return "backstage/query/consume_proportion";
	}
}
