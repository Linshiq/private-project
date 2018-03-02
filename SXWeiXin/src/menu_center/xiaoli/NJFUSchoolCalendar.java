package menu_center.xiaoli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class NJFUSchoolCalendar {

	/**
	 * 校历信息
	 */
	public static String getSchoolCalenda(String classNumber, HttpServletRequest request) {

		Pattern p_str = Pattern.compile("[\\u4e00-\\u9fa5]+");
		Matcher m = p_str.matcher(classNumber);

		StringBuffer buffer = new StringBuffer();
		if (m.matches()) {
			return "请输入班级号码";
		} else if ( classNumber.length() == 7 || (classNumber.startsWith("n")&&(classNumber.length() == 8))){

			String title = "班级2015-2016第二学期教学进程";

			buffer.append(classNumber + title).append("\n\n");
			buffer.append(NJFUSchoolCalendarData.getSchoolCalendaData(classNumber, request)).append("\n\n------------");
			for (int i = 0; i < buffer.length(); i++) {
				if (buffer.charAt(i) == '○') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "实习环节");
				} else if (buffer.charAt(i) == '∶') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "其它环节");
				} else if (buffer.charAt(i) == '＊') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "毕业设计 ");
				} else if (buffer.charAt(i) == '‖') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "课程设计 ");
				} else if (buffer.charAt(i) == '◎') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "强化设计 ");
				} else if (buffer.charAt(i) == '∶') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "考试 ");
				} else if (buffer.charAt(i) == '金') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "技能设计 ");
				} else if (buffer.charAt(i) == '技') {
					buffer.deleteCharAt(i);
					buffer.insert(i, "金工实习 ");
				} else if (buffer.charAt(i) == ',') {
					buffer.deleteCharAt(i);
				} else if(buffer.charAt(i) == ' '){
					buffer.deleteCharAt(i);
				}
			}
			buffer.append("------------\n").append(classNumber + title);
			 buffer.append("\n-----注释-----").append("\n");
			 buffer.append("# 其它环节 ○ 实习环节").append("\n");
			 buffer.append("＊ 毕业设计 || 课程设计").append("\n");
			 buffer.append("◎ 强化设计 : 考试").append("\n");
			 buffer.append("技 技能设计 金 金工实习").append("\n");

		}else 
			return "请输入班级号码";
		String strBuffer = new String(buffer);
		return strBuffer;

	}
}
