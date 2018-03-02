package menu_center.huiyi_dengji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import connection_jdbc.ConnectionJDBC;
import menu_center.huiyi_dengji.base.HuiYi;
import test.ConnectionJDBCTest;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月27日 上午10:09:40 
* @return  
*/
public class HuiYiDJRead {

	public static List<HuiYi> query() {

		
		List<HuiYi> huiyiList = new ArrayList<HuiYi>();
		
		try{

			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
			//Connection con = ConnectionJDBCTest.getConn();
			
			Statement statement = con.createStatement();
			
			String sql="";
			
			sql = "select * from huiyidengji";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				HuiYi huiYi = new HuiYi();
				
				huiYi.setAdvice(rs.getString("advice"));
				huiYi.setContent(rs.getString("content"));
				huiYi.setCustno(rs.getString("custno"));
				huiYi.setDate(rs.getString("date"));
				huiYi.setDepartment(rs.getString("department"));
				huiYi.setHeadPeople(rs.getString("headPeople"));
				huiYi.setList(rs.getString("list"));
				huiYi.setPeople(rs.getString("people"));
				huiYi.setPlace(rs.getString("place"));
				huiYi.setRealPeople(rs.getString("realPeople"));
				huiYi.setTitle(rs.getString("title"));
				
				huiyiList.add(huiYi);
			}
			
			rs.close();
			con.close();
		}catch(Exception e){
			HuiYi huiYi = new HuiYi();
			huiYi.setCustno("查");
			huiYi.setDepartment("询");
			huiYi.setPlace("失");
			huiYi.setRealPeople("败");
			huiyiList.add(huiYi);
			
		}
		
		return huiyiList;
	}

    public static List<HuiYi> queryTime(String startTimes,String endTimes) {
		
		List<HuiYi> huiyiList = new ArrayList<HuiYi>();
		
		try{

			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
			//Connection con = ConnectionJDBCTest.getConn();
			
			Statement statement = con.createStatement();
			
			String sql="";
			
			sql = "select * from huiyidengji where date > '"+startTimes+"' and date < '"+endTimes+"'";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				HuiYi huiYi = new HuiYi();
				
				huiYi.setAdvice(rs.getString("advice"));
				huiYi.setContent(rs.getString("content"));
				huiYi.setCustno(rs.getString("custno"));
				huiYi.setDate(rs.getString("date"));
				huiYi.setDepartment(rs.getString("department"));
				huiYi.setHeadPeople(rs.getString("headPeople"));
				huiYi.setList(rs.getString("list"));
				huiYi.setPeople(rs.getString("people"));
				huiYi.setPlace(rs.getString("place"));
				huiYi.setRealPeople(rs.getString("realPeople"));
				huiYi.setTitle(rs.getString("title"));
				
				huiyiList.add(huiYi);
			}
			
			rs.close();
			con.close();
		}catch(Exception e){
			HuiYi huiYi = new HuiYi();
			huiYi.setCustno("查");
			huiYi.setDepartment("询");
			huiYi.setPlace("失");
			huiYi.setRealPeople("败");
			huiyiList.add(huiYi);
			
		}
		
		return huiyiList;
	}

    public static List<HuiYi> querySS(String search,String select) {
		
		List<HuiYi> huiyiList = new ArrayList<HuiYi>();
		
		try{

			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
			//Connection con = ConnectionJDBCTest.getConn();
			
			Statement statement = con.createStatement();
			
			String sql="";
			sql = sql(search,select);
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				HuiYi huiYi = new HuiYi();
				
				huiYi.setAdvice(rs.getString("advice"));
				huiYi.setContent(rs.getString("content"));
				huiYi.setCustno(rs.getString("custno"));
				huiYi.setDate(rs.getString("date"));
				huiYi.setDepartment(rs.getString("department"));
				huiYi.setHeadPeople(rs.getString("headPeople"));
				huiYi.setList(rs.getString("list"));
				huiYi.setPeople(rs.getString("people"));
				huiYi.setPlace(rs.getString("place"));
				huiYi.setRealPeople(rs.getString("realPeople"));
				huiYi.setTitle(rs.getString("title"));
				
				huiyiList.add(huiYi);
			}
			
			rs.close();
			con.close();
		}catch(Exception e){
			HuiYi huiYi = new HuiYi();
			huiYi.setCustno("查");
			huiYi.setDepartment("询");
			huiYi.setPlace("失");
			huiYi.setRealPeople("败");
			huiyiList.add(huiYi);
			
		}
		
		return huiyiList;
	}
    
    private static String sql(String search,String select){
    	String sql="select * from huiyidengji";
    	
    	if("登记时间".equals(select)){
    		sql = "select * from huiyidengji where date like '%"+search+"%'";
    	}else if("会议部门".equals(select)){
    		sql = "select * from huiyidengji where department like '%"+search+"%'";
    	}else if("会议地点".equals(select)){
    		sql = "select * from huiyidengji where place like '%"+search+"%'";
    	}else if("实到人数".equals(select)){
    		sql = "select * from huiyidengji where realPeople like '%"+search+"%'";
    	}else if("缺勤者名单及缘由".equals(select)){
    		sql = "select * from huiyidengji where list like '%"+search+"%'";
    	}else if("会议主题".equals(select)){
    		sql = "select * from huiyidengji where title like '%"+search+"%'";
    	}else if("会议内容".equals(select)){
    		sql = "select * from huiyidengji where content like '%"+search+"%'";
    	}else if("个人感受与建议".equals(select)){
    		sql = "select * from huiyidengji where advice like '%"+search+"%'";
    	}else if("会议负责人".equals(select)){
    		sql = "select * from huiyidengji where headPeople like '%"+search+"%'";
    	}else if("应到人数".equals(select)){
    		sql = "select * from huiyidengji where people like '%"+search+"%'";
    	}
    	
    	return sql;
    }
}
