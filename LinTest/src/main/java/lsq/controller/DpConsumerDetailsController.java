package lsq.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import api.report.ReportUtil;
import lsq.bean.report.amount.AnnualReport;
import lsq.data.table.processing.LdpaMtxfjlDataProcess;
import lsq.model.DpConsumerDetails;
import lsq.model.DpUserBalance;
import lsq.service.dao.DpConsumerDetailsServiceDao;

@Controller
@RequestMapping("/")
public class DpConsumerDetailsController {

	private static final Logger logger = Logger.getLogger(DpConsumerDetailsController.class);
	/* 不知道这段屏蔽的代码有什么作用 */
	private static DpConsumerDetailsServiceDao ldpaMtxfjlService;

	public DpConsumerDetailsServiceDao getLdpaMtxfjlService() {
		return ldpaMtxfjlService;
	}

	@Autowired
	public void setLdpaMtxfjlService(DpConsumerDetailsServiceDao ldpaMtxfjlService1) {
		logger.debug("LdpaMtxfjlController.setLdpaMtxfjlService start");

		DpConsumerDetailsController.ldpaMtxfjlService = ldpaMtxfjlService1;
		LdpaMtxfjlDataProcess ldpaMtxfjlDataProcess = new LdpaMtxfjlDataProcess();
		ldpaMtxfjlDataProcess.setLdpaMtxfjlService(ldpaMtxfjlService1);

		logger.debug("LdpaMtxfjlController.setLdpaMtxfjlService end");
	}

	@RequestMapping(value = "/table/dd", method = RequestMethod.GET)
	public String getWho(Model model, @RequestParam("oneday") String oneday) {// 根据判断进行重定向
		logger.debug("LdpaMtxfjlController.getWho start");
		System.out.println(oneday);
		model.addAttribute("oneday", oneday);
		if (oneday.length() == 10) {

			logger.debug("LdpaMtxfjlController.getWho end");
			return "redirect:/table/daybaobiao";
		} else {
			logger.debug("LdpaMtxfjlController.getWho end");
			return "redirect:/table/yearbaobiao";
		}
	}

	// 获取年度消费比重报表
	@RequestMapping(value = "/table/xfbz", method = RequestMethod.GET)
	public String getAnnualConsumptionReport(Model model) {
		logger.debug("LdpaMtxfjlController.getAnnualConsumptionReport start");

		Map<String, Float> map = LdpaMtxfjlDataProcess.getAllRatio();

		List<String> nameList = new ArrayList<>();
		for (Map.Entry<String, Float> entry : map.entrySet()) { // 遍历输出

			nameList.add(entry.getKey()); // 存储所有的键值
		}

		float sum = 0;

		StringBuffer allInfo = new StringBuffer();// 组装当天所有数据
		allInfo.append("series: [{"); // 组装报表数据
		allInfo.append("type: 'pie'").append(",");
		allInfo.append("name: '" + "目前为止" + "'").append(",");
		allInfo.append("data:[");
		for (String str : nameList) {

			allInfo.append("[").append("'" + str + " ￥" + map.get(str) + "元'").append(",");
			allInfo.append(map.get(str)).append(",");
			allInfo.append("],");

			if (map.get(str) < 0)
				continue;
			sum = sum + map.get(str);
		}
		allInfo.append("],");
		allInfo.append("}],");

		model.addAttribute("sum", sum);
		model.addAttribute("data2", allInfo.toString());
		model.addAttribute("title", ReportUtil.getTitle("消费比重报表"));// 设置报表标题

		model.addAttribute("leftTitle", "my life");
		logger.debug("LdpaMtxfjlController.getAnnualConsumptionReport end");
		return "/WEB-INF/jsp/report/annualConsumptionReport";
	}

	@RequestMapping("/table/yearbaobiao")
	public String getAnnualReport(Model model,@RequestParam("oneYear") String oneYear) {

		Map<String, List<AnnualReport>> allMonthList = LdpaMtxfjlDataProcess.getYearSpendingEveryDay(oneYear);

		StringBuffer allInfo = new StringBuffer();// 组装所有月份
		allInfo.append("series: ["); // 组装报表数据

		Iterator<String> keys = allMonthList.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			for (int i = 1; i <= 12; i++) {
				
				String exitKey = "";
				
				if (i < 10) {
					
					exitKey = "0" + i;		
				} else {
					
				    exitKey = i + "";	
				}
				
				if (exitKey.equals(key)) {// 寻找记录中存在的月份
					System.out.println("这里面有" + exitKey);

					List<AnnualReport> a = allMonthList.get(exitKey);
					if (a.size() > 0) {
						StringBuffer monthSB = new StringBuffer();// 拼接月份数据
						monthSB.append("{");
						monthSB.append("name: '" + exitKey + "月份'").append(",");
						monthSB.append("data:[");
						for (AnnualReport a1 : a) {
							// System.out.println(a1.getDate() + ":" +
							// a1.getAmout());
							monthSB.append(a1.getAmout()).append(",");
						}
						monthSB.append("]},");
						allInfo.append(monthSB);
					} else
						continue;
				}
			}
		}
		allInfo.append("]");

		StringBuffer xSb = new StringBuffer(); // 建立X轴
		xSb.append(ReportUtil.getX("日期")).append("[");
		for (int i = 1; i <= 31; i++) // 天数
			xSb.append("'" + i + "'").append(",");
		xSb.append("]");
		StringBuffer ySb = new StringBuffer();
		ySb.append(ReportUtil.getYHead("金额")).append("["); // 建立Y轴
		for (int i = 0; i <= 2000; i = i + 100) // 金额
			ySb.append("'" + i + "'").append(",");
		ySb.append("]");

