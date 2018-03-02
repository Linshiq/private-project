package com.lsq.web.login;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsq.controller.ControllerLogin;
import com.lsq.db.dao.UserMapper;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年6月9日 下午1:57:38 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       登陆校验			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年6月9日-下午1:57:38</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class LoginCheck {
	
	private static Logger logger = Logger.getLogger(LoginCheck.class);
	
	@Autowired
	private UserMapper userService;
	
	/**
	 * @param psd 
	 * @param user 
	 * @Author linshiqin
	 *         <p>
	 *         <li>2017年6月9日-下午2:01:26</li>
	 *         <li>功能说明：登陆校验主程序</li>
	 *         </p>
	 */
	public static Map<String,Object> doMain(Map<String,Object> map, String user, String psd) {
		
		logger.info("LoginCheck.doMain begin >>>>>>>>>>>>>>>>>>>.");
		
		
		
		return map;

	}
}
