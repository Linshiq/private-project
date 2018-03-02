package service.textMessge;

public class HelpMenu {

	/**
	 * 帮助菜单
	 */
	public static String getHelpMenu() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("----帮助菜单----").append("\n\n");
		buffer.append("1.点击相应的菜单按钮，会有相应的提示帮助").append("\n");
		buffer.append("2.输入任意字符，将会弹出主菜单（除了关键字）").append("\n");
		buffer.append("3.目前系统锁定的关键字有： 笑话, 城市，翻译，班级，2-4个汉字，显示所有等级").append("\n");
		buffer.append("4.目前系统锁定的关键字的数字有：1 至 8").append("\n");
		buffer.append("5.您可以输入您的名字（仅限2-4字）").append("\n");
		buffer.append("注：关键字指的是在文本的开头部分输入的字体").append("\n");
		return buffer.toString();		
	}
}
