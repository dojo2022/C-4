package model;

import java.io.Serializable;

	public class record_note implements Serializable {
		//テーブルの項目を再現
		private int id;
		private int userid;
		private String date;
		private String remarks;

		//getter, setter
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

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		//コンストラクタ
		public record_note(int id, int userid, String date, String remarks) {
			super();
			this.id = id;
			this.userid = userid;
			this.date = date;
			this.remarks = remarks;
		}

		//デフォルトコンストラクタ
		public record_note() {
			this.id = 0;
			this.userid = 0;
			this.date = null;
			this.remarks = "";
		}

}
