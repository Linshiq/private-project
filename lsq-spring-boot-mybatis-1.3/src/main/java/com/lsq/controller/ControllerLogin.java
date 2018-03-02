package com.lsq.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.config.LoginInterceptor;
import com.lsq.db.dao.UserMapper;
import com.lsq.db.model.User;
import com.lsq.util.CommUtil;
import com.lsq.web.login.LoginCheck;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月12日 上午9:29:48 
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
 *         <li>2017年6月12日-上午9:29:48</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/login")
public class ControllerLogin {
	
	private Logger logger = Logger.getLogger(ControllerLogin.class);
	
	@Autowired
	private UserMapper userService;

	@RequestMapping(value = "")
	public String getToLogin(Map<String, Object> map) {

		return "login";

	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String getLogin(Map<String, Object> map, HttpServletRequest request, HttpSession session) {
		
		logger.info("user = "+ request.getParameter("username"));
		
		String user = request.getParameter("username");
		String psd = request.getParameter("password");

		if (CommUtil.isNotNull(user) && CommUtil.isNotNull(psd)) {

			map = LoginCheck.doMain(map, user, psd);

			User i = userService.selectByPrimaryKey(user);

			System.out.println("ID:" + i.getId() + "pass" + i.getPassword());

			if (user.equals(i.getId()) && i.getPassword().equals(psd)) {
				
				ControllerBack backContl = new ControllerBack();
				
				// 设置session
		        session.setAttribute(LoginInterceptor.SESSION_KEY, user);
				
				return backContl.getToIndex(map);
			}else{
				
				session.removeAttribute(LoginInterceptor.SESSION_KEY);
				
				return "time";
			}

		} else {
			return "helloHtml";
		}
	}
}