		model.addAttribute("data2", allInfo.toString());
		model.addAttribute("x", xSb.toString());
		model.addAttribute("y", ySb.toString());
		model.addAttribute("title", ReportUtil.getTitle(oneYear+"报表"));// 设置报表标题

		return "/WEB-INF/jsp/report/annual_report";
	}

	// 返回一天的消费报表
	@RequestMapping("/table/daybaobiao")
	public String getDayReport(Model model, @RequestParam("oneday") String oneday) {

		logger.debug("LdpaMtxfjlController.getDayReport start");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String oneDayStr = oneday;
		try {
			date = sdf.parse(oneDayStr);
			List<DpConsumerDetails> ldpaMtxfjlbList = LdpaMtxfjlDataProcess.getOneDateData(date);

			List<String> flagList = new ArrayList<>();// 定义非重复标志
			boolean flag = false;
			float jine = 0; // 将重复的消费选项记录
			float sum = 0; // 支出收入合计

			StringBuffer allInfo = new StringBuffer();// 组装当天所有数据
			allInfo.append("series: [{"); // 组装报表数据
			allInfo.append("type: 'pie'").append(",");
			allInfo.append("name: '" + oneDayStr + "'").append(",");
			allInfo.append("data:[");
			if (ldpaMtxfjlbList.size() > 0) {
				for (DpConsumerDetails l : ldpaMtxfjlbList) {
					// 去除已经相加的项
					for (int i = 0; i < flagList.size(); i++) {
						if (l.getId().equals(flagList.get(i))) {
							flag = true;
							break;
						}
					}
					if (flag) {// 遇见已经相加过的项则跳过
						flag = false;
						continue;
					}
					// 去除重复项
					for (DpConsumerDetails lm : ldpaMtxfjlbList) {
						// 排除与自己相对比
						if (l.getId().equals(lm.getId())) {
							continue;
						} else if (l.getConsumptionType().equals(lm.getConsumptionType())) {
							jine = lm.getExpenditure() - l.getIncome() + jine;
							flagList.add(lm.getId());
						}
					}
					sum = l.getExpenditure() - l.getIncome() + jine;
					allInfo.append("[").append("'" + l.getConsumptionType() + " ￥" + sum + "元'").append(",");
					allInfo.append(sum).append(",");
					allInfo.append("],");
					jine = 0;
				}
			}
			allInfo.append("],");
			allInfo.append("}],");

			model.addAttribute("dayXFList", ldpaMtxfjlbList);
			model.addAttribute("data2", allInfo.toString());
			model.addAttribute("title", ReportUtil.getTitle(oneday + "消费比重报表"));// 设置报表标题

			model.addAttribute("leftTitle", oneday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("LdpaMtxfjlController.getDayReport end");
		return "/WEB-INF/jsp/report/every_day_report";
	}

	// 获取指定月份消费折线图
	@RequestMapping("/table/monthbaobiao")
	public String getMonthReport(Model model, @RequestParam("oneMonth") String oneMonth) {

		List<DpUserBalance> ldpaZhhaoyeList = LdpaMtxfjlDataProcess.getOneMonthData(oneMonth);

		StringBuffer allInfo = new StringBuffer();// 组装当月所有数据
		allInfo.append("series: ["); // 组装报表数据
		allInfo.append("{");
		allInfo.append("name: '" + oneMonth + "月消费'").append(",");
		allInfo.append("data:[");
		if (ldpaZhhaoyeList.size() > 0) {
			for (DpUserBalance l : ldpaZhhaoyeList) {

				allInfo.append(l.getTotalConsumption()).append(",");
			}
		}
		allInfo.append("]},");
		allInfo.append("{");
		allInfo.append("name: '" + oneMonth + "月收入" + "'").append(",");
		allInfo.append("data:[");
		if (ldpaZhhaoyeList.size() > 0) {
			for (DpUserBalance l : ldpaZhhaoyeList) {

				allInfo.append(l.getTotalIncome()).append(",");
			}
		}
		allInfo.append("]},");
		allInfo.append("{");
		allInfo.append("name: '" + oneMonth + "月余额" + "'").append(",");
		allInfo.append("data:[");
		if (ldpaZhhaoyeList.size() > 0) {
			for (DpUserBalance l : ldpaZhhaoyeList) {

				allInfo.append(l.getBalance()).append(",");
			}
		}
		allInfo.append("]},");
		allInfo.append("]");
		StringBuffer xSb = new StringBuffer(); // 建立X轴
		xSb.append(ReportUtil.getX("日期(天)")).append("[");
		for (int i = 1; i <= 31; i++) // 天数
			xSb.append("'" + i + "'").append(",");
		xSb.append("]");
		StringBuffer ySb = new StringBuffer();
		ySb.append(ReportUtil.getYHead("金额")).append("["); // 建立Y轴
		for (int i = 0; i <= 10; i = i + 1) // 金额
			ySb.append("'" + i + "'").append(",");
		ySb.append("]");

		model.addAttribute("data2", allInfo.toString());
		model.addAttribute("x", xSb.toString());
		model.addAttribute("y", ySb.toString());
		model.addAttribute("title", ReportUtil.getTitle(oneMonth + "月消费报表"));// 设置报表标题

		// model.addAttribute("leftTitle", oneMonth);
		return "/WEB-INF/jsp/report/month_report";
	}

	// 获取指定月份消费折线图
	@RequestMapping("/table/insert_day")
	public String setConsumptionDay(Model model) {
		logger.info("LdpaMtxfjlController.setConsumptionDay start");

		logger.info("LdpaMtxfjlController.setConsumptionDay end");
		return "/WEB-INF/jsp/report/report_check_in_day";
	}
}
