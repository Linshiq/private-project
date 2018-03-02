package morefunction.qiandao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sina.sae.util.SaeUserInfo;

import morefunction.qiandao.base.QianDao;


public class QianDaoWrite {

	public static boolean qiandaoInput(QianDao qianDao) {
		
		boolean flag = false;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		try {

			String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shixiongsay";
			// 通过SaeUserInfo提供的静态方法获取应用的access_key和secret_key
			String Username = SaeUserInfo.getAccessKey();
			String Password = SaeUserInfo.getSecretKey();
			String Driver = "com.mysql.jdbc.Driver";

			Class.forName(Driver).newInstance();
			Connection con = DriverManager.getConnection(URL, Username, Password);

			PreparedStatement psql;

			// 预处理添加数据，其中有两个参数--“？”
			psql = (PreparedStatement) con.prepareStatement("insert into qiandao values(?,?,?,?,?,?)");

			if (qianDao.getName() == null || qianDao.getName().length() <= 0) {
				return false;
			} else
				psql.setString(1, qianDao.getName());

			if (qianDao.getId() == null || qianDao.getId().length() <= 0) {
				return false;
			} else
				psql.setString(2, qianDao.getId());

			if (qianDao.getMobile() == null || qianDao.getMobile().length() <= 0) {
				return false;
			} else
				psql.setString(3, qianDao.getMobile());
			
			if (qianDao.getHuodong() == null || qianDao.getHuodong().length() <= 0) {
				return false;
			} else
				psql.setString(4, qianDao.getHuodong());

			if (qianDao.getBeizhu() == null || qianDao.getBeizhu().length() <= 0) {
				psql.setString(5, "无备注");
			} else
				psql.setString(5, qianDao.getBeizhu());

			psql.setString(6, df.format(time.getTime()));

			psql.executeUpdate(); // 执行更新
			psql.close();
			con.close();
			flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
}
