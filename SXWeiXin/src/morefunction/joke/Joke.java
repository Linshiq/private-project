package morefunction.joke;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Joke {

	/**
	 * 发起http get请求获取网页源代码
	 * 
	 * @param requestUrl
	 * @return
	 */

	private static String jokeApiKey = "a7dd84487bcb058f179c6ce2c82ae1b7";

	public static List<JokeList> searchJoke() {

		String httpUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
		String httpArg = "page=1";
		httpUrl = httpUrl + "?" + httpArg;

		InputStream inputStream = httpRequest(httpUrl);

		List<JokeList> result = parseJoke(inputStream);

		return result;

	}

	private static List<JokeList> parseJoke(InputStream inputStream) {

		List<JokeList> jokeLists = new ArrayList<JokeList>();

		try {
			String inputString = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;

			while ((line = br.readLine()) != null) {
				inputString += line;
			}
			br.close();

			System.out.println(inputString);

			JSONObject jokeTop = JSONObject.fromObject(inputString);

			if (!jokeTop.getString("showapi_res_code").equals("0")
					&& !jokeTop.getString("showapi_res_error").equals("")) {
				JokeList j = new JokeList();
				j.setCt("");
				jokeLists.add(j);
				return jokeLists;
			} else {
				JSONObject jokeTwo = jokeTop.getJSONObject("showapi_res_body");
				JSONArray jokeThree = JSONArray.fromObject(jokeTwo.getString("contentlist"));

				// 将得到的数据转换为List
				@SuppressWarnings("rawtypes")
				List list = (List) JSONArray.toList(jokeThree);

				for (int i = 0; i < list.size(); i++) {
					JSONObject jokeFour = JSONObject.fromObject(list.get(i));
					JokeList j = new JokeList();
					j.setCt(jokeFour.getString("ct"));
					j.setText(jokeFour.getString("text"));
					j.setTitle(jokeFour.getString("title"));
					j.setTypt(jokeFour.getString("type"));
					jokeLists.add(j);
					System.out.println(jokeFour + "\n" + j.toString());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jokeLists;
	}

	private static InputStream httpRequest(String requestUrl) {
		InputStream inputStream = null;
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.setRequestProperty("apikey", jokeApiKey);
			httpUrlConn.connect();
			// 获得返回的输入流
			inputStream = httpUrlConn.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	public static void main(String[] args) {
		System.err.println(Joke.searchJoke());
	}
}
