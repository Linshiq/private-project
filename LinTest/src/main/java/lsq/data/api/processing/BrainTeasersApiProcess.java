package lsq.data.api.processing;

import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import api.bean.brainteasers.BrainTeasers;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年11月18日 上午10:43:22 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       脑筋急转弯API			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年11月18日-上午10:43:22</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class BrainTeasersApiProcess {

		private static String httpUrl = "http://apis.baidu.com/txapi/naowan/naowan";
		
		/**
		 * @Author linshiqin
		 *         <p>
		 *         <li>2016年11月18日-上午10:43:22</li>
		 *         <li>功能说明：调用API获取脑筋急转弯(单条)</li>
		 *         </p>
		 */
//		private static String request(String httpUrl, String httpArg) {
//		    BufferedReader reader = null;
//		    String result = null;
//		    StringBuffer sbf = new StringBuffer();
//		    httpUrl = httpUrl + "?" + httpArg;
//
//		    try {
//		        URL url = new URL(httpUrl);
//		        HttpURLConnection connection = (HttpURLConnection) url
//		                .openConnection();
//		        connection.setRequestMethod("GET");
//		        // 填入apikey到HTTP header
//		        connection.setRequestProperty("apikey",  Api.baiduApiKey);
//		        connection.connect();
//		        InputStream is = connection.getInputStream();
//		        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//		        String strRead = null;
//		        while ((strRead = reader.readLine()) != null) {
//		            sbf.append(strRead);
//		            sbf.append("\r\n");
//		        }
//		        reader.close();
//		        result = sbf.toString();
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		    }
//		    return result;
//		}
		
		/**
		 * @Author linshiqin
		 *         <p>
		 *         <li>2016年11月18日-上午10:49:21</li>
		 *         <li>功能说明：获取脑筋急转弯信息(单条)</li>
		 *         </p>
		 */
		public static BrainTeasers getBrainTeasersOne() {
			
			BrainTeasers brainTeasers = new BrainTeasers();
			
			//System.out.println(BrainTeasersProcess.request(httpUrl, ""));
			
			//创建一个Gson对象
			Gson gson = new Gson();
			JsonParser parse =new JsonParser();  //创建json解析器

	        try {
	        	 JsonObject jsonTop=(JsonObject) parse.parse(BaiDuApiProcess.request(httpUrl, ""));  //创建jsonObject对象

	        	 JsonArray jsonArray = parse.parse(jsonTop.get("newslist").toString()).getAsJsonArray();
	    
	        	 //遍历JsonArray对象     	
	        	 Iterator<?> it = jsonArray.iterator();
	        	 while(it.hasNext()){
	        		 JsonElement e = (JsonElement)it.next();
	        		 //JsonElement转换为JavaBean对象
	        		 brainTeasers = gson.fromJson(e, BrainTeasers.class);
	        		 //System.out.println(hotWechat.toString());
	        	 }
	             
	        } catch (JsonIOException e) {
	            e.printStackTrace();
	        } catch (JsonSyntaxException e) {
	            e.printStackTrace();
	        } catch(Exception e){

				brainTeasers.setId("木有信息");

				
				System.out.println(e);
			}
			
			return brainTeasers;

		}
		
		public static void main(String[] args) {
			System.out.println(BrainTeasersApiProcess.getBrainTeasersOne().toString());
		}
}
