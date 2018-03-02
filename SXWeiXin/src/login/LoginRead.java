package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection_jdbc.ConnectionJDBC;
import login.base.User;
import menu_center.bjb_baoxiu.base.BJB;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月20日 下午2:57:01 
* @return  
*/
public class LoginRead {
	public static List<User> loginRead() {

		
		List<User> bjbList = new ArrayList<User>();

		String sql ="";
		try {
			
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Read, ConnectionJDBC.Username, ConnectionJDBC.Password);

			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();

			sql="select * from login";
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
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			User bjb = new User();

			bjb.setId("查询失败");
			bjb.setUserName("查询失败");
			bjb.setUserPsd("查询失败");
			bjbList.add(bjb);
		}
		
		return bjbList;
	}
}
