package menu_center.huiyi_dengji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sina.sae.util.SaeUserInfo;
import com.tool.StringUtil;

import connection_jdbc.ConnectionJDBC;
import menu_center.huiyi_dengji.base.HuiYi;
import test.ConnectionJDBCTest;


public class HuiYiDJWrite {

	public static String huiYiInput(HuiYi huiyi){
		
		String flag = "";
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		if(!StringUtil.strIsNotEmpty(huiyi.getDate()))
			huiyi.setDate(df.format(time.getTime()));
		try {

//			String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//			// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//			String Username = SaeUserInfo.getAccessKey();
//			String Password = SaeUserInfo.getSecretKey();
//			String Driver = "com.mysql.jdbc.Driver";
			//Connection con = ConnectionJDBCTest.getConn();
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);

			PreparedStatement psql;
			
			
			// 预处理添加数据，其中有两个参数--“？”
			psql = (PreparedStatement) con.prepareStatement("insert into huiyidengji values(?,?,?,?,?,?,?,?,?,?,?)");

			if(StringUtil.strIsNotEmpty(huiyi.getCustno())){
			 psql.setString(1, huiyi.getCustno());
			}else{
				String uuuid = UUID.randomUUID().toString();
				psql.setString(1,uuuid);
			}
			
            if(huiyi.getDepartment() == null || huiyi.getDepartment().length() <= 0){
            	return "部门不可为空";
            }else{
            	psql.setString(2, huiyi.getDepartment()); 
            }
            
            if(huiyi.getPlace() == null || huiyi.getPlace().length() <= 0){
            	return "会议地点不可为空";
            }else{
            	psql.setString(3, huiyi.getPlace()); 
            }
            
            if(huiyi.getRealPeople() == null || huiyi.getRealPeople().length() <= 0){
            	psql.setString(4, "0"); 
            }else{
            	psql.setString(4, huiyi.getRealPeople()); 
            }
            
            if(huiyi.getPeople() == null || huiyi.getPeople().length() <= 0){
            	psql.setString(5, "0"); 
            }else{
            	psql.setString(5, huiyi.getPeople()); 
            }
            
            if(huiyi.getList() == null || huiyi.getList().length() <= 0){
            	psql.setString(6, "空"); 
            }else{
            	psql.setString(6, huiyi.getList()); 
            }
            
            if(huiyi.getTitle() == null || huiyi.getTitle().length() <= 0){
            	psql.setString(7, "没有主题"); 
            }else{
            	psql.setString(7, huiyi.getTitle()); 
            }
            
            if(huiyi.getContent() == null || huiyi.getContent().length() <= 0){
            	psql.setString(8, "没有内容"); 
            }else{
            	psql.setString(8, huiyi.getContent()); 
            }
            
            if(huiyi.getAdvice() == null || huiyi.getAdvice().length() <= 0){
            	psql.setString(9, "没有建议"); 
            }else{
            	psql.setString(9, huiyi.getAdvice()); 
            }
            
            if(huiyi.getHeadPeople() == null || huiyi.getHeadPeople().length() <= 0){
            	psql.setString(10, "没有负责人"); 
            }else{
            	psql.setString(10, huiyi.getHeadPeople()); 
            }
            
            psql.setString(11, huiyi.getDate()); 
			
            psql.executeUpdate(); // 执行更新
			psql.close();
			con.close();
			flag = "提交成功";

		} catch (Exception e) {
			flag = "提交异常";
		}
		return flag;
	}
	
	public static void delete(String custno){
		
		try {
//			Class.forName(driver); //classLoader,加载对应驱动
	       // con = (Connection) DriverManager.getConnection(url, username, password);
	        Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
			//Connection con = ConnectionJDBCTest.getConn();
			PreparedStatement pstmt;
			
			pstmt = con.prepareStatement("DELETE FROM huiyidengji WHERE custno = '"+custno+"'"); // 执行更新
			pstmt.executeUpdate(); // 执行更新
			pstmt.close();
			con.close();
		}catch(Exception e){
			
		}
		
	}
	
	public static void  update(HuiYi huiyi) {
		try {
//			Class.forName(driver); //classLoader,加载对应驱动
//	        con = (Connection) DriverManager.getConnection(url, username, password);
	        //Class.forName(ConnectionJDBC.Driver).newInstance();
			//Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Write, ConnectionJDBC.Username, ConnectionJDBC.Password);
			//Connection con = ConnectionJDBCTest.getConn();
			//PreparedStatement pstmt;
			System.out.println(huiyi.toString());
			HuiYiDJWrite.delete(huiyi.getCustno());
			HuiYiDJWrite.huiYiInput(huiyi);
//////			pstmt = con.prepareStatement("UPDATE huiyidengji "
//////					+ "SET"
//////					+ "department='"+huiyi.getDepartment()+"',"
//////					+ "place='"+huiyi.getPlace()+"',"
//////					+ "realPeople='"+huiyi.getRealPeople()+"',"
//////					+ "people='"+huiyi.getPeople()+"',"
//////					+ "list='"+huiyi.getList()+"',"
//////					+ "title='"+huiyi.getTitle()+"',"
//////					+ "content='"+huiyi.getContent()+"',"
//////					+ "advice='"+huiyi.getAdvice()+"',"
//////					+ "headPeople='"+huiyi.getHeadPeople()+"',"
//////					+ " WHERE custno = '"+huiyi.getCustno()+"'"); // 执行更新
////			pstmt.executeUpdate(); // 执行更新
////			pstmt.close();
//			con.close();
		}catch(Exception e){
			System.out.println("update false"+e);
		}
	}
}
