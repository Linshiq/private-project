package com.lsq.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsq.db.dao.PersonalAccountMapper;
import com.lsq.db.model.PersonalAccount;
import com.lsq.util.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月26日 下午7:53:50 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       珠海吃饭临时开发			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年6月26日-下午7:53:50</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/zhuhai")
public class ControllerEat {

	@Autowired
	private PersonalAccountMapper personalAcct;
	
	@RequestMapping(value="", method = {RequestMethod.POST,RequestMethod.GET})
	public String getAllInfo(Map<String, Object> map,HttpServletRequest request) {
		
		PersonalAccount personalAccount = new PersonalAccount();
		
		String name = request.getParameter("name");
		
		if(CommUtil.isNotNull(name)){
			
			personalAccount.setName(name);
		}
		
		List<PersonalAccount> eatAllInfo = personalAcct.selectInfo(personalAccount);
		
		map.put("eatAllInfo", eatAllInfo);
		
		return "backstage/query/zhuhai_query";
	}
	
	@RequestMapping("/insert")
	public String insertIndex(Map<String, Object> map) {
		
		List<PersonalAccount> eatAllInfo = personalAcct.selectInfo(new PersonalAccount());
		
		map.put("eatAllInfo", eatAllInfo);
		
		return "backstage/insert/zhuhai_insert";
	}
	
	@RequestMapping("/insert_data")
	public String insertEat(Map<String, Object> map,HttpServletRequest request) {
		
		String[] trxnDate = request.getParameterValues("trxnDate");
		String[] name = request.getParameterValues("name");
		String[] consumerType = request.getParameterValues("consumerType");
		String[] changeAmt = request.getParameterValues("changeAmt");
		String[] balance = request.getParameterValues("balance");
		
		List<PersonalAccount> personalAcctInfo = new ArrayList<>();
		
		for (int i = 0; i < name.length; i++) {
			
			System.out.println();
			
			int sortNo = personalAcct.selectMaxSortNo(name[i]);
			
			if(sortNo == 1){
				
				sortNo = 1;
			}else{
				
				sortNo ++ ;
			}
			
			PersonalAccount personalAcct = new PersonalAccount();
						
			personalAcct.setName(name[i]);
			personalAcct.setBalance(new BigDecimal(balance[i]));
			personalAcct.setChangeAmt(new BigDecimal(changeAmt[i]));
			personalAcct.setConsumerType(consumerType[i]);
			personalAcct.setTrxnDate(trxnDate[i]);
			personalAcct.setSortNo(sortNo);
			
			personalAcctInfo.add(personalAcct);
			
			this.personalAcct.insert(personalAcct);
		}
		
		return "backstage/insert/zhuhai_insert";
	}
}
