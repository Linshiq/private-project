package lsq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import api.bean.answerrobot.AnswerRobot;
import api.bean.brainteasers.BrainTeasers;
import api.bean.featuredwechat.WeChatArticle;
import api.bean.featuredwechat.WeChatArticleType;
import api.bean.hotwechat.HotWechat;
import api.bean.hotwechat.HotWechatInput;
import lsq.data.api.processing.AnswerRobotApiProcessBaiDu;
import lsq.data.api.processing.BrainTeasersApiProcess;
import lsq.data.api.processing.FeatureWeChatProcess;
import lsq.data.api.processing.HotWeChatApiProcess;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月18日 上午10:59:38 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： blog界面control控制器
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月18日-上午10:59:38</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
@Controller
@RequestMapping("/")
public class BlogController {

	Logger logger = Logger.getLogger(BlogController.class);

	@RequestMapping("/blog")
	public String getBlogIndex(Model model, @RequestParam(value = "num", required = false) String num) { // required为参数不一定需要传

		HotWechatInput input = new HotWechatInput();

		if (CommUtil.isNull(num)) {
			input.setNum("10");
		} else {
			input.setNum(num);
		}
		List<HotWechat> l = HotWeChatApiProcess.getHotWechatList(input);

		model.addAttribute("contentWeChatList", l);

		return "/WEB-INF/jsp/blog/blog_index";
	}

	@RequestMapping("/blog/jxwechat")
	public String getBlogJXWeChat(Model model, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "page", required = false) String page) { // required为参数不一定需要传

		String httpArg = "";
		List<WeChatArticle> weChatArticleList = null;
		
		
		if (!CommUtil.isNotNull(id)) {
			
			httpArg = "typeId=19&page=1";
			weChatArticleList = FeatureWeChatProcess.getWeChatArticle(httpArg);
			model.addAttribute("page",1);
			
		} else {
			if (CommUtil.isNotNull(page)) {
				String nextPage = (Integer.parseInt(page)+1) + "";
				httpArg = "typeId=" + id + "&page=" + nextPage;
				model.addAttribute("page",nextPage);
			} else{
				httpArg = "typeId=" + id;
				model.addAttribute("page",1);
			}
			model.addAttribute("id", id);
			weChatArticleList = FeatureWeChatProcess.getWeChatArticle(httpArg);
		}
		
		List<WeChatArticleType> weChatArticleTypeList = FeatureWeChatProcess.getArticleType();
		model.addAttribute("weChatArticleTypeList", weChatArticleTypeList);
		model.addAttribute("weChatArticleList", weChatArticleList);

		return "/WEB-INF/jsp/blog/blog_index_wechat";
	}

	// 脑筋急转弯
	@RequestMapping("/blog/brain_teasers")
	public String getBlogBrainTeasers(Model model) { // required为参数不一定需要传

		BrainTeasers brainTeasers = BrainTeasersApiProcess.getBrainTeasersOne();

		model.addAttribute("brainTeasers", brainTeasers);

		return "/WEB-INF/jsp/blog/blog_brain_teasers";
	}

	// 随机问答
	@RequestMapping("/blog/answer_robot")
	public String getBlogAnswerRobot(Model model, @RequestParam(value = "info", required = false) String info) { // required为参数不一定需要传

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("info", info);

		AnswerRobot answerRobot = AnswerRobotApiProcessBaiDu.getAnswer(info);

		// AnswerRobot answerRobot = AnswerRobotApiProcess.getAnswer(params);

		answerRobot.setQuestion(info);

		model.addAttribute("answerRobot", answerRobot);

		return "/WEB-INF/jsp/blog/blog_answer_robot";
	}
}
