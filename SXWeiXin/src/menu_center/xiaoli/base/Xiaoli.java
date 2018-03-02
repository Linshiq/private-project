package menu_center.xiaoli.base;

public class Xiaoli {
	private String class_;
	private String week_;
	private String course_;
	
	public String getCourse_() {
		return course_;
	}

	public void setCourse_(String course_) {
		this.course_ = course_;
	}

	public Xiaoli(String class_ , String week_ , String coures_) {
		this.class_ = class_;
		this.week_ = week_;
		this.course_ = coures_;
	}
	
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	public String getWeek_() {
		return week_;
	}
	public void setWeek_(String week_) {
		this.week_ = week_;
	}
}
