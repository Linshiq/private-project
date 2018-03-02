package menu_center.bjb_baoxiu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

import com.sina.sae.util.SaeUserInfo;

import connection_jdbc.ConnectionJDBC;
import menu_center.bjb_baoxiu.base.BJB;


//笔记本维修登记
public class BJBBaoXiuWrite {

	public static String baoxiuInput(BJB bjb) {

		String flag = ""; // 标记是否成功登记
        
		try {

//			String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//			// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//			String Username = SaeUserInfo.getAccessKey();
//			String Password = SaeUserInfo.getSecretKey();
//			String Driver = "com.mysql.jdbc.Driver";
//
//			Class.forName(Driver).newInstance();
//			Connection con = DriverManager.getConnection(URL, Username, Password);
			
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);

			PreparedStatement psql;

			String uuid = UUID.randomUUID().toString();
			
			// 预处理添加数据，其中有两个参数--“？”
			psql = (PreparedStatement) con.prepareStatement("insert into bjbbaoxiu values(?,?,?,?,?,?,?,?)");

			psql.setString(1,uuid);
			
			if (bjb.getName() == null || bjb.getName().length() <= 0) {
				return "名字为空";
			} else
				psql.setString(2, bjb.getName());

			if (bjb.getId() == null || bjb.getId().length() <= 0) {
				return "学号为空";
			} else
				psql.setString(3, bjb.getId());

			psql.setString(4, bjb.getType());

			if (bjb.getMobile() == null || bjb.getMobile().length() <= 0) {
				return "联系方式为空";
			} else
				psql.setString(5, bjb.getMobile());

			if (bjb.getBeizhu() == null || bjb.getBeizhu().length() <= 0) {
				psql.setString(6, "无备注");
			} else
				psql.setString(6, bjb.getBeizhu());

			psql.setString(7, bjb.getDate());
			psql.setString(8, "0");

			psql.executeUpdate(); // 执行更新
			psql.close();
			con.close();
			flag = "提交成功";

		} catch (Exception e) {
			flag = "提交异常";
		}

		return flag;

	}
	
	public static void delete(String custno) {
		
		try {

//			String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//			// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//			String Username = SaeUserInfo.getAccessKey();
//			String Password = SaeUserInfo.getSecretKey();
//			String Driver = "com.mysql.jdbc.Driver";
//
//			Class.forName(Driver).newInstance();
//			Connection con = DriverManager.getConnection(URL, Username, Password);
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);

			PreparedStatement pstmt;
			
			pstmt = con.prepareStatement("DELETE FROM bjbbaoxiu WHERE custno = '"+custno+"'"); // 执行更新
			pstmt.executeUpdate(); // 执行更新
			pstmt.close();
			con.close();

		} catch (Exception e) {
			
		}	
	}
	
	public static void  update(String custno) {
		
		try {

//			String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//			// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//			String Username = SaeUserInfo.getAccessKey();
//			String Password = SaeUserInfo.getSecretKey();
//			String Driver = "com.mysql.jdbc.Driver";
//
//			Class.forName(Driver).newInstance();
//			Connection con = DriverManager.getConnection(URL, Username, Password);
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
            PreparedStatement pstmt;
			pstmt = con.prepareStatement("UPDATE bjbbaoxiu SET status='1' WHERE custno = '"+custno+"'");
			pstmt.executeUpdate(); // 执行更新
			pstmt.close();
			con.close();

		} catch (Exception e) {
			
		}	
	}
}
