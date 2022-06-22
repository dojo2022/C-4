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
	public List<records> select(records param){
		Connection conn = null;
		List<records> recordList = new ArrayList<records>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する EL式
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する 改造ポイント 新しいテーブルを作るイメージ
			String sql =
			"SELECT RECORD.userid, RECORD.date,RECORD.mealtime, RECIPE.recipe,RECORD.savings, RECIPE.remarks FROM RECIPE INNER JOIN RECORD ON RECIPE.id = RECORD.recipeid WHERE RECORD.userid=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる ?にセッションスコープから取ってきたuseridの値を入れる
			if (param.getUserid() != 0) {
				pStmt.setInt(1, param.getUserid());
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする 繰り返し表現　取り出したデータを配列に
			while (rs.next()) {
				//Beansのインスタンスを生成
				records record = new records();
				//recipeAdd recipe = new recipeAdd();
				//↑records()の引数の要素を増やしたので使わなかった
				//実際に表示するデータを1つずつセット
				record.setUserid(rs.getInt("userid"));
				record.setDate(rs.getString("date"));
				record.setMealtime(rs.getString("mealtime"));
				record.setRecipe(rs.getString("recipe"));
				record.setSavings(rs.getInt("savings"));
				record.setRemarks(rs.getString("remarks"));
				recordList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			recordList = null;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			recordList = null;

		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					 recordList = null;
				}
			}
		}
		// 結果を返す
		return recordList;
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
			String sql = "insert into record(id, userid, date, mealtime, recipeid, savings) values "
					+ "(null, ?, ?, ?, select id from recipe where recipe=?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUserid() != 0) {
				pStmt.setInt(1, card.getUserid());
			} else {
				pStmt.setInt(1, 0);
			}
			if (card.getDate() != null && !card.getDate().equals("")) {
				pStmt.setString(2, card.getDate());
			} else {
				pStmt.setDate(2, null);
			}
			if (card.getMealtime() != null && !card.getMealtime().equals("")) {
				pStmt.setString(3, card.getMealtime());
			} else {
				pStmt.setString(3, null);
			}
			if (card.getRecipe() != null) {
				pStmt.setString(4, card.getRecipe());
			} else {
				pStmt.setInt(4, 0);
			}
			if (card.getSavings() != 0) {
				pStmt.setInt(5, card.getSavings());
			} else {
				pStmt.setInt(5, 0);
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

	//もし同じ日付が入っていた場合に使う更新用のdao
	public boolean update(records card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE record set recipeid= SELECT id FROM recipe WHERE recipe=?, savings=? WHERE userid=? AND date=? AND mealtime=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getRecipe() != null && !card.getRecipe().equals("")) {
				pStmt.setString(1, card.getRecipe());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getSavings() != 0) {
				pStmt.setInt(2, card.getSavings());
			}
			else {
				pStmt.setString(2, null);
			}
			if(card.getUserid() != 0) {
				pStmt.setInt(3, card.getUserid());
			}
			else {
				pStmt.setString(3, null);
			}
			if(card.getDate() != null && !card.getDate().equals("")) {
				pStmt.setString(4, card.getDate());
			}
			else {
				pStmt.setString(4, null);
			}
			if(card.getMealtime() != null && !card.getMealtime().equals("")) {
				pStmt.setString(5, card.getMealtime());
			}
			else {
				pStmt.setString(5, null);
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
}