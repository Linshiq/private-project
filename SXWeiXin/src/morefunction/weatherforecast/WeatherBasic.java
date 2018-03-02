package morefunction.weatherforecast;


/**
 * 
 * @author lsq
 * //基本信息
 *
 */

public class WeatherBasic {

	private String city; // 城市名称
	private String cnty; // 国家
	private String id; // 城市ID，参见http://www.heweather.com/documents/cn-city-list
	private String lat; // 城市维度
	private String lon;// 城市经度
	private String loc; // 当地时间
	private String utc; // UTC时间
	
	
	
	@Override
	public String toString() {
		return "城市名称：" + city + "\n属于国家：" + cnty + "\n城市ID：" + id + "\n当地时间：" + loc ;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCnty() {
		return cnty;
	}
	public void setCnty(String cnty) {
		this.cnty = cnty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getUtc() {
		return utc;
	}
	public void setUtc(String utc) {
		this.utc = utc;
	}
}
