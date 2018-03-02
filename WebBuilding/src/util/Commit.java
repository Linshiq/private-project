package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Month;

public class Commit {

	public static List<List<Map<String, Float>>> valueDateFill(HttpServletRequest request){
		
		List<List<Map<String,Float>>> list = new ArrayList<>();
		
		Month month = new Month();
		
		List<Map<String,Float>> augList = month.getAug();
		List<Map<String,Float>> sepList = month.getSep();
		
		List<String> listTxt = getAllMonthInfo(request);
		List<Map<String,Float>> monthList = new ArrayList<>();
		for(String str:listTxt){
			
			Map<String,Float> map = new HashMap<>();
			if ("end".equals(str)) {
				list.add(monthList);
				monthList = new ArrayList<>();
				continue;
			}
			int index = str.indexOf(":");
			String bool = str.substring(index+1,str.length());
			if("\t".equals(bool) || bool.equals(null)){
				map.put(str.substring(0,index), null);
			}else
				map.put(str.substring(0,index), Float.parseFloat(str.substring(index+1,str.length())));
			monthList.add(map);
		}
		
		return list;
	}
	
	private static List<String> getAllMonthInfo(HttpServletRequest request){
		String fileName = "/txt/mouth.txt";
		
		List<String> list = new ArrayList<String>();
		
		BufferedReader bufferedReader = null;
		try {
			
	        InputStream inputStream = request.getServletContext().getResourceAsStream(fileName);
	        InputStreamReader isr = new InputStreamReader(inputStream,"gbk"); 
	        bufferedReader = new BufferedReader(isr);
			String tempStr = "";
		    while((tempStr = bufferedReader.readLine()) != null){
		    	list.add(tempStr);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
}
