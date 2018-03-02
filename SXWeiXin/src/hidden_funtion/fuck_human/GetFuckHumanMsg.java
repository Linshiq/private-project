package hidden_funtion.fuck_human;

import java.util.Random;

public class GetFuckHumanMsg {

	public static String  getFuckHumanMsg() {
		
		String fuckHumanStr = "";
		
		Random random = new Random();
		int ranInt = random.nextInt(5);
		
		switch (ranInt) {
		case 0:
			fuckHumanStr = "你可以说我天真,但是不能羞辱我!/:P-(/:P-(";
			break;
		case 1:
			fuckHumanStr = "你可以说我天真,但是不能骂我!/:,@!/:,@!";
			break;
		case 2:
			fuckHumanStr = "/::@你这是对我人格的侮辱,灵魂的强奸!/::@";
			break;
		case 3:
			fuckHumanStr = "你想挂科吗?/:<@";
			break;
		default:
			fuckHumanStr = "我忍!/:,@o";
			break;
		}
		
		return fuckHumanStr;
	}
	
	public static void main(String[] args) {
		System.out.println(GetFuckHumanMsg.getFuckHumanMsg());
	}
}
