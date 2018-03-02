package morefunction.weatherforecast;



public class WeatherForecast {

	private String status;
	private String basic;
	private String now;
	private String aqi;
	private String daily_forecast;
	private String hourly_forecast;
	private String suggestion;
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return status+"\n"+ basic + "\n"+ now;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getDaily_forecast() {
		return daily_forecast;
	}
	public void setDaily_forecast(String daily_forecast) {
		this.daily_forecast = daily_forecast;
	}
	public String getHourly_forecast() {
		return hourly_forecast;
	}
	public void setHourly_forecast(String hourly_forecast) {
		this.hourly_forecast = hourly_forecast;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
/*	private String city; // 城市名称
	private String cnty; // 国家
	private String id; // 城市ID，参见http://www.heweather.com/documents/cn-city-list
	private String lat; // 城市维度
	private String lon;// 城市经度
	private String loc; // 当地时间
	private String utc; // UTC时间
	private String code; // 天气状况代码
	private String txt; // 天气状况描述
	private String fl; // 体感温度
	private String hum;// 相对湿度（%）
	private String pcpn; // 降水量（mm）
	private String pres;// 气压
	private String tmp;// 温度
	private String vis; // 能见度（km）
	private String wind;// 风力风向
	private String deg;// 风向（360度）
	private String dir;// 风向
	private String sc; // 风力
	private String spd;// 风速（kmph）
	private String aqi;// 空气质量指数
	private String co; // 一氧化碳1小时平均值(ug/m³)
	private String no2; // 二氧化氮1小时平均值(ug/m³)
	private String o3; // 臭氧1小时平均值(ug/m³)
	private String pm10;// PM10 1小时平均值(ug/m³)
	private String pm25;// PM2.5 1小时平均值(ug/m³)
	private String qlty;// 空气质量类别
	private String so2;// 二氧化硫1小时平均值(ug/m³)
	private String    date;//预报日期
	private String        sr; //日出时间
	private String        ss; //日落时间
private String       code_d; //白天天气状况代码，参考http://www.heweather.com/documents/condition-code
private String       code_n; //夜间天气状况代码
private String        txt_d;//白天天气状况描述
private String        txt_n; //夜间天气状况描述
*/	
	/*private String cityName; //城市
	private String cityPinyin; //城市拼音
	private String cityCode; //城市编码
	private String date;  //日期
	private String time;  //发布时间
	private String postCode; //邮编
	private String longitude; //经度
	private String latitude; //维度
	private String altitude; //海拔
	private String weather; //天气情况	 
	private String temp;  //气温
	private String l_tmp;  //最低气温
	private String h_tmp;  //最高气温
	private String WD; //风向
	private String WS; //风力
	private String sunrise; //日出时间
	private String sunset;  //日落时间
	@Override
	public String toString() {
		return "城市: " + cityName + "\n城市拼音: " + cityPinyin + "\n城市编码: " + cityCode + "\n日期: " + date + "\n发布时间: " + time
				+ "\n天气情况: " + weather + "\n气温: " + temp + "\n最低气温: " + l_tmp + "\n最高气温: " + h_tmp + "\n风向: " + WD
				+ "\n风力: " + WS + "\n经度: " + longitude + "\n维度: " + latitude + "\n海拔: " + altitude + "\n邮编: " + postCode
				+ "\n日出时间: " + sunrise + "\n日落时间: " + sunset;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityPinyin() {
		return cityPinyin;
	}
	public void setCityPinyin(String cityPinyin) {
		this.cityPinyin = cityPinyin;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getL_tmp() {
		return l_tmp;
	}
	public void setL_tmp(String l_tmp) {
		this.l_tmp = l_tmp;
	}
	public String getH_tmp() {
		return h_tmp;
	}
	public void setH_tmp(String h_tmp) {
		this.h_tmp = h_tmp;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	public String getWS() {
		return WS;
	}
	public void setWS(String wS) {
		WS = wS;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}*/
	
	
}
