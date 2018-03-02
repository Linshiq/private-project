package hidden_funtion.tongji_user;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sina.sae.util.SaeUserInfo;
import com.tool.StringUtil;

import connection_jdbc.ConnectionJDBC;
import hidden_funtion.tongji_user.base.UseFZ;
import test.ConnectionJDBCTest;



public class ReadTxt {

	public static List<UseFZ> readJDBC(){
		
//		String URL="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//		// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//		String Username= SaeUserInfo.getAccessKey();
//		String Password= SaeUserInfo.getSecretKey();
//		String Driver="com.mysql.jdbc.Driver";
		
		List<UseFZ> resultList = new ArrayList<UseFZ>();
		
		try {
			
//			Class.forName(Driver).newInstance();
  		    //Connection con = ConnectionJDBCTest.getConn();
            Class.forName(ConnectionJDBC.Driver).newInstance();
		    Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Read, ConnectionJDBC.Username, ConnectionJDBC.Password);
			
			//2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句use_frequency
            String sql = "select * from use_frequency";
            
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
		
            String useType = null;
            String useNum = null;
            String date = null;
            String useName = null;
            
            String name = null;
            while(rs.next()){
            	useName = rs.getString("useName");
            	useType = rs.getString("useType");
            	useNum = rs.getString("useNum");
            	date = rs.getString("date");
            	
            	//name = WeiXinUserName.getName(useName);
            	
            	UseFZ useFZ =  new UseFZ();
            	
            	if (StringUtil.strIsNotEmpty(name)) {
					useFZ.setUseName(name);
				}else
    			    useFZ.setUseName(useName);         	
            	
            	useFZ.setUseNum(useNum);
            	useFZ.setUseType(useType);
            	useFZ.setDate(date);
            	
            	resultList.add(useFZ);

            }
            rs.close();
            con.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			UseFZ useFZ =  new UseFZ();
        	
        	useFZ.setUseName("查");           	
        	useFZ.setUseNum("询");
        	useFZ.setUseType("失");
        	useFZ.setDate("败");
			resultList.add(useFZ);
		}
		
		
		
		return resultList;
	}
	
	public static String read(HttpServletRequest request){

		
		String fileName = "/userFZ.txt";
		 
		StringBuilder sbBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try{
			URL url = new URL("http://" + request.getServerName() + request.getContextPath() + fileName);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream, "gbk");
			
			bufferedReader = new BufferedReader(isr);
			String tempStr = "";
			// int weeken = 1;
			// int tmp = 1;
			while ((tempStr = bufferedReader.readLine()) != null) {
				sbBuilder.append(tempStr);
				// tmp++;
			}
		}catch(Exception e){
			  System.out.println("读取文件内容出错");
			  sbBuilder.append("读取文件内容出错"+e);
	          e.printStackTrace();
		}
		
		return "开始："+sbBuilder.toString();
	}
	public static void main(String[] args) {
//		try {
//			WriteTxt.write("2123");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("错误信息");
//		}
//		
//		ReadTxt.read();
	}
}
