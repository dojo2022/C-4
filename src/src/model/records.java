package model;

import java.io.Serializable;
import java.sql.Date;
//import java.util.Date;　念のためコメントアウト

public class records implements Serializable {

	private int id;
	private int userid;
	private Date date;
	private String mealtime;
	private int recipeid;
	private int savings;

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
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMealtime() {
		return mealtime;
	}
	public void setMealtime(String mealtime) {
		this.mealtime = mealtime;
	}
	public int getRecipeid() {
		return recipeid;
	}
	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}
	public int getSavings() {
		return savings;
	}
	public void setSavings(int savings) {
		this.savings = savings;
	}

	public records (int id, int userid, Date date, String mealtime, int recipeid, int savings) {
		super();
		this.id = id;
		this.userid = userid;
		this.date = date;
		this.mealtime = mealtime;
		this.recipeid = recipeid;
		this.savings = savings;
	}

	public records() {
		this.id = 0;
		this.userid = 0;
		this.date = null;
		this.mealtime = "朝";
		this.recipeid = 0;
		this.savings = 0;
	}

}
