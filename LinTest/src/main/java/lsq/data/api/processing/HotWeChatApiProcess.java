package lsq.data.api.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import api.bean.hotwechat.HotWechat;
import api.bean.hotwechat.HotWechatInput;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月16日 下午4:11:26 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 微信热门精选API
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月16日-下午4:11:26</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class HotWeChatApiProcess {

	private static String httpUrl = "http://apis.baidu.com/txapi/weixin/wxhot";

	public static List<HotWechat> getHotWechatList(HotWechatInput input) {

		List<HotWechat> hotWechatList = new ArrayList<>();

		StringBuffer httpArg = new StringBuffer();

		if (CommUtil.isNull(input.getNum())) {// 组装响应信息
			return null;
		} else {
			httpArg.append("num=").append(input.getNum());
		}

		if (CommUtil.isNotNull(input.getRand())) {
			httpArg.append("&rand=").append(input.getRand());
		}

		if (CommUtil.isNotNull(input.getPage())) {
			httpArg.append("&page=").append(input.getPage());
		}

		if (CommUtil.isNotNull(input.getSrc())) {
			httpArg.append("&src=").append(input.getSrc());
		}
		// 创建一个Gson对象
		Gson gson = new Gson();
		JsonParser parse = new JsonParser(); // 创建json解析器

		String msg = "";
		try {
			JsonObject jsonTop = (JsonObject) parse.parse(BaiDuApiProcess.request(HotWeChatApiProcess.httpUrl, httpArg.toString())); // 创建jsonObject对象

			// JsonElement json =
			// parse.parse(jsonTop.get("newslist").toString());//取出热门微信内容
			System.out.println(jsonTop.toString());		

			msg = jsonTop.get("code").toString();

			JsonArray jsonArray = null;

			if ("200".equals(msg)) {
				jsonArray = parse.parse(jsonTop.get("newslist").toString()).getAsJsonArray();

				// 遍历JsonArray对象
				Iterator<JsonElement> it = jsonArray.iterator();
				while (it.hasNext()) {
					JsonElement e = (JsonElement) it.next();
					HotWechat hotWechat = new HotWechat();
					// JsonElement转换为JavaBean对象
					hotWechat = gson.fromJson(e, HotWechat.class);
					// System.out.println(hotWechat.toString());
					hotWechatList.add(hotWechat);
				}
			} else {
				HotWechat hotWechat = new HotWechat();
				hotWechat.setTitle("木有信息");
				hotWechatList.add(hotWechat);
			}

		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			}
//		} catch(Exception e){
//			HotWechat hotWechat = new HotWechat();
//			hotWechat.setTitle("木有信息");
//			hotWechatList.add(hotWechat);
//			
//			System.out.println(e);
//		}

		return hotWechatList;
	}

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年11月16日-下午4:16:38</li>
	 *         <li>功能说明：测试而已</li>
	 *         </p>
	 */
	public static void main(String[] args) {
		//String httpUrl = "http://apis.baidu.com/txapi/weixin/wxhot";
		// String httpArg =
		// "num=10";//"num=10&rand=1&word=%E7%9B%97%E5%A2%93%E7%AC%94%E8%AE%B0&page=1&src=%E4%BA%BA%E6%B0%91%E6%97%A5%E6%8A%A5"

		HotWechatInput input = new HotWechatInput();

		input.setNum("10");
		// input.setWord("盗墓笔记");
		List<HotWechat> hotWechatList = HotWeChatApiProcess.getHotWechatList(input);
		for (HotWechat h : hotWechatList) {
			System.out.println(h.toString());
		}
		//
		// //创建一个Gson对象
		// Gson gson = new Gson();
		// JsonParser parse =new JsonParser(); //创建json解析器
		//
		// try {
		// JsonObject jsonTop=(JsonObject) parse.parse(jsonResult);
		// //创建jsonObject对象
		//
		// JsonElement json =
		// parse.parse(jsonTop.get("newslist").toString());//去除热门微信内容
		//
		// JsonArray jsonArray = json.getAsJsonArray();
		//
		// //遍历JsonArray对象
		// HotWechat hotWechat = new HotWechat();
		// Iterator it = jsonArray.iterator();
		// while(it.hasNext()){
		// JsonElement e = (JsonElement)it.next();
		// //JsonElement转换为JavaBean对象
		// hotWechat = gson.fromJson(e, HotWechat.class);
		// System.out.println(hotWechat.toString());
		// }
		//
		// } catch (JsonIOException e) {
		// e.printStackTrace();
		// } catch (JsonSyntaxException e) {
		// e.printStackTrace();
		// }

	}

}
