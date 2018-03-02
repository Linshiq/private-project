package lsq.utils;

import java.text.SimpleDateFormat;

public class CommUtil {

	private static Object object2;

	public static boolean isNull(Object object) {
		if (null == object || object.toString().equals("")) {
			return true;
		}else
			return false;
	}

	public static boolean isNotNull(Object object) {
		object2 = object;
		if (null != object2 && !"".equals(object2.toString())) {
			return true;
		}else
			return false;
	}	

	public static String getSimpleDateFormat(Object object) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(object);
		return date;
	}

	public static String getSimpleTimeFormat(Object object) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(object);
		return time;
	}
}
