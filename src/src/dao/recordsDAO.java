package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;

import model.recipeAdd;
import model.records;

public class recordsDAO {
	//レシピを検索して表示 recipeidを基にレシピを検索する ここを使うことはないかも
	public List<recipeAdd> select(recipeAdd param) {
		Connection conn = null;
		List<recipeAdd> cardList = new ArrayList<recipeAdd>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する EL式
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する ここのデータが正常にとれていない ?にidを入れて、getとsetを1つ入れる
			String sql = "SELECT recipe, cost FROM recipe WHERE userid=0 or userid = ?;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 改造ポイント
			if (param.getUserid() != 0) {
				pStmt.setInt(1, param.getUserid());
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする 繰り返し表現　取り出したデータを配列に
			while (rs.next()) {
				recipeAdd card = new recipeAdd(
						0, 0, rs.getString("recipe"), rs.getInt("cost"), 0, "", "");
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
	}

	//詳細記録で表示するもの
	public List<records> select(records param) {
		Connection conn = null;
		List<records> cardList = new ArrayList<records>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する EL式
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する 改造ポイント
			String sql = "SELECT userid, date, mealtime, recipeid, savings "
					+ "FROM records WHERE userid LIKE ? AND date LIKE ? AND mealtime LIKE ? AND recipeid LIKE ? AND savings LIKE?"
					+ "ORDER BY id";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 改造ポイント
			if (param.getUserid() != 0) {
				pStmt.setInt(1, param.getUserid());
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getDate() != null) {
				pStmt.setString(2, param.getDate());
			} else {
				pStmt.setString(2, "%");
			}
			if (param.getMealtime() != null) {
				pStmt.setString(3, "%" + param.getMealtime() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			if (param.getRecipeid() != 0) {
				pStmt.setInt(4, param.getRecipeid());
			} else {
				pStmt.setString(4, "%");
			}
			if (param.getSavings() != 0) {
				pStmt.setInt(5, param.getSavings());
			} else {
				pStmt.setString(5, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする 繰り返し表現　取り出したデータを配列に
			while (rs.next()) {
				records card = new records(
						rs.getInt("id"),
						rs.getInt("userid"),
						rs.getString("date"),
						rs.getString("mealtime"),
						rs.getInt("recipeid"),
						rs.getInt("savings"));
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
	}

	// 日々の食事記録を登録
	public boolean records_insert(records card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "insert into records(id, userid, date, mealtime, recipeid, savings) values "
					+ "(null, ?, ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getId() != 0) {
				pStmt.setInt(1, card.getId());
			} else {
				pStmt.setInt(1, 0);
			}
			if (card.getUserid() != 0) {
				pStmt.setInt(2, card.getUserid());
			} else {
				pStmt.setInt(2, 0);
			}
			if (card.getDate() != null && !card.getDate().equals("")) {
				pStmt.setString(3, card.getDate());
			} else {
				pStmt.setDate(3, null);
			}
			if (card.getMealtime() != null && !card.getMealtime().equals("")) {
				pStmt.setString(4, card.getMealtime());
			} else {
				pStmt.setString(4, null);
			}
			if (card.getRecipeid() != 0) {
				pStmt.setInt(5, card.getRecipeid());
			} else {
				pStmt.setInt(5, 0);
			}
			if (card.getSavings() != 0) {
				pStmt.setInt(6, card.getSavings());
			} else {
				pStmt.setInt(6, 0);
			}

			// SQL文を実行する 1件だけ登録
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

}