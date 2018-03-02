package menu_right.weather_forecast;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import menu_right.weather_forecast.base.WeatherBasic;
import menu_right.weather_forecast.base.WeatherInfo;
import menu_right.weather_forecast.base.WeatherSuggestion;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 百度API中国和世界天气预报
 * 
 */
public class WeatherForecastService {
	private static String weatherApiKey = "a7dd84487bcb058f179c6ce2c82ae1b7";

	public static String searchWeatherForecast(String cityname) {
		// 百度天气搜索地址
		String requestUrl = "http://apis.baidu.com/heweather/weather/free?city={cityname}";
		// 对音乐名称、作者进URL编码
		requestUrl = requestUrl.replace("{cityname}", urlEncodeUTF8(cityname));
		// 处理名称中间的空格
		requestUrl = requestUrl.replaceAll("\\+", "%20");

		// 查询并获取返回结果
		InputStream inputStream = httpRequest(requestUrl);
		// 从返回结果中解析出 weatherForecas
		String weatherForecastList = parseWeatherForecast(inputStream);

		return weatherForecastList;

	}

	/**
	 * UTF-8编码
	 * 
	 * @param source
	 * @return
	 */
	private static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 发送http请求取得返回的输入流
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @return InputStream
	 */
	private static InputStream httpRequest(String requestUrl) {
		InputStream inputStream = null;
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.setRequestProperty("apikey", weatherApiKey);
			httpUrlConn.connect();
			// 获得返回的输入流
			inputStream = httpUrlConn.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	/**
	 * 解析天气参数
	 * 
	 */
	private static String parseWeatherForecast(InputStream inputStream) {
//		List<WeatherForecast> weatherForecastList = new ArrayList<WeatherForecast>();
		String WeatherInformation = "";
		try {
			// 使用dom4j解析xml字符串
			// Document document = reader.read(inputStream);
			String inputString = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				inputString += line;
			}
			br.close();
			System.out.println(inputString);
	//		WeatherForecast weatherForecast = new WeatherForecast();
			JSONObject dataJson = JSONObject.fromObject(inputString);
			JSONArray status = dataJson.getJSONArray("HeWeather data service 3.0");
			JSONObject tianqi = JSONObject.fromObject(status.getString(0));
			if (!tianqi.getString("status").equals("ok")) {
				return "";
			} else {
				// weatherForecast.setAqi(tianqi.getString("aqi"));
				// weatherForecast.setBasic(tianqi.getString("basic"));
				// weatherForecast.setNow(tianqi.getString("now"));
				// weatherForecast.setDaily_forecast(tianqi.getString("daily_forecast"));
				// weatherForecast.setHourly_forecast(tianqi.getString("hourly_forecast"));
				// weatherForecast.setSuggestion(tianqi.getString("suggestion"));
				// weatherForecastList.add(weatherForecast);

				WeatherInfo weatherInfo = new WeatherInfo();

				WeatherInformation = weatherBasicLogin(tianqi.getString("basic")).toString() + "\n";

				JSONObject w1 = JSONObject.fromObject(tianqi.getString("now"));
				weatherInfo.setTmp(w1.getString("tmp"));
				weatherInfo.setVis(w1.getString("vis"));
				JSONObject w2 = w1.getJSONObject("cond");
				weatherInfo.setTxt(w2.getString("txt"));
				JSONObject w3 = w1.getJSONObject("wind");
				weatherInfo.setDir(w3.getString("dir"));
				weatherInfo.setSC(w3.getString("sc"));

				if (status.getString(0).contains("aqi")) {//判断是否接收到aqi
					JSONObject a1 = JSONObject.fromObject(tianqi.getString("aqi"));
					JSONObject a2 = a1.getJSONObject("city");
					weatherInfo.setAqi(a2.getString("aqi"));
					weatherInfo.setQlty(a2.getString("qlty"));
				}

				JSONArray d2 = JSONArray.fromObject(tianqi.getString("daily_forecast"));
				JSONObject d3 = JSONObject.fromObject(d2.getString(0));
				JSONObject d4 = d3.getJSONObject("tmp");
				weatherInfo.setTmpMax(d4.getString("max"));
				weatherInfo.setTmpMin(d4.getString("min"));
				
				String suggestion = "";
				if (status.getString(0).contains("suggestion")) {//判断是否接收到suggestion
                    					
					JSONObject s1 = JSONObject.fromObject(tianqi.getString("suggestion"));

					JSONObject comfJson = s1.getJSONObject("comf");
					WeatherSuggestion weatherSuggestionComf = new WeatherSuggestion();
					weatherSuggestionComf.setBrf(comfJson.getString("brf"));
					weatherSuggestionComf.setTxt(comfJson.getString("txt"));
					weatherInfo.setComf(weatherSuggestionComf);
					
					JSONObject cwJson = s1.getJSONObject("cw");
					WeatherSuggestion weatherSuggestionCw = new WeatherSuggestion();
					weatherSuggestionCw.setBrf(cwJson.getString("brf"));
					weatherSuggestionCw.setTxt(cwJson.getString("txt"));
					weatherInfo.setCw(weatherSuggestionCw);
					
					JSONObject drsgJson = s1.getJSONObject("drsg");
					WeatherSuggestion weatherSuggestionDrsg = new WeatherSuggestion();
					weatherSuggestionDrsg.setBrf(drsgJson.getString("brf"));
					weatherSuggestionDrsg.setTxt(drsgJson.getString("txt"));
					weatherInfo.setDrsg(weatherSuggestionDrsg);
					
					JSONObject fluJson = s1.getJSONObject("flu");
					WeatherSuggestion weatherSuggestionFlu = new WeatherSuggestion();
					weatherSuggestionFlu.setBrf(fluJson.getString("brf"));
					weatherSuggestionFlu.setTxt(fluJson.getString("txt"));
					weatherInfo.setFlu(weatherSuggestionFlu);
					
					JSONObject sportJson = s1.getJSONObject("sport");
					WeatherSuggestion weatherSuggestionSport = new WeatherSuggestion();
					weatherSuggestionSport.setBrf(sportJson.getString("brf"));
					weatherSuggestionSport.setTxt(sportJson.getString("txt"));
					weatherInfo.setSport(weatherSuggestionSport);
					
					JSONObject travJson = s1.getJSONObject("trav");
					WeatherSuggestion weatherSuggestionTrav = new WeatherSuggestion();
					weatherSuggestionTrav.setBrf(travJson.getString("brf"));
					weatherSuggestionTrav.setTxt(travJson.getString("txt"));
					weatherInfo.setTrav(weatherSuggestionTrav);
					
					JSONObject uvJson = s1.getJSONObject("uv");
					WeatherSuggestion weatherSuggestionUv = new WeatherSuggestion();
					weatherSuggestionUv.setBrf(uvJson.getString("brf"));
					weatherSuggestionUv.setTxt(uvJson.getString("txt"));
					weatherInfo.setUv(weatherSuggestionUv);
					
					System.out.println("->"+weatherInfo.getUv().getBrf());
					suggestion = weatherSuggestion(weatherInfo);
				}
				
				WeatherInformation = weatherInfo.getTxt() + "," + WeatherInformation + weatherInfo.toString() + "\n\n" +suggestion;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WeatherInformation;
	}

	private static String weatherSuggestion(WeatherInfo weatherInfo){
		
		StringBuffer sb =new StringBuffer();
		sb.append("舒适度指数:"+weatherInfo.getComf().getBrf()+"\n详细信息："+weatherInfo.getComf().getTxt()).append("\n\n");
		sb.append("穿衣指数:"+weatherInfo.getDrsg().getBrf()+"\n详细信息："+weatherInfo.getDrsg().getTxt()).append("\n\n");
		sb.append("紫外线指数:"+weatherInfo.getUv().getBrf()+"\n详细信息："+weatherInfo.getUv().getTxt()).append("\n");
		return sb.toString();
	}
	
	private static WeatherBasic weatherBasicLogin(String basic) {

		JSONObject weatherBasicJson = JSONObject.fromObject(basic);
		WeatherBasic weatherBasic = new WeatherBasic();

		weatherBasic.setCity(weatherBasicJson.getString("city"));
		weatherBasic.setCnty(weatherBasicJson.getString("cnty"));
		weatherBasic.setId(weatherBasicJson.getString("id"));
		weatherBasic.setLat(weatherBasicJson.getString("lat"));
		weatherBasic.setLon(weatherBasicJson.getString("lon"));

		JSONObject next = weatherBasicJson.getJSONObject("update");
		weatherBasic.setLoc(next.getString("loc"));
		weatherBasic.setUtc(next.getString("utc"));

		System.out.println(weatherBasicJson.toString() + "\n" + weatherBasic.toString());

		return weatherBasic;
	}

	// 测试方法
	public static void main(String[] args) {
		String music = searchWeatherForecast("beijing");
		System.out.println(music + "\n");
//		String[] str = {"1","2"};
//		for(String s:str){
//			System.out.println(s);
	}
		
}

