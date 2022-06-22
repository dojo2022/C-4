package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.goal;

public class goalDAO {
	public goal select(int id, int userid, String date, int money, int sum) {
		Connection conn = null;
		//Beansのインスタンスを生成(g)
		goal g;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM goal WHERE userid=? and date=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる 改造ポイント
			pStmt.setInt(1, userid );
			pStmt.setString(2, date );

			// SQL文を実行し、rsという結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//rsから結果を取り出す
			rs.next();
			g= new goal(
					rs.getInt("id"),
					rs.getInt("userid"),
					rs.getString("date"),
					rs.getInt("money"),
					rs.getInt("sum")
			);
		}
		catch (SQLException e) {
			e.printStackTrace();
			g = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			g = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					g = null;
				}
			}
		}
		// 結果を返す
		return g;
	}

	public boolean insert(goal param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む OK
			Class.forName("org.h2.Driver");

			// データベースに接続する OK
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する
			String sql = "INSERT into goal (userid,date,money,sum) values (?,?,?,SELECT SUM(savings) FROM record WHERE userid=? AND date>=?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (param.getUserid() != 0) {
				pStmt.setInt(1, param.getUserid());
			} else {
				pStmt.setInt(1, 0);
			}

			if (param.getDate() != null) {
				pStmt.setString(2,param.getDate()+"-01");
			} else {
				pStmt.setString(2, null);
			}

			if (param.getMoney() != 0) {
				pStmt.setInt(3,param.getMoney());
			} else {
				pStmt.setInt(3, 0);
			}

			if (param.getUserid() != 0) {
				pStmt.setInt(4,param.getUserid());
			} else {
				pStmt.setInt(4, 0);
			}

			if (param.getDate() != null) {
				pStmt.setString(5,param.getDate()+"-01");
			} else {
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


	// 引数paramで指定されたレコードを更新し、成功したらtrueを返す OK
	public boolean update(goal param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む OK
			Class.forName("org.h2.Driver");

			// データベースに接続する OK
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文
			String sql = "UPDATE goal set money=?,sum=SELECT SUM(savings) FROM record WHERE userid=? AND date>=? WHERE userid=? AND date=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getMoney() != 0) {
				pStmt.setInt(1, param.getMoney());
			}
			else {
				pStmt.setInt(1, 0);
			}
			if (param.getUserid() != 0) {
				pStmt.setInt(2, param.getUserid());
			}
			else {
				pStmt.setInt(2, 0);
			}
			if (param.getDate() != null) {
				pStmt.setString(3, param.getDate()+"-01");
			}
			else {
				pStmt.setInt(3, 0);
			}
			if (param.getUserid() != 0) {
				pStmt.setInt(4, param.getUserid());
			}
			else {
				pStmt.setInt(4, 0);
			}
			if (param.getDate() != null) {
				pStmt.setString(5, param.getDate()+"-01");
			}
			else {
				pStmt.setDate(5, null);
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