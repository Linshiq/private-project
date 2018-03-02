package lsq.data.api.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.bean.featuredwechat.WeChatArticle;
import api.bean.featuredwechat.WeChatArticleType;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年12月14日 上午10:08:57 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 微信精选文件入口
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年12月14日-上午10:08:57</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class FeatureWeChatProcess {

	private static String httpUrlType = "http://apis.baidu.com/showapi_open_bus/weixin/weixin_article_type";

	private static String httpUrlList = "http://apis.baidu.com/showapi_open_bus/weixin/weixin_article_list";

	public static List<WeChatArticleType> getArticleType() {
		List<WeChatArticleType> weChatArticleTypeList = new ArrayList<>();

		// 创建一个Gson对象
		Gson gson = new Gson();

		JsonParser parse = new JsonParser(); // 创建json解析器

		JsonObject object = (JsonObject) parse.parse(BaiDuApiProcess.request(FeatureWeChatProcess.httpUrlType, ""));

		if (object.get("showapi_res_code").toString().equals("0")) {

			JsonObject jsonBody = (JsonObject) parse.parse(object.get("showapi_res_body").toString());

			JsonArray jsonArray = parse.parse(jsonBody.get("typeList").toString()).getAsJsonArray();

			// 遍历JsonArray对象
			Iterator<JsonElement> it = jsonArray.iterator();
			while (it.hasNext()) {
				JsonElement e = (JsonElement) it.next();
				WeChatArticleType hotWechat = new WeChatArticleType();
				// JsonElement转换为JavaBean对象
				hotWechat = gson.fromJson(e, WeChatArticleType.class);
				// System.out.println(hotWechat.toString());
				weChatArticleTypeList.add(hotWechat);
			}

		} else {
			// TODO 应该抛异常
		}

		return weChatArticleTypeList;
	}

	public static List<WeChatArticle> getWeChatArticle(String httpArg) {

		List<WeChatArticle> weChatArticleList = new ArrayList<>();

		// 创建一个Gson对象
		Gson gson = new Gson();

		JsonParser parse = new JsonParser(); // 创建json解析器

		JsonObject object = (JsonObject) parse
				.parse(BaiDuApiProcess.request(FeatureWeChatProcess.httpUrlList, httpArg));

		if (object.get("showapi_res_code").toString().equals("0")) {
			// JSON对象解析
			JsonObject jsonBody = (JsonObject) parse.parse(object.get("showapi_res_body").toString());

			JsonObject jsonBodyNext = null;
			JsonArray jsonArray = null;
			if (jsonBody.get("pagebean") != null) {
				jsonBodyNext = (JsonObject) parse.parse(jsonBody.get("pagebean").toString());

				if (jsonBodyNext.get("contentlist") != null){
					jsonArray = parse.parse(jsonBodyNext.get("contentlist").toString()).getAsJsonArray();
					// 遍历JsonArray对象
					Iterator<JsonElement> it = jsonArray.iterator();
					while (it.hasNext()) {
						JsonElement e = (JsonElement) it.next();
						WeChatArticle hotWechat = new WeChatArticle();
						// JsonElement转换为JavaBean对象
						hotWechat = gson.fromJson(e, WeChatArticle.class);
						// System.out.println(hotWechat.toString());
						weChatArticleList.add(hotWechat);
					}
				}
			}
			

		} else {
			// TODO 应该抛异常
		}

		return weChatArticleList;
	}

	public static void main(String[] args) {

		List<WeChatArticle> l = FeatureWeChatProcess.getWeChatArticle("typeId=19&page=2");

		for (WeChatArticle w : l) {

			System.out.println(w.toString());
		}

	}
}
