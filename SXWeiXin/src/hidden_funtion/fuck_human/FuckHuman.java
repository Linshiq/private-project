package hidden_funtion.fuck_human;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuckHuman {
	/** 
	 * 判断是否是骂人语句
	 *  
	 * @param content 
	 * @return 
	 */  
	public static boolean isFuckHumanOneWork(String content) {  
	    boolean result = false;  
	  
	    // 判断单个骂人的正则表达式  
	    if (content.length() == 1) {
	    	String fuckyouallhome = "[操日滚艹坑猪狗蠢笨浪贱骚欠]";  
		    Pattern p = Pattern.compile(fuckyouallhome);  
		    Matcher m = p.matcher(content);  
		    if (m.matches()) {  
		        result = true;  
		    }  
		}/*else if (content.length() == 2) {
			result = isFuckHumanTwoWork(content);
		}*/	    
	    return result;  
	}
	
//	private static boolean isFuckHumanTwoWork(String content){
//		String fuckyouallhome = "[操-你]{2}";  
//	    Pattern p = Pattern.compile(fuckyouallhome);  
//	    Matcher m = p.matcher(content);  
//	    if (m.matches()) {  
//	    	return true;  
//	    } 
//		return false;
//	}
}
