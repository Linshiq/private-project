package service.toDealWith;

import java.util.ArrayList;
import java.util.List;

import com.message.resp.Article;
import com.message.resp.NewsMessage;
import com.tool.CommUtil;
import com.urils.MessageUtil;

import hidden_funtion.fuck_human.FuckHuman;
import hidden_funtion.fuck_human.GetFuckHumanMsg;
import hidden_funtion.qq_face.QqFace;
import menu_center.translation.BaiduTranslateService;

/**
 * <p>
 * 文件功能说明：文本消息处理
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2016年8月30日-下午4:06:34</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TextDealWith {

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年8月30日-下午4:08:52</li>
	 *         <li>功能说明：接收传递过来的文本信息</li>
	 *         </p>
	 * @return
	 */
	public static String getDealWithResults(String msgContent) {

		String getStr = "";

		if (isQqFace(msgContent)) {
			getStr = msgContent;
		} else if (isFuckHumanOneWork(msgContent)) {
			getStr = GetFuckHumanMsg.getFuckHumanMsg();
		} else if (CommUtil.isNumeric(msgContent)) {
			getStr = toNumber(msgContent);
		}

		return getStr;
	}

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年8月30日-下午4:11:17</li>
	 *         <li>功能说明：判断是否为表情</li>
	 *         </p>
	 * @return
	 */
	private static boolean isQqFace(String msgContent) {
		if (QqFace.isQqFace(msgContent)) {
			return true;
		} else
			return false;
	}

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年8月30日-下午4:15:52</li>
	 *         <li>功能说明：判断是否使用了骂人语句</li>
	 *         </p>
	 * @param msgContent
	 * @return
	 */
	private static boolean isFuckHumanOneWork(String msgContent) {
		if (FuckHuman.isFuckHumanOneWork(msgContent))
			return true;
		else
			return false;
	}

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年8月30日-下午4:20:20</li>
	 *         <li>功能说明：判断用户选择的数字</li>
	 *         </p>
	 * @return
	 */
	private static String toNumber(String msgContent) {
		return msgContent;
	
	}
}
