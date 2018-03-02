package service.toDealWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hidden_funtion.fuck_human.FuckHuman;
import hidden_funtion.qq_face.QqFace;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月19日 上午9:31:58 
* @return  用户消息处理分类
*/

public class CSMsgDealWith {

	public static String csMsgDealWith(String msgContent) {

		if (QqFace.isQqFace(msgContent)) {
			return "QqFace"+msgContent;
		}else if(FuckHuman.isFuckHumanOneWork(msgContent)){
			return "FuckHuman"+msgContent;
		}else if (msgContent.length() == 1) {// 判断是否长度为1
			if (iSOneNumber(msgContent)) {// 调用判断是否为数字
				String msgStr = "";
				switch (msgContent) {
				case "1":
					msgStr = "点击<a href=\"http://223.2.96.8:8090/\">南林教务管理系统网站</a>进入";
					return "NumberService" + msgStr;
				case "2":
					msgStr = "点击\n<a href=\"http://223.2.96.8:8090/ZNPK/KBFB_ClassSel.aspx\">南林班级课表</a>\n进入查询网站";
					return "NumberService" + msgStr;
				case "3":
					msgStr = "点击\n<a href=\"http://223.2.96.8:8090/ZNPK/KBFB_RoomSel.aspx\">南林教室课表</a>\n进入查询网站";
					return "NumberService" + msgStr;
				case "4":
					msgStr = "请输入您的班级(不要加入空格等其它信息):";
					return "NumberService" + msgStr;
				case "5":
					return "NumberService" + msgContent;
				case "6":
					return "NumberService" + msgContent;
				case "7":
					return "NumberService" + msgContent;
				case "8":
					return "NumberService" + msgContent;
				default:
					return "NumberService" + "没有查询到您输入的" + msgContent + "这项信息";
				}
			} else
				return msgContent;

		}else if (msgContent.length() == 7) {// 判断是否长度为7
			if(iSOneNumber(msgContent))
				return "班级"+msgContent;
		}else if(msgContent.startsWith("翻译")){
			return msgContent;
		}else if(msgContent.startsWith("城市")){
			return msgContent;
		}else if(msgContent.startsWith("笑话")){
			return msgContent;
		}else if(msgContent.startsWith("帮助")){
			return msgContent;
		}else if(msgContent.startsWith("显示所有等级")){
			return msgContent;
		}else {
			
			return "msgContent";
		}

		return msgContent;
	}

	public static boolean iSOneNumber(String msgContent) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(msgContent);
		if (isNum.matches()) {
			return true;
		} else
			return false;

	}

	public static void main(String[] args) {
		System.out.println(CSMsgDealWith.csMsgDealWith("翻译11"));

	}
}
