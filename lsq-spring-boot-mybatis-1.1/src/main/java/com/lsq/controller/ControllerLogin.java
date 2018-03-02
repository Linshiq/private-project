package com.lsq.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@Autowired
	private UserMapper userService;

	@RequestMapping(value = "")
	public String getToLogin(Map<String, Object> map) {

		return "login";

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String getLogin(Map<String, Object> map, HttpServletRequest request) {

		String user = request.getParameter("username");
		String psd = request.getParameter("password");

		if (CommUtil.isNotNull(user) && CommUtil.isNotNull(psd)) {

			map = LoginCheck.doMain(map, user, psd);

			User i = userService.selectByPrimaryKey(user);

			System.out.println("ID:" + i.getId() + "pass" + i.getPassword());

			if (user.equals(i.getId()) && i.getPassword().equals(psd)) {
				
				ControllerBack backContl = new ControllerBack();
				
				return backContl.getToIndex(map);
			}else{
				
				return "time";
			}

		} else {
			return "helloHtml";
		}
	}
}
