package model;

import java.io.Serializable;

public class recipeAdd implements Serializable{
	private int id;
	private int userid;
	private String recipe;
	private int cost;
	private int time;
	private String url;
	private String remarks;

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
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	//コンストラクタ
	public recipeAdd(int id, int userid, String recipe, int cost, int time, String url, String remarks) {
		super();
		this.id = id;
		this.userid = userid;
		this.recipe = recipe;
		this.cost = cost;
		this.time = time;
		this.url = url;
		this.remarks = remarks;
	}

	//引数のないコンストラクタ
		public recipeAdd() {
			this.id = 0;
			this.userid = 0;
			this.recipe = "";
			this.cost = 0;
			this.time = 0;
			this.url = "";
			this.remarks = "";
		}


}

