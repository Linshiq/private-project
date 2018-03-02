package menu_right.weather_forecast.base;



import java.util.List;

public class WeatherInfo {
	
	private String txt;//天气状况描述
	private String tmp;//温度
	private String aqi;//空气质量指数
	private String qlty;//空气质量类别
	private String tmpMax;//最高温度
	private String tmpMin;//最低温度
	private String vis;//能见度
	private String sc;//风力
	private String dir;//风向
	
	private WeatherSuggestion comf; //舒适度指数
	private WeatherSuggestion cw; //洗车指数
	private WeatherSuggestion drsg; //穿衣指数
	private WeatherSuggestion flu;  //感冒指数
	private WeatherSuggestion sport; //运动指数
	private WeatherSuggestion trav; //旅游指数
	private WeatherSuggestion uv; //紫外线指数
	
	
	
	@Override
	public String toString() {
		return  "天气情况：" + txt + "\n温度：" + tmp  + "℃\n最高温度：" + tmpMax
				+ "℃\n最低温度：" + tmpMin + "℃\n能见度："+ vis + "（km）\n空气质量指数:" + aqi + "\n空气质量类别:"+ qlty + "\n风力：" + sc + "(级)\n风向：" + dir ;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}

	public WeatherSuggestion getComf() {
		return comf;
	}
	public void setComf(WeatherSuggestion comf) {
		this.comf = comf;
	}
	public WeatherSuggestion getCw() {
		return cw;
	}
	public void setCw(WeatherSuggestion cw) {
		this.cw = cw;
	}
	public WeatherSuggestion getDrsg() {
		return drsg;
	}
	public void setDrsg(WeatherSuggestion drsg) {
		this.drsg = drsg;
	}
	public WeatherSuggestion getFlu() {
		return flu;
	}
	public void setFlu(WeatherSuggestion flu) {
		this.flu = flu;
	}
	public WeatherSuggestion getSport() {
		return sport;
	}
	public void setSport(WeatherSuggestion sport) {
		this.sport = sport;
	}
	public WeatherSuggestion getTrav() {
		return trav;
	}
	public void setTrav(WeatherSuggestion trav) {
		this.trav = trav;
	}
	public WeatherSuggestion getUv() {
		return uv;
	}
	public void setUv(WeatherSuggestion uv) {
		this.uv = uv;
	}

	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getQlty() {
		return qlty;
	}
	public void setQlty(String qlty) {
		this.qlty = qlty;
	}
	public String getTmpMax() {
		return tmpMax;
	}
	public void setTmpMax(String tmpMax) {
		this.tmpMax = tmpMax;
	}
	public String getTmpMin() {
		return tmpMin;
	}
	public void setTmpMin(String tmpMin) {
		this.tmpMin = tmpMin;
	}
	public String getVis() {
		return vis;
	}
	public void setVis(String vis) {
		this.vis = vis;
	}
	public String getSC() {
		return sc;
	}
	public void setSC(String deg) {
		this.sc = deg;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	
}
