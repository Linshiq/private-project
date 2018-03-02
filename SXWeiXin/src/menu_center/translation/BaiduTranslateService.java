package menu_center.translation;
import java.io.BufferedReader;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.UnsupportedEncodingException;  
import java.net.HttpURLConnection;  
import java.net.URL;
import java.util.Random;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;  
   
public class BaiduTranslateService {  
    /** 
     * 发起http请求获取返回结果 
     *  
     * @param requestUrl 请求地址 
     * @return 
     */  
    public static String httpRequest(String requestUrl) {  
        StringBuffer buffer = new StringBuffer();  
        try {  
            URL url = new URL(requestUrl);  
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
  
            httpUrlConn.setDoOutput(false);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.connect();  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
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
  
        } catch (Exception e) {  
        }  
        return buffer.toString();  
    }  
  
    /** 
     * utf编码 
     *  
     * @param source 
     * @return 
     */  
    public static String urlEncodeUTF8(String source) {  
        String result = source;  
        try {  
            result = java.net.URLEncoder.encode(source, "utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    /** 
     * 翻译（中->英 英->中 日->中 ） 
     *  
     * @param source 
     * @return 
     */  
    public static String translate(String source) {  
        String dst = "";  
        String appid = "SXSWinXin";
        String appkey = "2001913265";
        Random salt = new Random();
        int salt_random = salt.nextInt(99999999);
        // 组装查询地址  

      //  String requestUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate?q="+"{keyWord}"+"&appid="+appid+"&salt="+salt_random+"&from=auto&to=auto";
        String requestUrl = " http://fanyi.youdao.com/openapi.do?keyfrom="+appid+"&key="+appkey+"&type=data&doctype=json&version=1.1&q={keyWord}";
       // 对参数q的值进行urlEncode utf-8编码  
        String word = urlEncodeUTF8(source);
        requestUrl = requestUrl.replace("{keyWord}", word); 
        String sign = MD5.encryption(appid+source+salt_random+appkey);
        sign = sign.toLowerCase();
        requestUrl = requestUrl+"&sign="+sign;
        // 查询并解析结果  
        try {  
            // 查询并获取返回结果  
            String json = httpRequest(requestUrl);
            System.out.println(json);
//            // 通过Gson工具将json转换成TranslateResult对象  
//            TranslateResult translateResult = new Gson().fromJson(json, TranslateResult.class);  
//            // 取出translateResult中的译文  
//             dst = translateResult.getTrans_result().get(0).getDst();
            JSONObject jsonObject = JSONObject.fromObject(json);
            JSONArray status = jsonObject.getJSONArray("translation");
            dst=  status.get(0).toString();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        if (dst.equals(""))  
            dst = "翻译系统异常，请稍候尝试！";  
        return dst;  
    }  
  
    public static void main(String[] args) {  
        // 翻译结果：The network really powerful
    	String string = translate("网络真强大");
        System.out.println(string);  
    }  
}  