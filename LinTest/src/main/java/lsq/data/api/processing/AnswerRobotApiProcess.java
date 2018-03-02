package lsq.data.api.processing;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.Api;
import api.bean.answerrobot.AnswerRobot;
import lsq.utils.CommUtil;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年12月6日 下午2:13:08 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 图灵机器人API调用
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年12月6日-下午2:13:08</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class AnswerRobotApiProcess {
	private static final String DEF_CHATSET = "UTF-8";
	private static final int DEF_CONN_TIMEOUT = 30000;
	private static final int DEF_READ_TIMEOUT = 30000;
	private static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	// 配置您申请的KEY
	private static final String APPKEY = Api.juheApiKeyShiMing;

	// 1.问答
	private static String getRequest1(Map<String, Object> param) {
		String result = null;
		String url = "http://op.juhe.cn/robot/index";// 请求接口地址
		Map<String, Object> params = new HashMap<String, Object>();// 请求参数
		params.put("key", APPKEY);// 您申请到的本接口专用的APPKEY
		params.put("info", param.get("info"));// 要发送给机器人的内容，不要超过30个字符
		if (CommUtil.isNotNull(param.get("dtype")))
			params.put("dtype", param.get("dtype"));// 返回的数据的格式，json或xml，默认为json
		if (CommUtil.isNotNull(param.get("loc")))
			params.put("loc", param.get("loc"));// 地点，如北京中关村
		if (CommUtil.isNotNull(param.get("lon")))
			params.put("lon", param.get("lon"));// 经度，东经116.234632（小数点后保留6位），需要写为116234632
		if (CommUtil.isNotNull(param.get("lat")))
			params.put("lat", param.get("lat"));// 纬度，北纬40.234632（小数点后保留6位），需要写为40234632
		if (CommUtil.isNotNull(param.get("userid")))
			params.put("userid", param.get("userid"));// 1~32位，此userid针对您自己的每一个用户，用于上下文的关联
		JsonParser parse = new JsonParser(); // 创建json解析器
		try {
			result = net(url, params, "GET");
			JsonObject object = (JsonObject) parse.parse(result);
			if (object.get("error_code").toString().equals("0")) {
				System.out.println(object.get("result"));
			} else {
				System.out.println(object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 2.数据类型
	private static String getRequest2() {
		String result = null;
		String url = "http://op.juhe.cn/robot/code";// 请求接口地址
		Map<String, Object> params = new HashMap<String, Object>();// 请求参数
		params.put("dtype", "");// 返回的数据格式，json或xml，默认json
		params.put("key", APPKEY);// 您申请本接口的APPKEY，请在应用详细页查询
		JsonParser parse = new JsonParser(); // 创建json解析器
		try {
			result = net(url, params, "GET");
			JsonObject object = (JsonObject) parse.parse(result);
			if (object.get("error_code").toString().equals("0")) {
				System.out.println(object.get("result"));
			} else {
				System.out.println(object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年12月6日-下午2:21:38</li>
	 *         <li>功能说明：图灵机器人总入口</li>
	 *         </p>
	 */
	public static AnswerRobot getAnswer(Map<String, Object> params) {

		AnswerRobot answerRobot = new AnswerRobot();

		JsonParser parse = new JsonParser(); // 创建json解析器

		JsonObject object = (JsonObject) parse.parse(getRequest1(params));

		if (object.get("error_code").toString().equals("0")) {

			JsonObject result = (JsonObject) parse.parse(object.get("result").toString());

			answerRobot.setCode(result.get("code").toString());
			answerRobot.setText(result.get("text").toString());

		} else {
			answerRobot.setCode("返回错误");
		}

		return answerRobot;
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	private static String net(String strUrl, Map<String, Object> params, String method) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(params);
			}
			URL url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			if (method == null || method.equals("GET")) {
				conn.setRequestMethod("GET");
			} else {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals("POST")) {
				try {
					DataOutputStream out = new DataOutputStream(conn.getOutputStream());
					out.writeBytes(urlencode(params));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	// 将map型转为请求参数型
	private static String urlencode(Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		for (@SuppressWarnings("rawtypes") Map.Entry i : data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// getRequest1();
		getRequest2();
	}
}
