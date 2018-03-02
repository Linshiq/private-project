package menu_right.qiandao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection_jdbc.ConnectionJDBC;
import menu_center.bjb_baoxiu.base.BJB;
import menu_right.qiandao.base.QianDao;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月20日 下午3:53:01 
* @return  
*/
public class QianDaoRead {

	public static List<QianDao> qureyDate(String startTimes,String endTimes) {
		List<QianDao> qianDaoList = new ArrayList<QianDao>();
		
//		String driver = "com.mysql.jdbc.Driver";
//	    String url = "jdbc:mysql://localhost:3306/test";
//	    String username = "root";
//	    String password = "qqqq";
//	    Connection con = null;
	    try {
//	    	Class.forName(driver); //classLoader,加载对应驱动
//	        con = (Connection) DriverManager.getConnection(url, username, password);
	        Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Read, ConnectionJDBC.Username, ConnectionJDBC.Password);
	        String sql="";
			Statement statement = con.createStatement();
			
			
			sql = "select * from qiandao where date > '"+startTimes+"' and date < '"+endTimes+"'";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				QianDao qiandao = new QianDao();
				qiandao.setCustno(rs.getString("custno"));
				qiandao.setBeizhu(rs.getString("beizhu"));
				qiandao.setDate(rs.getString("date"));
				qiandao.setHuodong(rs.getString("huodong"));
				qiandao.setId(rs.getString("id"));
				qiandao.setMobile(rs.getString("mobile"));
				qiandao.setName(rs.getString("name"));

				qianDaoList.add(qiandao);

			}
			rs.close();
			con.close();
		} catch (Exception e) {
			QianDao qiandao = new QianDao();

			qiandao.setBeizhu("查询失败");
			qiandao.setDate("查询失败");
			qiandao.setHuodong("查询失败");
			qiandao.setId("查询失败");
			qiandao.setMobile("查询失败");
			qiandao.setName("查询失败");

			qianDaoList.add(qiandao);
		}
		
		
		return qianDaoList;
	}
	
	public static List<QianDao> qurey(String search,String condition) {
		
		List<QianDao> qianDaoList = new ArrayList<QianDao>();
		
//		String sql="";
//		String driver = "com.mysql.jdbc.Driver";
//	    String url = "jdbc:mysql://localhost:3306/test";
//	    String username = "root";
//	    String password = "qqqq";
//	    Connection con = null;
		
		try {
//			Class.forName(driver); //classLoader,加载对应驱动
//	        con = (Connection) DriverManager.getConnection(url, username, password);
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Read, ConnectionJDBC.Username, ConnectionJDBC.Password);

			String sql="";
			Statement statement = con.createStatement();
			
			
			sql = getSqlSelect(search, condition);
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				QianDao qiandao = new QianDao();
				qiandao.setCustno(rs.getString("custno"));
				qiandao.setBeizhu(rs.getString("beizhu"));
				qiandao.setDate(rs.getString("date"));
				qiandao.setHuodong(rs.getString("huodong"));
				qiandao.setId(rs.getString("id"));
				qiandao.setMobile(rs.getString("mobile"));
				qiandao.setName(rs.getString("name"));

				qianDaoList.add(qiandao);

			}
			
		} catch (Exception e) {

			QianDao qiandao = new QianDao();

			qiandao.setBeizhu("查询失败");
			qiandao.setDate("查询失败");
			qiandao.setHuodong("查询失败");
			qiandao.setId("查询失败");
			qiandao.setMobile("查询失败");
			qiandao.setName("查询失败");

			qianDaoList.add(qiandao);
		} 
		
		
		return qianDaoList;
	}
	
	
	private static String getSqlSelect(String condition,String select){
		
		String sql = "";
		if("名字".equals(select)){
			 sql="select * from qiandao where name like '%"+condition+"%'";
		}else if("学号".equals(select)){
			 sql="select * from qiandao where id like '%"+condition+"%'";
		}else if("联系方式".equals(select)){
			 sql="select * from qiandao where mobile like '%"+condition+"%'";
		}else if("活动名称".equals(select)){
			 sql="select * from qiandao where huodong like '%"+condition+"%'";
		}else if("备注".equals(select)){
			 sql="select * from qiandao where beizhu like '%"+condition+"%'";
		}else if("签到日期".equals(select)){
			 sql="select * from qiandao where date like '%"+condition+"%'";
		}else
		    sql="select * from qiandao";
		
		return sql;
	}
	
	
}
