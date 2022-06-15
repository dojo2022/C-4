package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.goal;

public class goalDAO {
	// 引数paramで指定されたレコードを登録し、成功したらtrueを返す OK
	public boolean insert(goal param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む OK
			Class.forName("org.h2.Driver");

			// データベースに接続する OK
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する 多分OK
			String sql = "insert into goal (id,userid,date,money,sum) values (?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 多分OK
			if (param.getId() != 0) {
				pStmt.setString(1, "%" + param.getId() + "%");
			} else {
				pStmt.setString(1, "%");
			}

			if (param.getUserid() != 0) {
				pStmt.setString(2, "%" + param.getUserid() + "%");
			} else {
				pStmt.setString(2, "%");
			}

			if (param.getDate() != null) {
				pStmt.setString(3, "%" + param.getDate() + "%");
			} else {
				pStmt.setString(3, "%");
			}

			if (param.getMoney() != 0) {
				pStmt.setString(4, "%" + param.getMoney() + "%");
			} else {
				pStmt.setString(4, "%");
			}

			if (param.getSum() != 0) {
				pStmt.setString(5, "%" + param.getSum() + "%");
			} else {
				pStmt.setString(5, "%");
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

	// 引数paramで指定されたレコードを更新し、成功したらtrueを返す OK
	public boolean update(goal param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む OK
			Class.forName("org.h2.Driver");

			// データベースに接続する OK
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する ★sum以降を節約金額を取ってきて合計する文にした dateには1日が入ればその月のすべての合計になる
			String sql = "UPDATE goal set money=?,sum=SELECT SUM(savings) FROM record WHERE userid=? WHERE userid=? AND date>=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//money=?
			if (param.getMoney() != 0) {
				pStmt.setInt(1, param.getMoney());
			}
			else {
				pStmt.setInt(1, 0);
			}
			//userid=?(sumの中のやつ)
			if (param.getUserid() != 0) {
				pStmt.setInt(2, param.getUserid());
			}
			else {
				pStmt.setInt(2, 0);
			}
			//userid=?(sumの外のやつ)
			if (param.getUserid() != 0) {
				pStmt.setInt(3, param.getUserid());
			}
			else {
				pStmt.setInt(3, 0);
			}
			//date=?
			if (param.getDate() != null) {
				pStmt.setDate(4, param.getDate());
			}
			else {
				pStmt.setDate(4, null);
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
