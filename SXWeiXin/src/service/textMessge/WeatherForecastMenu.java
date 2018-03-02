package service.textMessge;

public class WeatherForecastMenu {

	/** 
     *天气预报使用指南 
     *  
     * @return 
     */  
    public static String getUsage() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("天气预报使用指南").append("\n\n");  
        buffer.append("回复：城市+城市名称").append("\n\n");  
        buffer.append("例如：城市南京").append("\n\n");  
        buffer.append("回复“帮助”显示帮助菜单\n");
        return buffer.toString();  
    } 
}
