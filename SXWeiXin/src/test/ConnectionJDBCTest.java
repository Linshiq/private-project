package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import login.base.User;
import menu_center.bjb_baoxiu.BJBBaoXiuRead;



public class ConnectionJDBCTest {

	private static HttpServletRequest request;
	
		
	public static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf8";
	    String username = "root";
	    String password = "qqqq";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static int update(String id) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update bjbbaoxiu set status='1' where custno='" + id + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static int delete(String id) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from bjbbaoxiu where custno='" + id + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	public static List<BJB> select1(String select,String condition){
		
            List<BJB> bjbList = new ArrayList<BJB>();


		String sql ="";
		try {
			Connection conn = getConn();

			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			if (select == null || select.length() <= 0) {
				if(condition == null || condition.length() <= 0){
					sql = "select * from bjbbaoxiu";
				}
			}else
				sql = select(select,condition);

			// 3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				BJB bjb = new BJB();

				bjb.setBeizhu(rs.getString("beizhu"));
				bjb.setCustnon(rs.getString("custno"));
				bjb.setDate(rs.getString("date"));
				bjb.setId(rs.getString("id"));
				bjb.setMobile(rs.getString("mobile"));
				bjb.setName(rs.getString("name"));
				bjb.setStatus(rs.getString("status"));
				bjb.setType(rs.getString("type"));

				bjbList.add(bjb);

			}
			rs.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			BJB useFZ = new BJB();

			useFZ.setCustnon("查");
			useFZ.setName("询");
			useFZ.setId("失");
			useFZ.setType("败");
			bjbList.add(useFZ);
		}
		return bjbList;
	}
	
	public static List<User> query(){
		
        List<User> bjbList = new ArrayList<User>();


	String sql ="";
	try {
		Connection conn = getConn();

		// 2.创建statement类对象，用来执行SQL语句！！
		Statement statement = conn.createStatement();
		sql = "select * from login";
		// 3.ResultSet类，用来存放获取的结果集！！
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			User bjb = new User();

			bjb.setId(rs.getString("id"));
			bjb.setUserName(rs.getString("userName"));
			bjb.setUserPsd(rs.getString("userPsd"));

			bjbList.add(bjb);

		}
		rs.close();
		conn.close();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		User useFZ = new User();
        
		useFZ.setId("查询");
		useFZ.setUserName("失败");
		
		bjbList.add(useFZ);
	}
	return bjbList;
}
	
    private static String select(String sql,String condition){
		
		if ("".equals(sql)) {
			sql = "select * from bjbbaoxiu";
		}else if("唯一ID".equals(sql)){
			sql = "select * from bjbbaoxiu where custno like '%"+condition+"%'";
		}else if("名字".equals(sql)){
			sql = "select * from bjbbaoxiu where name like '%"+condition+"%'";
		}else if("学号".equals(sql)){
			sql = "select * from bjbbaoxiu where id like '%"+condition+"%'";
		}else if("维修类型".equals(sql)){
			sql = "select * from bjbbaoxiu where type like '%"+condition+"%'";
		}else if("联系方式".equals(sql)){
			sql = "select * from bjbbaoxiu where mobile like '%"+condition+"%'";
		}else if("备注".equals(sql)){
			sql = "select * from bjbbaoxiu where beizhu like '%"+condition+"%'";
		}else if("期望维修时间".equals(sql)){
			sql = "select * from bjbbaoxiu where date like '%"+condition+"%'";
		}else if("维修状态".equals(sql)){
			sql = "select * from bjbbaoxiu where status like '%"+condition+"%'";
		}
		
		return sql;
	}
	public static void main(String[] args) {
		Logger logger =  Logger.getLogger(BJBBaoXiuRead.class);
		logger.debug("BJBBaoXiuRead>>>>>>>>>>>>>>>>>>kais");
		System.out.println("1");
		System.out.println(ConnectionJDBCTest.update("1"));
		logger.debug("BJBBaoXiuRead>>>>>>>>>>>>>>>>>>end");
	}
}
