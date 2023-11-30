package application;

public class User {
	private String number;
	private String date;
	private String start;
	private String stop;
	private String time;
	private String lifeCycle;
	private String category;
	private String deliverable;
	
	public User(String number, String date, String start, String stop, String time, String lifeCycle, String category, String deliverable) {
		this.number = number;
		this.date = date;
		this.start = start;
		this.stop = stop;
		this.time = time;
		this.lifeCycle = lifeCycle;
		this.category = category;
		this.deliverable = deliverable;
	}
	
	public String getNumber() {
		return number;
	}
	public String getDate() {
		return date;
	}
	public String getStart() {
		return start;
	}
	public String getStop() {
		return stop;
	}
	public String getTime() {
		return time;
	}
	public String getLifeCycle() {
		return lifeCycle;
	}
	public String getCategory() {
		return category;
	}
	public String getDeliverable() {
		return deliverable;
	}
}
