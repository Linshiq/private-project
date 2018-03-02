package menu_center.huiyi_dengji.base;

public class HuiYi {

	private String custno;
	private String department;
	private String place;
	private String realPeople;
	private String people;
	private String list;
	private String title;
	private String content;
	private String advice;
	private String headPeople;
	private String date;
	
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRealPeople() {
		return realPeople;
	}
	public void setRealPeople(String realPeople) {
		this.realPeople = realPeople;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getHeadPeople() {
		return headPeople;
	}
	public void setHeadPeople(String headPeople) {
		this.headPeople = headPeople;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "HuiYi [custno=" + custno + ", department=" + department + ", place=" + place + ", realPeople="
				+ realPeople + ", people=" + people + ", list=" + list + ", title=" + title + ", content=" + content
				+ ", advice=" + advice + ", headPeople=" + headPeople + ", date=" + date + "]";
	}
	
	
}
