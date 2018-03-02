package service.textMessge;

public class TranslationMenu {

	/** 
	 * Q译通使用指南 
	 *  
	 * @return 
	 */  
	public static String getTranslateUsage() {  
	    StringBuffer buffer = new StringBuffer();  
	    buffer.append("翻译使用指南").append("\n\n");  
	    buffer.append("我们为用户提供专业的多语言翻译服务，目前支持以下翻译方向：").append("\n");  
	    buffer.append("    中 -> 英").append("\n");  
	    buffer.append("    英 -> 中").append("\n\n");   
	    buffer.append("使用示例：").append("\n");  
	    buffer.append("    翻译我是中国人").append("\n");  
	    buffer.append("    翻译dream").append("\n\n");  
	    buffer.append("回复“帮助”显示帮助菜单");  
	    return buffer.toString();  
	} 
}
