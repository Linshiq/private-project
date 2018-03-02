package morefunction.joke;



public class JokeList {

	private String ct;
	private String text;
	private String title;
	private String typt;
	
	@Override
	public String toString() {
		return "JokeList [ct=" + ct + ", text=" + text + ", title=" + title + ", typt=" + typt + "]";
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypt() {
		return typt;
	}
	public void setTypt(String typt) {
		this.typt = typt;
	}
}
