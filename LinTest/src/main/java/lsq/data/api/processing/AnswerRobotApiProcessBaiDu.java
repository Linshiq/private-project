package lsq.data.api.processing;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.Api;
import api.bean.answerrobot.AnswerRobot;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年12月7日 下午5:14:40 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       百度版本图灵机器人	
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年12月7日-下午5:14:40</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class AnswerRobotApiProcessBaiDu {

	private static String httpUrl = "http://apis.baidu.com/turing/turing/turing";
	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年12月7日-下午17:21:38</li>
	 *         <li>功能说明：图灵机器人总入口</li>
	 *         </p>
	 */
	public static AnswerRobot getAnswer(String info) {

		AnswerRobot answerRobot = new AnswerRobot();

		JsonParser parse = new JsonParser(); // 创建json解析器
		
		JsonObject object = (JsonObject) parse.parse(BaiDuApiProcess.request(AnswerRobotApiProcessBaiDu.httpUrl,"key="+Api.turingApiKey+"&info="+info));

		System.out.println("object="+object+" info="+info);
		
		if (object.get("code").toString().equals("100000")) {

			//JsonObject result = (JsonObject) parse.parse(object.get("result").toString());

			answerRobot.setCode(object.get("code").toString());
			answerRobot.setText(object.get("text").toString());

		} else {
			answerRobot.setCode("返回错误");
		}

		return answerRobot;
	}
	
	public static void main(String[] args) {
		//System.out.println(request("你好"));
		
		AnswerRobot answerRobot = AnswerRobotApiProcessBaiDu.getAnswer("你好");
		
		System.out.println(answerRobot.getCode() +" || " +answerRobot.getText());
	}
}
