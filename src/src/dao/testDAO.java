package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.records;

public class testDAO {
	public List<records> select(int id, int userid, String date, int money, int sum, String recipe) {
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
			pStmt.setInt(1, userid );
			pStmt.setString(2, date );

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

}
