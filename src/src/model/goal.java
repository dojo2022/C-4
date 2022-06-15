package model;

import java.io.Serializable;

public class goal implements Serializable {

	//フィールド
	private int id; //ID
	private int userid; //ユーザID
	private java.sql.Date date; //日付
	private int money; //目標金額
	private int sum; //recordテーブルのsavings(節約金額)の合計が勝手にここに入る

	//ゲッターとセッター
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
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

	//引数のあるコンストラクタ
	public goal(int id, int userid, java.sql.Date date, int money, int sum) {
		super();
		this.id = id;
		this.userid = userid;
		this.date = date;
		this.money = money;
		this.sum = sum;
	}

	//引数のないコンストラクタ
	public goal() {
		this.id = 0;
		this.userid = 0;
		this.date = null;
		this.money = 0;
		this.sum = 0;
	}
}


