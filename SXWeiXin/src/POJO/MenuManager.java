package POJO;


import com.urils.AccessToken;
import com.urils.WeixinUtil;

/**
 * 菜单管理器类
 * 
 */
public class MenuManager {
	//private static Logger log = LoggerFactory.getLogger(MenuManager.class);

//	public static String createMenu(){
//		
//		// 第三方用户唯一凭证
//				String appId = "wxbd1c95f88d73a137";
//				// 第三方用户唯一凭证密钥
//				String appSecret = "017225a0df3d9268c8051c2292a28966";
//
//				// 调用接口获取access_token
//				AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
//
//				if (null != at) {
//					// 调用接口创建菜单
//					int result = WeixinUtil.createMenu(getMenu(), at.getToken());
//
//					// 判断菜单创建结果
//					if (0 == result){
//			//			log.info("菜单创建成功！");
//						System.out.println("菜单创建成功");
//					    return "菜单创建成功";
//					}
//					else{
//					//	log.info("菜单创建失败，错误码：" + result);
//						System.out.println("菜单创建失败，错误码：" + result);
//						return "菜单创建失败，错误码：" + result;
//					}
//				}
//		
//		return "at为null";
//	}
	
	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wxbd1c95f88d73a137";
		// 第三方用户唯一凭证密钥
		String appSecret = "017225a0df3d9268c8051c2292a28966";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
	//			log.info("菜单创建成功！");
				System.out.println("菜单创建成功" + at.getToken());
			else
			//	log.info("菜单创建失败，错误码：" + result);
				System.out.println("菜单创建失败，错误码：" + result + at.getToken());
		}
		
		
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	 private static Menu getMenu() {  
		   
		    ViewButton banjikebiao = new ViewButton();  
		    banjikebiao.setName("班级课表");  
		    banjikebiao.setType("view");  
		    banjikebiao.setUrl("http://223.2.96.8:8090/ZNPK/KBFB_ClassSel.aspx");	        
	        ViewButton jiaoshikebiao = new ViewButton();  
	        jiaoshikebiao.setName("教室课表");  
	        jiaoshikebiao.setType("view");  	        
	        jiaoshikebiao.setUrl("http://223.2.96.8:8090/ZNPK/KBFB_RoomSel.aspx"); 
	        ViewButton jiaowuwang = new ViewButton();
	        jiaowuwang.setName("教务管理");  
	        jiaowuwang.setType("view");  
	        jiaowuwang.setUrl("http://223.2.96.8:8090/");
	        CommonButton btn13 = new CommonButton();  
	        btn13.setName("南林地图");  
	        btn13.setType("click");  
	        btn13.setKey("nanlinpingmiantu");  	  
	        CommonButton btn14 = new CommonButton();  
	        btn14.setName("周边地铁");  
	        btn14.setType("click");  
	        btn14.setKey("nanlinsubway");  
	  	        
	        
	        CommonButton translation = new CommonButton();  
	        translation.setName("翻译系统");  
	        translation.setType("click");  
	        translation.setKey("translation");
	        CommonButton xiaoli = new CommonButton();  
	        xiaoli.setName("校历查询");  
	        xiaoli.setType("click");  
	        xiaoli.setKey("xiaoli");
	        CommonButton help = new CommonButton();  
	        help.setName("电脑维修登记");  
	        help.setType("click");  
	        help.setKey("bjbbaoxiu"); 
	        CommonButton huiyidengji = new CommonButton();  
	        huiyidengji.setName("会议记录登记");  
	        huiyidengji.setType("click");  
	        huiyidengji.setKey("huiyijilu");
	  	        
	        
	        CommonButton weatherForecast = new CommonButton();  
	        weatherForecast.setName("天气预报");  
	        weatherForecast.setType("click");  
	        weatherForecast.setKey("weatherForecast");  		  
	        CommonButton joke = new CommonButton();  
	        joke.setName("幽默笑话");  
	        joke.setType("click");  
	        joke.setKey("joke");  	         	  
	        CommonButton TodayInHistory = new CommonButton();  
	        TodayInHistory.setName("历史上的今天");  
	        TodayInHistory.setType("click");  
	        TodayInHistory.setKey("todayinHistory");
	        CommonButton qiandao = new CommonButton();  
	        qiandao.setName("签到");  
	        qiandao.setType("click");  
	        qiandao.setKey("qiandao");
	        
	        ComplexButton mainBtn1 = new ComplexButton();  
	        mainBtn1.setName("查询系统");  
	        mainBtn1.setSub_button(new Button[] { jiaowuwang, jiaoshikebiao, banjikebiao ,btn13, btn14 }); 
	        
	        ComplexButton mainBtn2 = new ComplexButton();  
	        mainBtn2.setName("小工具");  
	        mainBtn2.setSub_button(new CommonButton[] { translation,xiaoli,help,huiyidengji });  
	  
	        ComplexButton mainBtn3 = new ComplexButton();  
	        mainBtn3.setName("更多体验");  
	        mainBtn3.setSub_button(new CommonButton[] {qiandao, weatherForecast, joke ,TodayInHistory });  
	  
	        /** 
	         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
	         *  
	         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
	         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
	         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
	         */  
	        Menu menu = new Menu();  
	        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
	  
	        return menu;  
	    }  
}