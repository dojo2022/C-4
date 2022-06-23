package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.recipeAdd;
import model.records;

public class testDAO {
	public List<records> select(records graph) {
		Connection conn = null;
		List<records> sample = new ArrayList<records>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "select record.date, sum(savings) from record, goal where record.userid=? and ?<=record.date group by record.date;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 改造ポイント
			pStmt.setInt(1, graph.getUserid() );
			pStmt.setString(2, graph.getDate() );

			// SQL文を実行し、rsという結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//rsから結果を取り出す
			while(rs.next()) {
				records g= new records(
						0,
						0,
						rs.getString("date"),
						"",
						0,
						rs.getInt("sum(savings)"),
						"",
						""
				);
				sample.add(g);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			sample = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			sample = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					sample = null;
				}
			}
		}
		// 結果を返す
		return sample;
	}


	public List<recipeAdd> randomSelect(recipeAdd randomRecipe) {
		Connection conn = null;
		List<recipeAdd> sample = new ArrayList<recipeAdd>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "select recipe from recipe where (userid = 0 or userid = ?) and time <= ? and recipe != '外食';";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 改造ポイント
			pStmt.setInt(1, randomRecipe.getUserid() );
			pStmt.setInt(2, randomRecipe.getTime() );

			// SQL文を実行し、rsという結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//rsから結果を取り出す
			while(rs.next()) {
				recipeAdd RL= new recipeAdd(
						0,
						0,
						rs.getString("recipe"),
						0,
						0,
						"",
						""
				);
				sample.add(RL);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			sample = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			sample = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					sample = null;
				}
			}
		}
		// 結果を返す
		return sample;
	}

}
