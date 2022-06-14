package model;

import java.io.Serializable;

	public class record_note implements Serializable {
		//テーブルの項目を再現
		 private String recipe;
		private int cost;
		private int time;
		private String url;
		private String notes;
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
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public record_note(String recipe, int cost, int time, String url, String notes) {
			super();
			this.recipe = recipe;
			this.cost = cost;
			this.time = time;
			this.url = url;
			this.notes = notes;
		}

		public record_note() {
			this.recipe = "";
			this.cost = 0;
			this.time = 0;
			this.url = "";
			this.notes = "";
		}



}
