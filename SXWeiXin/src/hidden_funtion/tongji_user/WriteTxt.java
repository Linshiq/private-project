package hidden_funtion.tongji_user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sina.sae.util.SaeUserInfo;

import connection_jdbc.ConnectionJDBC;


public class WriteTxt {

	public static void write(String toUserName,String funtionName) throws IOException{
        try { 
	            
//        	String URL="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//    		// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//    		String Username=SaeUserInfo.getAccessKey();
//    		String Password=SaeUserInfo.getSecretKey();
//    		String Driver="com.mysql.jdbc.Driver";
//    		
//    		Class.forName(Driver).newInstance();
//			Connection con = DriverManager.getConnection(URL,Username,Password);
        	Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
			
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            PreparedStatement psql;
            
            //预处理添加数据，其中有两个参数--“？”
            psql = (PreparedStatement) con.prepareStatement("insert into use_frequency values(?,?,?,?)");
            
            if (toUserName == null || toUserName.length() <= 0) {
            	psql.setString(1, "没有锁定用户ID");              //设置参数1，创建id为5的数据
			}
            else
            	psql.setString(1, toUserName);  
            
            psql.setString(2, funtionName);      
            psql.setString(3, "1");      
            psql.setString(4, df.format(time.getTime()));  
            psql.executeUpdate();         //执行更新
            psql.close();
            con.close();


        } catch (Exception e1) {

        } finally {

        }
	}
}
