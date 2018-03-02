package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.message.resp.Article;
import com.message.resp.NewsMessage;
import com.message.resp.TextMessage;
import com.tool.StringUtil;
import com.urils.MessageUtil;

import hidden_funtion.fuck_human.FuckHuman;
import hidden_funtion.fuck_human.GetFuckHumanMsg;
import hidden_funtion.goodorbad.Detection;
import hidden_funtion.qq_face.QqFace;
import hidden_funtion.tongji_user.WeiXinUserName;
import hidden_funtion.tongji_user.WriteTxt;
import menu_center.translation.BaiduTranslateService;
import menu_center.xiaoli.NJFUSchoolCalendar;
import menu_right.history_today.TodayInHistoryService;
import menu_right.joke.Joke;
import menu_right.joke.base.JokeList;
import menu_right.weather_forecast.WeatherForecastService;
import menu_right.weather_forecast.WeatherSpecies;
import service.textMessge.HelpMenu;
import service.textMessge.MainMenu;
import service.textMessge.TranslationMenu;
import service.textMessge.WeatherForecastMenu;
import service.toDealWith.TextDealWith;


/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月19日 上午9:31:58 
* @return  核心服务类
*/
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {

		String respMessage = null;
		String openid = request.getParameter("openid");
		String openkey = request.getParameter("openkey");
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			String msgContent = requestMap.get("Content");
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setFuncFlag(0);
			String weiXinID = "";
			if(StringUtil.strIsNotEmpty(fromUserName))
				weiXinID = fromUserName;
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

				//respContent = TextDealWith.getDealWithResults(msgContent);
				if (QqFace.isQqFace(msgContent)) {
					
					writeToTxt(weiXinID, "isQqFace");
					respContent = msgContent;
				
				} else if (FuckHuman.isFuckHumanOneWork(msgContent)) {
					
					writeToTxt(weiXinID, "isFuckHumanOneWork");
					respContent = GetFuckHumanMsg.getFuckHumanMsg();
				
				} else if (msgContent.equals("1")) {
					respContent = "点击<a href=\"http://223.2.96.8:8090/\">南林教务管理系统网站</a>进入";
				} else if (msgContent.equals("2")) {
					respContent = "点击\n<a href=\"http://223.2.96.8:8090/ZNPK/KBFB_ClassSel.aspx\">南林班级课表</a>\n进入查询网站";
				} else if (msgContent.equals("3")) {
					respContent = "点击\n<a href=\"http://223.2.96.8:8090/ZNPK/KBFB_RoomSel.aspx\">南林教室课表</a>\n进入查询网站";
				} else if (msgContent.equals("4")) {
					respContent = "请输入您的班级(不要加入空格等其它信息):";
				} else if (msgContent.equals("5")) {
					// 创建图文消息
					NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
					String ImgUrl = MessageUtil.getImgUrl(request, "NJFU.jpg");
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("南林平面图");
					article.setPicUrl(ImgUrl);
					article.setUrl(ImgUrl);
					article.setDescription("看不到图片不要急,等等就有了");
					
					articleList.add(article);// 单图文消息				
					newsMessage.setArticleCount(articleList.size());// 设置图文消息个数					
					newsMessage.setArticles(articleList);// 设置图文消息包含的图文集合
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				} else if (msgContent.equals("6")) {
					// 创建图文消息
					NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
					String ImgUrl = MessageUtil.getImgUrl(request, "subway.jpg");
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("南林地铁信息图");
					article.setPicUrl(ImgUrl);
					article.setUrl("http://" + request.getServerName() // 服务器地址
					+ request.getContextPath() + "/static/jsp/baiDuDiTuSayway.jsp");
			article.setDescription("地铁三号在正门门口,在地铁站内从 南京林业大学 出口出去 即可看到本校大门 \n ");
					article.setDescription("地铁三号在正门门口,在地铁站内从 南京林业大学 出口出去 即可看到本校大门 \n ");
					// 单图文消息
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				
				} else if (msgContent.equals("7")) {
					respContent = "因为程序猿菌copy键坏了，所以这里就省略了~~";
					return respMessage;
				} else if (msgContent.equals("8")) {
					respContent = "我能为你提供的只有这个网站了\n\n<a href=\"http://y.qq.com/#type=toplist&p=top_index\">QQ音乐</a>\n\n你可以不喜欢,但你不能打我!!\nPs:听,是需要流量的,你有WIFI就另说";
				} else if (msgContent.startsWith("翻译")) {
					writeToTxt(weiXinID, "翻译系统");
					String keyWord = msgContent.replaceAll("^翻译", "").trim();
					if ("".equals(keyWord)) {
						respContent = "";
					} else {
						respContent = BaiduTranslateService.translate(keyWord);
					}
				} else if (msgContent.startsWith("班级")) {
					writeToTxt(weiXinID, "校历查询");
					String classNum = msgContent.replaceAll("^班级", "").trim();
					respContent = NJFUSchoolCalendar.getSchoolCalenda(classNum.trim(), request);
				} else if (msgContent.startsWith("城市")) {
					writeToTxt(weiXinID, "天气预报");
					String cityname = msgContent.replaceAll("^城市", "").trim();
					if (cityname.equals(""))
						respContent = "请输入城市名字! \n 格式为:城市+城市名";
					else {
						String weatherForecastList = WeatherForecastService.searchWeatherForecast(cityname);
						if (weatherForecastList.equals("")) {
							respContent = "没有找到您输入的城市名相关的天气信息";
						} else {
							String[] weatherArray = weatherForecastList.split(",");
							NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
							List<Article> articleList = new ArrayList<Article>();
							Article article = new Article();
							article.setTitle(weatherArray[0]);
							article.setPicUrl("http://" + request.getServerName() + request.getContextPath() + "/img/"
									+ WeatherSpecies.whatSpecies(weatherArray[0]));
							article.setDescription(weatherArray[1]);
							articleList.add(article);
							newsMessage.setArticleCount(articleList.size());
							// 设置图文消息包含的图文集合
							newsMessage.setArticles(articleList);
							// 将图文消息对象转换成xml字符串
							respMessage = MessageUtil.newsMessageToXml(newsMessage);
							return respMessage;
						}
					}
				} else if (msgContent.equals("笑话")) {
					writeToTxt(weiXinID, "幽默笑话");
					List<JokeList> jokeLists = Joke.searchJoke();
					StringBuffer sb = new StringBuffer();
					if (jokeLists.get(0).getCt().equals(""))
						sb.append("数据异常");
					else
						for (JokeList j : jokeLists) {
							sb.append(j.getText()).append("\n\n");
						}
					String jokeStr = sb.toString();
					jokeStr = jokeStr.replaceAll("<p>", "");
					jokeStr = jokeStr.replaceAll("</p>", "");
					// 创建图文消息
					NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("");
					article.setDescription(jokeStr);
					// 单图文消息
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				} else if (msgContent.equals("帮助")) {
					
					writeToTxt(weiXinID, "帮助菜单");
					respContent = HelpMenu.getHelpMenu();
				
				} else if (msgContent.equals("显示所有等级")) {
					
					writeToTxt(weiXinID, "显示所有等级");
					respContent = Detection.getAllLevel(request);
				
				} else if (msgContent.equals("查看使用情况")) {
					NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setUrl("http://" + request.getServerName() // 服务器地址
							+ request.getContextPath() + "/static/jsp/userFrequency.jsp");
					article.setDescription("查看使用情况");
					articleList.add(article);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				} else if (msgContent.equals("使用详细情况")) {
					NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setUrl("http://" + request.getServerName() // 服务器地址
							+ request.getContextPath() + "/login");
					article.setDescription("使用详细情况");
					articleList.add(article);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				} else if (msgContent.equals("电脑报修")) {
					writeToTxt(weiXinID, "电脑报修");
					// 创建图文消息
					NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("");
					article.setUrl("http://" + request.getServerName() // 服务器地址
							+ request.getContextPath() + "/static/jsp/bbjbaoxiu.jsp");
					article.setDescription("点击进入报修界面\n 选择时间处可能存在延迟，等等就好");
					// 单图文消息
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				}else if (Detection.isName(msgContent)) {
					writeToTxt(weiXinID, "名字人品");
					respContent = Detection.getDetectionResult(msgContent, request);
					if (respContent.length() > 300) {
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle(msgContent);
						article.setPicUrl("");
						article.setUrl("");
						article.setDescription(respContent);
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					}
				} else {
					respContent = MainMenu.getMainMenu();
				}

			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				respContent = "您发送的是图片消息,暂不处理该消息!";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				respContent = "您发送的是地理位置消息,暂不处理该消息!";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				respContent = "您发送的是链接消息,暂不处理该消息!";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				respContent = "您发送的是音频消息,暂不处理该消息!";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！ 输入任意字符则可以弹出帮助菜单!";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					return respMessage;
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					
					String eventKey = requestMap.get("EventKey");
					if (eventKey.equals("nanlinpingmiantu")) {
						writeToTxt(weiXinID, "南林平面图");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						String ImgUrl = MessageUtil.getImgUrl(request, "NJFU.jpg");
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("南林平面图");
						article.setPicUrl(ImgUrl);
						// "http://" + request.getServerName() //服务器地址
						// + request.getContextPath()
						// + "/static/jsp/NJFUBaiDuDT.jsp"
						article.setUrl("http://" + request.getServerName() // 服务器地址
								+ request.getContextPath() + "/static/jsp/NJFUBaiDuDT.jsp");
						article.setDescription("看不到图片不要急,等等就有了");
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("nanlinsubway")) {
						writeToTxt(weiXinID, "周边地铁");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						String ImgUrl = MessageUtil.getImgUrl(request, "subway.jpg");
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("南林地铁信息图");
						article.setPicUrl(ImgUrl);
						article.setUrl("http://" + request.getServerName() // 服务器地址
								+ request.getContextPath() + "/static/jsp/baiDuDiTuSayway.jsp");
						article.setDescription("地铁三号在正门门口,在地铁站内从 南京林业大学 出口出去 即可看到本校大门 \n ");
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("translation")) {
						writeToTxt(weiXinID, "翻译系统");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setDescription(TranslationMenu.getTranslateUsage());
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("xiaoli")) {
						writeToTxt(weiXinID, "校历查询");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setDescription("请输入您的班级(请不要输入其它多余的信息):\n\n例如:班级1208011\n\n请记得点击发送(在您的键盘界面)");
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("bjbbaoxiu")) {
						writeToTxt(weiXinID, "电脑报修");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setUrl("http://" + request.getServerName() // 服务器地址
								+ request.getContextPath() + "/static/jsp/bbjbaoxiu.jsp");
						article.setDescription("点击进入报修界面\n 选择时间处可能存在延迟，等等就好");
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("huiyijilu")) {
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setUrl("http://" + request.getServerName() // 服务器地址
								+ request.getContextPath() + "/static/jsp/huiyidengji.jsp");
						article.setDescription("点击进入登记界面");
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("joke")) {
						writeToTxt(weiXinID, "幽默笑话");

						List<JokeList> jokeLists = Joke.searchJoke();
						StringBuffer sb = new StringBuffer();
						if (jokeLists.get(0).getCt().equals(""))
							sb.append("数据异常");
						else
							for (JokeList j : jokeLists) {
								sb.append(j.getText()).append("\n\n");
							}
						String jokeStr = sb.toString();
						jokeStr = jokeStr.replaceAll("<p>", "");
						jokeStr = jokeStr.replaceAll("</p>", "");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setDescription(jokeStr);
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("qiandao")) {
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setUrl("http://" + request.getServerName() // 服务器地址
								+ request.getContextPath() + "/static/jsp/studentqiandao.jsp");
						article.setDescription("点击进入签到界面");
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("todayinHistory")) {
						writeToTxt(weiXinID, "历史上的今天");

						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setDescription(TodayInHistoryService.getTodayInHistoryInfo());
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					} else if (eventKey.equals("weatherForecast")) {
						writeToTxt(weiXinID, "天气预报");
						// 创建图文消息
						NewsMessage newsMessage = getNewsMessage(fromUserName, toUserName);
						List<Article> articleList = new ArrayList<Article>();
						Article article = new Article();
						article.setTitle("");
						article.setDescription(WeatherForecastMenu.getUsage());
						// 单图文消息
						articleList.add(article);
						// 设置图文消息个数
						newsMessage.setArticleCount(articleList.size());
						// 设置图文消息包含的图文集合
						newsMessage.setArticles(articleList);
						// 将图文消息对象转换成xml字符串
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						return respMessage;
					}
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}

	public static void writeToTxt(String weiXinID, String funtionName) {

		try {
			WriteTxt.write(weiXinID, funtionName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static NewsMessage getNewsMessage(String fromUserName, String toUserName) {
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
		return newsMessage;

	}
}

/*
 * else if (msgContent.equals("1")) { respContent =
 * "点击<a href=\"http://223.2.96.8:8090/\">南林教务管理系统网站</a>进入"; } else if
 * (msgContent.equals("2")) { respContent =
 * "点击\n<a href=\"http://223.2.96.8:8090/ZNPK/KBFB_ClassSel.aspx\">南林班级课表</a>\n进入查询网站"
 * ; } else if (msgContent.equals("3")) { respContent =
 * "点击\n<a href=\"http://223.2.96.8:8090/ZNPK/KBFB_RoomSel.aspx\">南林教室课表</a>\n进入查询网站"
 * ; } else if (msgContent.equals("4")) { respContent = "请输入您的班级(不要加入空格等其它信息):";
 * } else if (msgContent.equals("5")) { // 创建图文消息 NewsMessage newsMessage =
 * getNewsMessage(fromUserName, toUserName); String ImgUrl =
 * MessageUtil.getImgUrl(request, "NJFU.jpg"); List<Article> articleList = new
 * ArrayList<Article>(); Article article = new Article();
 * article.setTitle("南林平面图"); article.setPicUrl(ImgUrl); article.setUrl(ImgUrl);
 * article.setDescription("看不到图片不要急,等等就有了"); // 单图文消息 articleList.add(article);
 * // 设置图文消息个数 newsMessage.setArticleCount(articleList.size()); // 设置图文消息包含的图文集合
 * newsMessage.setArticles(articleList); // 将图文消息对象转换成xml字符串 respMessage =
 * MessageUtil.newsMessageToXml(newsMessage); return respMessage; } else if
 * (msgContent.equals("6")) { // 创建图文消息 NewsMessage newsMessage =
 * getNewsMessage(fromUserName, toUserName); String ImgUrl =
 * MessageUtil.getImgUrl(request, "subway.jpg"); List<Article> articleList = new
 * ArrayList<Article>(); Article article = new Article();
 * article.setTitle("南林地铁信息图"); article.setPicUrl(ImgUrl);
 * article.setUrl(ImgUrl); article.setDescription(
 * "地铁三号在正门门口,在地铁站内从 南京林业大学 出口出去 即可看到本校大门 \n "); // 单图文消息
 * articleList.add(article); // 设置图文消息个数
 * newsMessage.setArticleCount(articleList.size()); // 设置图文消息包含的图文集合
 * newsMessage.setArticles(articleList); // 将图文消息对象转换成xml字符串 respMessage =
 * MessageUtil.newsMessageToXml(newsMessage); return respMessage; } else if
 * (msgContent.equals("7")) { // 创建图文消息 NewsMessage newsMessage =
 * getNewsMessage(fromUserName, toUserName); List<Article> articleList = new
 * ArrayList<Article>(); // 单图文消息 articleList.add(ArticleNews.onlyArticeNews());
 * // Article article = new Article(); // article.setTitle("南林风采!"); //
 * article.setDescription("sdasdas"); // article.setPicUrl(""); //
 * article.setUrl("http://www.njfu.edu.cn/"); // articleList.add(article); //
 * 设置图文消息个数 newsMessage.setArticleCount(articleList.size()); // 设置图文消息包含的图文集合
 * newsMessage.setArticles(articleList); // 将图文消息对象转换成xml字符串 respMessage =
 * MessageUtil.newsMessageToXml(newsMessage); return respMessage; } else if
 * (msgContent.equals("8")) { respContent =
 * "我能为你提供的只有这个网站了\n\n<a href=\"http://y.qq.com/#type=toplist&p=top_index\">QQ音乐</a>\n\n你可以不喜欢,但你不能打我!!\nPs:听,是需要流量的,你有WIFI就另说"
 * ; }
 */