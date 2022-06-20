package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.alert;

public class alertDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<alert> select(alert param) {
		Connection conn = null;
		List<alert> alertList = new ArrayList<alert>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT days, morning_min, lunch_min, dinner_min, morning_max, "
					+ "lunch_max, dinner_max FROM alert WHERE userid=? AND days=?";
			PreparedStatement selectalert = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUserid() != 0) {
				selectalert.setInt(1, param.getUserid());
			}
			else {
				selectalert.setString(1, "%");
			}
			if (param.getDays() != "") {
				selectalert.setString(2, param.getDays());
			}
			else {
				selectalert.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = selectalert.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				alert card = new alert(
				rs.getInt("id"),
				rs.getInt("userid"),
				rs.getString("days"),
				rs.getInt("morning_min"),
				rs.getInt("lunch_min"),
				rs.getInt("dinner_min"),
				rs.getInt("morning_max"),
				rs.getInt("lunch_max"),
				rs.getInt("dinner_max")
				);
				alertList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			alertList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			alertList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					alertList = null;
				}
			}
		}

		// 結果を返す
		return alertList;
	}

	//アラート時間の登録
	public boolean insert(alert card) {
		Connection conn = null;
		boolean result = false;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "insert into alert values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUserid() != 0) {
				pStmt.setInt(1, card.getUserid());
			}
			else {
				pStmt.setInt(1, 0);
			}

			if (card.getDays() != null && !card.getDays().equals("")) {
				pStmt.setString(2, card.getDays());
			}
			else {
				pStmt.setString(2, "");
			}

			if (card.getMorning_min() != 0) {
				pStmt.setInt(3, card.getMorning_min());
			}
			else {
				pStmt.setInt(3, 0);
			}

			if (card.getLunch_min() != 0) {
				pStmt.setInt(4, card.getLunch_min());
			}
			else {
				pStmt.setInt(4, 0);
			}

			if (card.getDinner_min() != 0) {
				pStmt.setInt(5, card.getDinner_min());
			}
			else {
				pStmt.setInt(5, 0);
			}

			if (card.getMorning_max() != 0) {
				pStmt.setInt(6, card.getMorning_max());
			}
			else {
				pStmt.setInt(6, 0);
			}

			if (card.getLunch_max() != 0) {
				pStmt.setInt(7, card.getLunch_max());
			}
			else {
				pStmt.setInt(7, 0);
			}

			if (card.getDinner_max() != 0) {
				pStmt.setInt(8, card.getDinner_max());
			}
			else {
				pStmt.setInt(8, 0);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(alert card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

				// SQL文を準備する
				String sql = "update alert set morning_min=?, lunch_min=?, dinner_min=?, "
						+ "morning_max=?, lunch_max=?, dinner_max=? where userid=? AND days=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				/*if (card.getDays() != null && !card.getDays().equals("")) {
					pStmt.setString(1, card.getDays());
				}
				else {
					pStmt.setString(1, null);
				}*/
				if (card.getMorning_min() != 0) {
					pStmt.setInt(1, card.getMorning_min());
				}
				else {
					pStmt.setInt(1, 0);
				}
				if (card.getLunch_min() != 0) {
					pStmt.setInt(2, card.getLunch_min());
				}
				else {
					pStmt.setInt(2, 0);
				}

				if (card.getDinner_min() != 0) {
					pStmt.setInt(3, card.getDinner_min());
				}
				else {
					pStmt.setInt(3, 0);
				}

				if (card.getMorning_max() != 0) {
					pStmt.setInt(4, card.getMorning_max());
				}
				else {
					pStmt.setInt(4, 0);
				}
				if (card.getLunch_max() != 0) {
					pStmt.setInt(5, card.getLunch_max());
				}
				else {
					pStmt.setInt(5, 0);
				}

				if (card.getDinner_max() != 0) {
					pStmt.setInt(6, card.getDinner_max());
				}
				else {
					pStmt.setInt(6, 0);
				}
				pStmt.setInt(7, card.getUserid());
				pStmt.setString(8, card.getDays());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
}
