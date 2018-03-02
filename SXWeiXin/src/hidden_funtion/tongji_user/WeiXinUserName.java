package hidden_funtion.tongji_user;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.urils.AccessToken;
import com.urils.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * @author LinShiqin:
 * @date 创建时间：2016年4月21日 下午4:29:29
 * @return
 */
public class WeiXinUserName {

	/* 获取用户基本信息（包括UnionID机制） */
	private static String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/*获取微信用户信息*/
	public static String getName(String openid) {

		
		// 第三方用户唯一凭证
		String appId = "wxbd1c95f88d73a137";
		// 第三方用户唯一凭证密钥
		String appSecret = "017225a0df3d9268c8051c2292a28966";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		String realName = "";

		String realUrl = url.replace("OPENID", openid);

		realUrl = realUrl.replace("ACCESS_TOKEN", at.getToken());

		try {

			URL url = new URL(realUrl);

			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
			JSONObject jsonObject = null;
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			String tmp = buffer.toString();
			jsonObject = JSONObject.fromObject(buffer.toString());
            System.out.println(tmp);
            //获取微信ID
            realName = jsonObject.getString("nickname");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return realName;
	}
	
	public static void main(String[] args) {
		System.out.println(getName("oC9IOt3HxxJzdDeWFdaMzz4YKWAc"));
	}
}
