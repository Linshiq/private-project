package menu_right.qiandao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.sina.sae.util.SaeUserInfo;

import connection_jdbc.ConnectionJDBC;
import menu_right.qiandao.base.QianDao;



public class QianDaoWrite {

	public static boolean qiandaoInput(QianDao qianDao) {
		
		boolean flag = false;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		try {
			
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);

			PreparedStatement psql;
			
			String uuid = UUID.randomUUID().toString();
			
			// 预处理添加数据，其中有两个参数--“？”
			psql = (PreparedStatement) con.prepareStatement("insert into qiandao values(?,?,?,?,?,?,?)");

			psql.setString(1, uuid);
			
			if (qianDao.getName() == null || qianDao.getName().length() <= 0) {
				return false;
			} else
				psql.setString(2, qianDao.getName());

			if (qianDao.getId() == null || qianDao.getId().length() <= 0) {
				return false;
			} else
				psql.setString(3, qianDao.getId());

			if (qianDao.getMobile() == null || qianDao.getMobile().length() <= 0) {
				return false;
			} else
				psql.setString(4, qianDao.getMobile());
			
			if (qianDao.getHuodong() == null || qianDao.getHuodong().length() <= 0) {
				return false;
			} else
				psql.setString(5, qianDao.getHuodong());

			if (qianDao.getBeizhu() == null || qianDao.getBeizhu().length() <= 0) {
				psql.setString(6, "无备注");
			} else
				psql.setString(6, qianDao.getBeizhu());

			psql.setString(7, df.format(time.getTime()));

			psql.executeUpdate(); // 执行更新
			psql.close();
			con.close();
			flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public static void  delete(String custno) {
//		String driver = "com.mysql.jdbc.Driver";
//	    String url = "jdbc:mysql://localhost:3306/test";
//	    String username = "root";
//	    String password = "qqqq";
//	    Connection con = null;

		try {
//			Class.forName(driver); //classLoader,加载对应驱动
//	        con = (Connection) DriverManager.getConnection(url, username, password);
	        Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
	        PreparedStatement pstmt;
			
			pstmt = con.prepareStatement("DELETE FROM qiandao WHERE custno = '"+custno+"'"); // 执行更新
			pstmt.executeUpdate(); // 执行更新
			pstmt.close();
			con.close();
		}catch(Exception e){
			
		}
		
	}
}
