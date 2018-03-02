package com.lsq.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsq.web.content.IndexContent;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年12月29日 下午6:24:40 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： thymeleaf 模板
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年12月29日-下午6:24:40</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/")
public class ControllerHtml {

	@RequestMapping("/xx")
	public String getxx(Map<String, Object> map) {

		map.put("hello", "from TemplateController.helloHtml");
		return "helloHtml";
	}

	@RequestMapping("/o")
	public String getTime(Map<String, Object> map) {

		return "login";
	}

	@RequestMapping("/")
	public String getIndex(Map<String, Object> map) {

		map = IndexContent.getIndexConten(map);

		map.put("ctx", ClassUtils.getDefaultClassLoader().getResource("").getPath());

		return "index";
	}

	/*
	 * @PostMapping("/greeting") public String greetingSubmit(@ModelAttribute
	 * Greeting greeting) { return "result"; }
	 */

}
