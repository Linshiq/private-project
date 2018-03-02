package hidden_funtion.tongji_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.formula.functions.Year;

import com.sina.sae.util.SaeUserInfo;
import com.tool.StringUtil;

import connection_jdbc.ConnectionJDBC;
import hidden_funtion.tongji_user.base.UseFZ;
import test.ConnectionJDBCTest;


public class DealMsg {

	public static List<UseFZ> dealMsga() {

//		String URL = "jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_shixiongsay";
//		// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
//		String Username = SaeUserInfo.getAccessKey();
//		String Password = SaeUserInfo.getSecretKey();
//		String Driver = "com.mysql.jdbc.Driver";

		List<UseFZ> resultList = new ArrayList<UseFZ>();

		try {

//			Class.forName(Driver).newInstance();
//			Connection con = DriverManager.getConnection(URL, Username, Password);
			//Connection con = ConnectionJDBCTest.getConn();
			Class.forName(ConnectionJDBC.Driver).newInstance();
			Connection con = DriverManager.getConnection(ConnectionJDBC.URL_Read, ConnectionJDBC.Username, ConnectionJDBC.Password);
			List<UseFZ> useFZList = ReadTxt.readJDBC();

			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句use_frequency
			String sql = "";
			for (UseFZ u : useFZList){//去重
				sql = "select count(useNum) allNum from use_frequency where useName='"+u.getUseName()+"' and useType ='"+u.getUseType()+"'";
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					System.out.println(rs.getInt("allNum"));
					UseFZ useFZ = new UseFZ();				 
					useFZ.setUseName(u.getUseName());
					useFZ.setUseNum(rs.getInt("allNum")+"");
					useFZ.setUseType(u.getUseType());
					resultList.add(useFZ);

				}				
				rs.close();
			}
			System.out.println("-----2-------");
			for(UseFZ u : resultList){
				System.out.println(u.getUseName()+"|"+u.getUseType()+"|"+u.getUseNum());
			}
			UseFZ kong = new UseFZ();				 
			kong.setUseName("-");
			kong.setUseNum("-");
			kong.setUseType("-");
			for(int i=0;i<resultList.size();i++){
				if(i>=resultList.size())
					break;
				
				for(int j=0;j<resultList.size();j++){
					
					if(j>=resultList.size())
						break;
					
					if(i == j )
						continue;
					if(!StringUtil.strIsNotEmpty(resultList.get(i).getUseName()) 
							|| !StringUtil.strIsNotEmpty(resultList.get(j).getUseName()) 
							|| !StringUtil.strIsNotEmpty(resultList.get(j).getUseType()) 
							|| !StringUtil.strIsNotEmpty(resultList.get(i).getUseType())){
						break;
					}
					if(resultList.get(i).getUseName().equals(resultList.get(j).getUseName()) && resultList.get(i).getUseType().equals(resultList.get(j).getUseType())){
						System.out.println("1");
						resultList.remove(j);
						resultList.add(j,kong );
					}									
				}
			}
			System.out.println("-----1-------");
			for(UseFZ u : resultList){
				System.out.println(u.getUseName()+"|"+u.getUseType()+"|"+u.getUseNum());
			}
/*
			Set<String> nameSet = new HashSet<String>();
			for (UseFZ u : useFZList)//去重
				nameSet.add(u.getUseName());

			int num = 0;

			String name = "";
			for (String s : nameSet) {

				sql = "select * from use_frequency where useName = '" + s + "'";
				// 3.ResultSet类，用来存放获取的结果集！！
				ResultSet rs = statement.executeQuery(sql);
			
				name = WeiXinUserName.getName(s);
				
				List<String> typeList = new ArrayList<String>();

				num = 0;
				while (rs.next()) {

					typeList.add(rs.getString("useType"));

				}

				Set<String> typeSet = new HashSet<String>();
				
				for (String u : typeList) //去重
					typeSet.add(u);

				for (String ss : typeSet) {
					num = 0;
					UseFZ useFZ = new UseFZ();
					if (StringUtil.strIsNotEmpty(name)) {
						useFZ.setUseName(name);
					}else
					     useFZ.setUseName(s);
					useFZ.setUseType(ss);
					for (String sss : typeList) {//统计使用了多少次
						if (sss.equals(ss)) 
							num++;
					}
					if (num != 0) {
						useFZ.setDate(num + "");
						resultList.add(useFZ);
					}
				}
				
				rs.close();

			}
		*/
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e+"|"+e.getMessage());
			UseFZ useFZ = new UseFZ();
 
			useFZ.setUseName("查");
			useFZ.setUseNum("询");
			useFZ.setUseType("失");
			useFZ.setDate("败");
			resultList.add(useFZ);
		}

		return resultList;
	}
	
	public static void main(String[] args) {
		DealMsg.dealMsga();
	}
}
