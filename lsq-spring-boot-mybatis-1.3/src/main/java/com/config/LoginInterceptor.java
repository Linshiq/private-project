package com.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lsq.util.RedisUtils;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年8月10日 下午3:23:22 
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
 *         <li>2017年8月10日-下午3:23:22</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private RedisUtils redisUtils;
	private final static String SESSION_KEY_PREFIX = "session:";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			return true;
		}
		handlerSession(request);

		final HandlerMethod handlerMethod = (HandlerMethod) handler;
		final Method method = handlerMethod.getMethod();
		final Class<?> clazz = method.getDeclaringClass();
		if (clazz.isAnnotationPresent(Auth.class) || method.isAnnotationPresent(Auth.class)) {
			if (request.getAttribute(Constants.USER_CODE_SESSION_KEY) == null) {

				throw new Exception();

			} else {
				return true;
			}
		}

		return true;

	}

	public void handlerSession(HttpServletRequest request) {
		String sessionId = request.getHeader(Constants.SESSION_KEY);
		if (org.apache.commons.lang3.StringUtils.isBlank(sessionId)) {
			sessionId = (String) request.getSession().getAttribute(Constants.SESSION_KEY);
		}
		if (org.apache.commons.lang3.StringUtils.isNotBlank(sessionId)) {
			SessionData model = (SessionData) redisUtils.get(SESSION_KEY_PREFIX + sessionId);
			if (model == null) {
				return;
			}
			request.setAttribute(Constants.SESSION_KEY, sessionId);
			Integer userCode = model.getUserCode();
			if (userCode != null) {
				request.setAttribute(Constants.USER_CODE_SESSION_KEY, Long.valueOf(userCode));
			}
			String mobile = model.getMobileNumber();
			if (mobile != null) {
				request.setAttribute(Constants.MOBILE_NUMBER_SESSION_KEY, mobile);
			}
		}
		return;
	}
}
