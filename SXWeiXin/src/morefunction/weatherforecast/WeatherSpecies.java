package morefunction.weatherforecast;



public class WeatherSpecies {

	private static String weatherSpecies = "晴 多云 阴 阵雨 雷阵雨 雷阵雨伴有冰雹 雨夹雪 小雨 中雨 大雨 暴雨 大暴雨 特大暴雨 阵雪 小雪 中雪 大雪 暴雪 雾 冻雨 沙尘暴 小到中雨 中到大雨 大到暴雨 暴雨到大暴雨 大暴雨到特大暴雨 小到中雪 中到大雪 大到暴雪 浮尘 扬沙 沙尘暴 强沙尘暴 特强沙尘暴 轻雾 浓雾 强浓雾 轻微霾 轻度霾 中度霾 重度霾 特强霾 霰 飑线";
	
	public static String whatSpecies(String weather) {
		
		String[] str  = weatherSpecies.split(" ");
		for(String s:str){
			System.out.println(s);
		}
		
		switch (weather) {
		case "晴":  return "qing.jpg";
		case "多云":  return "duoyun.jpg";
		case "阴":  return "yin.jpg";
		case "阵雨":  return "zhenyu.jpg";
		case "雷阵雨":  return "leizhenyu.jpg";
		case "雷阵雨伴有冰雹":  return "leizhenyu.jpg";
		case "雨夹雪":  return "yujiaxue.jpg";
		case "小雨":  return "xiaoyu.jpg";
		case "中雨":  return "zhongyu.jpg";
		case "大雨":  return "dayu.jpg";
		case "暴雨":  return "dayu.jpg";
		case "大暴雨":  return "tedabaoyu.jpg";
		case "特大暴雨":  return "tedabaoyu.jpg";
		case "阵雪":  return "xiaoxue.jpg";
		case "小雪":  return "xiaoxue.jpg";
		case "中雪":  return "zhongxue.jpg";
		case "大雪":  return "daxue.jpg";
		case "暴雪":  return "baoxue.jpg";
		case "雾":  return "wu.jpg";
		case "冻雨":  return "dongyu.jpg";
		case "沙尘暴":  return "shachenbao.jpg";
		case "小到中雨":  return "zhongyu.jpg";
		case "中到大雨":  return "dayu.jpg";
		case "大到暴雨":  return "dayu.jpg";
		case "暴雨到大暴雨":  return "tedabaoyu.jpg";
		case "大暴雨到特大暴雨":  return "tedabaoyu.jpg";
		case "小到中雪":  return "xiaoxue.jpg";
		case "中到大雪":  return "daxue.jpg";
		case "大到暴雪": return "baoxue.jpg";
		case "浮尘": return "fuchen.jpg";
		case "扬沙": return "yangsha.jpg";
		case "强沙尘暴": return "qiangshachenbao.jpg";
		case "特强沙尘暴": return "qiangshachenbao.jpg";
		case "轻雾": return "wu.jpg";
		case "浓雾": return "nongwu.jpg";
		case "强浓雾": return "nongwu.jpg";
		case "霾": return "mai.jpg";
		case "轻微霾": return "mai.jpg";
		case "轻度霾": return "mai.jpg";
		case "中度霾": return "mai.jpg";
		case "重度霾": return "mai.jpg";
		case "特强霾": return "mai.jpg";
		case "霰": return "san.jpg";
		case "飑线": return "paoxian.jpg";
		
		default:
			return "kongbai.jpg";
		}		
	}
	
	public static void main(String[] args) {
		WeatherSpecies.whatSpecies("");
	}
}
