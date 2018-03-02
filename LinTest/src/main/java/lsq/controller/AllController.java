/**
 * 
 */package lsq.controller;/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月17日 下午6:42:52 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lsq.service.dao.HtmlServiceDao;

/**
* <p>
* 文件功能说明：
*       			
* </p>
* 
* @Author linshiqin
*         <p>
*         <li>2016年10月17日-下午6:42:52</li>
*         <li>修改记录</li>
*         <li>-----------------------------------------------------------</li>
*         <li>标记：修订内容</li>
*         <li>linshiqin：创建注释模板</li>
*         <li>-----------------------------------------------------------</li>
*         </p>
*/
 @Controller
 @RequestMapping("/")
 public class AllController {

	Logger logger = Logger.getLogger(AllController.class);
 	HtmlServiceDao htmlDao;
 	
 	@RequestMapping("/index")
 	public String getIndex(Model model){  //主页
 		logger.debug("AllController.getIndex star");
 		
 		logger.debug("AllController.getIndex end");
 		return "/WEB-INF/jsp/index/index2";
 	}
 	@RequestMapping("/ditu")
 	public String getLocation(Model model){

 		return "/WEB-INF/jsp/ditu";
 	}
 	@RequestMapping("/test")
 	public String getTest(Model model){

 		
 		return "/WEB-INF/jsp/1";
 	}
 	@RequestMapping("/login")
 	public String getLogin(Model model){
 		
 		return "/WEB-INF/jsp/login";
 	}
 	
// 	@RequestMapping("/blog")
// 	public String getBlogIndex(Model model,@RequestParam(value = "num", required=false) String num){ //required为参数不一定需要传
// 		
// 		HotWechatInput input = new HotWechatInput();
// 		
// 		if(CommUtil.isNull(num)){
// 			input.setNum("10");
// 		}else{
// 			input.setNum(num);
// 		}
// 		List<HotWechat> l = HotWeChatApiProcess.getHotWechatList(input);
// 		
// 		model.addAttribute("contentWeChatList", l) ;
// 		
// 		return "/WEB-INF/jsp/blog/blog_index";
// 	}
 	@RequestMapping("/to")
 	public String getJsp2(Model model){
 		

 		
 		return "/WEB-INF/jsp/2";
 	}
 	
 	@RequestMapping("/test/{name}")
 	public String getJsp(Model model,@PathVariable("name") String id){//自动将{name}的值给予id
 		
 		model.addAttribute("name",id);
 		
 		return "/WEB-INF/jsp/1";
 	}

 }

