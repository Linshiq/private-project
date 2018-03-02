package morefunction.goodorbad;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class GetAllTxtInfo {

	public static Map<String, List<String>> getLeader(HttpServletRequest request) {
		
		String fileName = "/Leader.txt";
		
        Map<String, List<String>> list = new HashMap<String, List<String>>();
		
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL("http://" + request.getServerName() + request.getContextPath()+fileName);  
	        HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  

	        httpUrlConn.setDoOutput(false);  
	        httpUrlConn.setDoInput(true);  
	        httpUrlConn.setUseCaches(false);  

	        httpUrlConn.setRequestMethod("GET");  
	        httpUrlConn.connect();
			
	        InputStream inputStream = httpUrlConn.getInputStream();  
	        InputStreamReader isr = new InputStreamReader(inputStream,"gbk"); 
	        bufferedReader = new BufferedReader(isr);
			String tempStr = "";
			String leaderName="";
			StringBuilder sb = new StringBuilder();
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = null;
			while((tempStr = bufferedReader.readLine()) != null){
				isNum = pattern.matcher(tempStr.charAt(0)+"");
				List<String> listStr = new ArrayList<String>();
				if(isNum.matches()){
					list.put(leaderName, listStr);
					listStr.clear();									
					leaderName = tempStr.replaceAll("^"+tempStr.charAt(0)+"、", "");	;
				}else if (tempStr.startsWith("**")) {
				  	listStr.add(sb.toString());
				  	sb.delete(0, sb.length());
				  	sb.append(tempStr.replace("^**", ""));
				}else{
					sb.append(tempStr);
				}
			}
		}catch (Exception e) {
				System.out.println(e);
			}
			
		return list;						
	}
	
	public static List<String>  getTxtAll(HttpServletRequest request) {
		
		String fileName = "/StudyLevel.txt";
		
		List<String> list = new ArrayList<String>();
		
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL("http://" + request.getServerName() + request.getContextPath()+fileName);  
	        HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  

	        httpUrlConn.setDoOutput(false);  
	        httpUrlConn.setDoInput(true);  
	        httpUrlConn.setUseCaches(false);  

	        httpUrlConn.setRequestMethod("GET");  
	        httpUrlConn.connect();
			
	        InputStream inputStream = httpUrlConn.getInputStream();  
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
