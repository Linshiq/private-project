package service.textMessge;

public class MusicMenu {

	/** 
     * 歌曲点播使用指南 
     *  
     * @return 
     */  
    public static String getUsage() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("歌曲点播操作指南").append("\n\n");  
        buffer.append("回复：歌曲+歌名").append("\n");  
        buffer.append("例如：歌曲存在").append("\n");  
        buffer.append("或者：歌曲存在@汪峰").append("\n\n");
        buffer.append("如果您想返回的是文本信息请进行如下操作:\n");  
        buffer.append("回复：文本歌曲+歌名").append("\n");  
        buffer.append("例如：文本歌曲存在").append("\n");  
        buffer.append("或者：文本歌曲存在@汪峰").append("\n\n");
        buffer.append("回复“帮助”显示帮助菜单\n").append("这个搜索有点坑爹\n等待时间超过5秒,则搜索失败!\n");
        buffer.append("得到的URL为下载地址,有些手机可以打开,有些不行,抱歉!\n只有文本歌曲才会返回可供复制的URL");
        return buffer.toString();  
    }  
}
