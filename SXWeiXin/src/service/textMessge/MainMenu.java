package service.textMessge;

public class MainMenu {

	/** 
	 * 主菜单 
	 *  
	 * @return 
	 */  
	public static String getMainMenu() {  
	    StringBuffer buffer = new StringBuffer();  
	    buffer.append("您好，我是小南林，请回复数字选择服务：").append("\n\n");  
	    buffer.append("1  南林教务网管理系统").append("\n");  
	    buffer.append("2  南林大班级课表查询").append("\n");  
	    buffer.append("3  南林大教室课表查询").append("\n");  
	    buffer.append("4  南林校历一览(本学期)").append("\n");  
	    buffer.append("5  南林大校园平面图 ").append("\n");  
	    buffer.append("6  南林大周边地铁信息").append("\n");  
	    buffer.append("7  南林简介一览").append("\n");
	    buffer.append("8  轻松音乐一听").append("\n");  
	    buffer.append("回复“帮助”显示此帮助菜单\ue24e");  
	    return buffer.toString();  
	}  
}
