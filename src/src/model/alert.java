package model;

import java.io.Serializable;

public class alert implements Serializable{

	private int id;
	private int userid;
	private String days;
	private int morning_min;
	private int lunch_min;
	private int dinner_min;
	private int morning_max;
	private int lunch_max;
	private int dinner_max;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public int getMorning_min() {
		return morning_min;
	}
	public void setMorning_min(int morning_min) {
		this.morning_min = morning_min;
	}
	public int getLunch_min() {
		return lunch_min;
	}
	public void setLunch_min(int lunch_min) {
		this.lunch_min = lunch_min;
	}
	public int getDinner_min() {
		return dinner_min;
	}
	public void setDinner_min(int dinner_min) {
		this.dinner_min = dinner_min;
	}
	public int getMorning_max() {
		return morning_max;
	}
	public void setMorning_max(int morning_max) {
		this.morning_max = morning_max;
	}
	public int getLunch_max() {
		return lunch_max;
	}
	public void setLunch_max(int lunch_max) {
		this.lunch_max = lunch_max;
	}
	public int getDinner_max() {
		return dinner_max;
	}
	public void setDinner_max(int dinner_max) {
		this.dinner_max = dinner_max;
	}


	public alert(int id, int userid, String days, int morning_min, int lunch_min, int dinner_min, int morning_max,
			int lunch_max, int dinner_max) {
		super();
		this.id = id;
		this.userid = userid;
		this.days = days;
		this.morning_min = morning_min;
		this.lunch_min = lunch_min;
		this.dinner_min = dinner_min;
		this.morning_max = morning_max;
		this.lunch_max = lunch_max;
		this.dinner_max = dinner_max;
	}


	public alert() {
		this.id = 0;
		this.userid = 0;
		this.days = "";
		this.morning_min = 0;
		this.lunch_min = 0;
		this.dinner_min = 0;
		this.morning_max = 0;
		this.lunch_max = 0;
		this.dinner_max = 0;
	}
}
