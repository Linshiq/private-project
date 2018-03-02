package lsq.data.table.processing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import error.Error;
import lsq.bean.report.amount.AnnualReport;
import lsq.model.DpConsumerDetails;
import lsq.model.DpUserBalance;
import lsq.service.dao.DpConsumerDetailsServiceDao;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月27日 上午11:40:54 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：LdpaMtxfjl信息处理
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年10月27日-上午11:40:54</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class LdpaMtxfjlDataProcess {

	private static DpConsumerDetailsServiceDao ldpaMtxfjlService;

	public DpConsumerDetailsServiceDao getLdpaMtxfjlService() {
		return ldpaMtxfjlService;
	}

	public void setLdpaMtxfjlService(DpConsumerDetailsServiceDao ldpaMtxfjlService) {
		LdpaMtxfjlDataProcess.ldpaMtxfjlService = ldpaMtxfjlService;
	}

	// 根据日期获取一天的报表(天)
	public static List<DpConsumerDetails> getOneDateData(Date date) {

		return ldpaMtxfjlService.selectByDate(date);
	}

	// 根据月份获取一个月的报表
	public static List<DpUserBalance> getOneMonthData(String month) {

		return DpUserBalanceDataProcess.getOneMonthData(month);
	}

	// 获取每天消费总金额
	public static Map<String, List<AnnualReport>> getSpendingEveryDay() {
		// 查询消费记录表
		List<DpConsumerDetails> ldpaMtxfjlList = ldpaMtxfjlService.selectAllInfo();

		if (ldpaMtxfjlList.isEmpty())
			try {
				throw new Error("消费表为空");
			} catch (Error e) {
				e.printStackTrace();
			}
		Map<String, List<AnnualReport>> allMonthMap = new HashMap<>();

		List<AnnualReport> dayList = new ArrayList<>();
		// 将日期相同的数据进行相加
		List<String> same = new ArrayList<>();// 接收重复数据的ID
		boolean flag = false; // 重复标志

		float totalConsumption = 0; // 初始金额
		for (int i = 0; i < ldpaMtxfjlList.size(); i++) {

			DpConsumerDetails l = ldpaMtxfjlList.get(i);

			String date = CommUtil.getSimpleDateFormat(l.getDate());

			for (String s : same) { // 检测是否出现重复数据
				if (l.getId().equals(s)) {
					flag = true; // 发现重复ID则跳过此次循环
					break;
				}
			}

			if (flag) {

				if ((i + 1) == ldpaMtxfjlList.size()) {// 计算最后一个月

					allMonthMap.put(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')), dayList);

					dayList = new ArrayList<>();

				} else {// 统计每一个月

					String nextMonth = CommUtil.getSimpleDateFormat(ldpaMtxfjlList.get(i + 1).getDate());
					if (!date.substring(0, date.lastIndexOf('-'))
							.equals(nextMonth.substring(0, nextMonth.lastIndexOf('-')))) {

						allMonthMap.put(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')), dayList);

						dayList = new ArrayList<>();
					}
				}
				flag = false;
				continue;
			}
			AnnualReport annualReport = new AnnualReport();
			totalConsumption = l.getExpenditure() - l.getIncome();// 记下第一天金额

			for (DpConsumerDetails lm : ldpaMtxfjlList) {

				if (l.getId().equals(lm.getId())) {// 不与自己比较
					continue;
				} else if (l.getDate().equals(lm.getDate())) {// 检测相同日期的选项
					totalConsumption = totalConsumption + lm.getExpenditure() - lm.getIncome();// 记下相同的天数的金额
					same.add(lm.getId()); // 将已经匹配过的ID加入same中
				}
			}

			annualReport.setAmout(totalConsumption);
			annualReport.setDate(date);
			annualReport.setYear(date.substring(0, date.lastIndexOf('-')));
			dayList.add(annualReport); // 登记到dayList
			totalConsumption = 0; // 重置totalConsumption

		}

		return allMonthMap;
	}

	// 获取一年中每天消费总金额
	public static Map<String, List<AnnualReport>> getYearSpendingEveryDay(String year) {
		// 查询消费记录表
		List<DpConsumerDetails> ldpaMtxfjlList = ldpaMtxfjlService.selectByYear(year+"-%");

		if (ldpaMtxfjlList.isEmpty())
			try {
				throw new Error("消费表为空");
			} catch (Error e) {
				e.printStackTrace();
			}
		Map<String, List<AnnualReport>> allMonthMap = new HashMap<>();

		List<AnnualReport> dayList = new ArrayList<>();
		// 将日期相同的数据进行相加
		List<String> same = new ArrayList<>();// 接收重复数据的ID
		boolean flag = false; // 重复标志
		boolean onlyOneDayFlag = false; // 记录是否只有一天
		
		float totalConsumption = 0; // 初始金额
		float totalConsumptionOnly = 0;// 是否有变化
		
		for (int i = 0; i < ldpaMtxfjlList.size(); i++) {

			DpConsumerDetails l = ldpaMtxfjlList.get(i);

			String date = CommUtil.getSimpleDateFormat(l.getDate());

			for (String s : same) { // 检测是否出现重复数据
				if (l.getId().equals(s)) {
					flag = true; // 发现重复ID则跳过此次循环
					break;
				}
			}

			if (flag || onlyOneDayFlag) {

				if ((i + 1) == ldpaMtxfjlList.size()) {// 计算最后一个月(最后一条记录)

					allMonthMap.put(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')), dayList);

					dayList = new ArrayList<>();

				} else {// 统计每一个月

					String nextMonth = CommUtil.getSimpleDateFormat(ldpaMtxfjlList.get(i + 1).getDate());
					
					System.out.println("month:"+date+" nextMonth:"+nextMonth);
					
					if (!date.substring(0, date.lastIndexOf('-'))
							.equals(nextMonth.substring(0, nextMonth.lastIndexOf('-')))) {

						allMonthMap.put(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')), dayList);

						dayList = new ArrayList<>();
					}
				}
				flag = false;
				onlyOneDayFlag = false;
				continue;
			}
			
			AnnualReport annualReport = new AnnualReport();
			totalConsumption = l.getExpenditure() - l.getIncome();// 记下第一天金额
			totalConsumptionOnly = totalConsumption;
			
			for (DpConsumerDetails lm : ldpaMtxfjlList) {

				if (l.getId().equals(lm.getId())) {// 不与自己比较
					continue;
				} else if (l.getDate().equals(lm.getDate())) {// 检测相同日期的选项
					totalConsumption = totalConsumption + lm.getExpenditure() - lm.getIncome();// 记下相同的天数的金额
					same.add(lm.getId()); // 将已经匹配过的ID加入same中
					onlyOneDayFlag = false;
				}
			}
			
			if(totalConsumptionOnly == totalConsumption)
				onlyOneDayFlag = true;
			
			annualReport.setAmout(totalConsumption);
			annualReport.setDate(date);
			annualReport.setYear(date.substring(0, date.lastIndexOf('-')));
			dayList.add(annualReport); // 登记到dayList
			totalConsumption = 0; // 重置totalConsumption

		}

		return allMonthMap;
	}

	public static Map<String, Float> getAllRatio() {

		Map<String, Float> map = new HashMap<>();

		// 查询消费记录表
		List<DpConsumerDetails> ldpaMtxfjlList = ldpaMtxfjlService.selectAllInfo();

		// 将日期相同的数据进行相加
		List<String> same = new ArrayList<>();// 接收重复数据的ID
		boolean flag = false; // 重复标志
		
		float totalConsumption = 0; // 初始金额
		for (int i = 0; i < ldpaMtxfjlList.size(); i++) {

			DpConsumerDetails l = ldpaMtxfjlList.get(i);

			for (String s : same) { // 检测是否出现重复数据
				if (l.getId().equals(s)) {
					flag = true; // 发现重复ID则跳过此次循环
					break;
				}
			}

			if (flag) {

				flag = false;
				continue;
			}

			totalConsumption = l.getExpenditure() - l.getIncome();// 记下第一天金额
					
			String typeFirst = "";
			if (l.getConsumptionType() != null)
				typeFirst = l.getConsumptionType();

			for (DpConsumerDetails lm : ldpaMtxfjlList) {

				if (l.getId().equals(lm.getId())) {// 不与自己比较
					continue;
				} else {// 检测相同消费类型的选项

					String typeEnd = "";
					if (lm.getConsumptionType() != null) {

						typeEnd = lm.getConsumptionType();
					}

					if (CommUtil.isNotNull(typeFirst) && CommUtil.isNotNull(typeEnd))
						if (typeFirst.equals(typeEnd)) {
							totalConsumption = totalConsumption + lm.getExpenditure() - lm.getIncome();// 记下相同的天数的金额
							same.add(lm.getId()); // 将已经匹配过的ID加入same中
						}

				}
			}
			
//			if(onlyOneDayFlag){
//				totalConsumption = totalConsumption + lm.getExpenditure() - lm.getIncome();// 记下相同的天数的金额
//				same.add(l.getId()); // 将已经匹配过的ID加入same中
//				onlyOneDayFlag = false;
//			}
			
			if (CommUtil.isNotNull(typeFirst))
				map.put(typeFirst, totalConsumption);

			totalConsumption = 0; // 重置totalConsumption

		}
		
		//Arrays.sort(map);
		
		return map;
	}
}
