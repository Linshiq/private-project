package connection_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.sina.sae.util.SaeUserInfo;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月19日 上午9:31:58 
* @return  连接数据库工具类
*/

public class ConnectionJDBC {

//	public static final String URL_Write = "jdbc:mysql://rxqomumquirb.rds.sae.sina.com.cn:10706/app_shixiongsay";
//
//	public static final String URL_Read = "jdbc:mysql://xmfyrkgvnemh.rds.sae.sina.com.cn:10706/app_shixiongsay";
//	
//	public static final String Username = "root";
//	
//	public static final String Password = "panqin_1";
	
	public static final String Driver = "com.mysql.jdbc.Driver";
	
	public static final String URL_Write = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));

	public static final String URL_Read = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST_S"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
	
	public static final String Username = System.getenv("ACCESSKEY");
	
	public static final String Password = System.getenv("SECRETKEY");
	
	public static final Connection connection(){
		Connection con = null;
		try{
		
		Class.forName(ConnectionJDBC.Driver).newInstance();
		con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
		
		}catch(Exception e){
			System.out.println("连接数据库失败");
		}
		
		return con;

	}
}

