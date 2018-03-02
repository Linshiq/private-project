package menu_center.bjb_baoxiu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sina.sae.util.SaeUserInfo;

import connection_jdbc.ConnectionJDBC;
import menu_center.bjb_baoxiu.base.BJB;


public class BJBBaoXiuRead {

	private static final Logger  logger =  Logger.getLogger(BJBBaoXiuRead.class);
	
	public static List<BJB> BJBOuput(String select,String condition) {

		logger.debug("BJBBaoXiuRead.BJBOuput()>>>>>>>>>>>>>>>>start");
		
		List<BJB> bjbList = new ArrayList<BJB>();
        
//		String URL = "jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//		// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//		String Username = SaeUserInfo.getAccessKey();
//		String Password = SaeUserInfo.getSecretKey();
//		String Driver = "com.mysql.jdbc.Driver";

		String sql ="";
		try {

//			Class.forName(Driver).newInstance();
//			Connection con = DriverManager.getConnection(URL, Username, Password);
			
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Read, ConnectionJDBC.Username, ConnectionJDBC.Password);

			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
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
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			BJB useFZ = new BJB();

			useFZ.setCustnon("查");
			useFZ.setName("询");
			useFZ.setId("失");
			useFZ.setType("败");
			bjbList.add(useFZ);
		}
		
		logger.debug("BJBBaoXiuRead.BJBOuput()<<<<<<<<<<<<<<<<<end");
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
}
