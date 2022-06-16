package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.goal;

public class goalDAO {
	public List<goal> select(goal param) {
		Connection conn = null;
		List<goal> cardList = new ArrayList<goal>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する EL式
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する 改造ポイント
			//param.getOrder();
			String sql = "SELECT * FROM goal WHERE userid=? and date=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);



			// SQL文を完成させる 改造ポイント
			if (param.getId() != 0) {
				pStmt.setInt(1, param.getId());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getUserid() != 0) {
				pStmt.setInt(2, param.getUserid());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getDate() != null) {
				pStmt.setDate(3, param.getDate());
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getMoney() != 0) {
				pStmt.setInt(4, param.getMoney());
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getSum() != 0) {
				pStmt.setInt(5, param.getSum());
			}
			else {
				pStmt.setString(5, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする 繰り返し表現　取り出したデータを配列に
			while (rs.next()) {
				goal card = new goal(
				rs.getInt("id"),
				rs.getInt("userid"),
				rs.getDate("date"),
				rs.getInt("money"),
				rs.getInt("sum")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
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
			//記録したのはついたちということに強制的になる。理由は更新のSQL文参照
			String sql = "insert into goal (id,userid,date,money,sum) values (?,?,concat('?' ,'-01'),?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

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

			// SQL文
			//カレンダーからは'2022-06'しか取ってこれない。なのでCONCAT関数で'-01'を連結！！
			//そうすると常にその月の１日のデータを上書きすることになる。
			String sql = "UPDATE goal set money=?,sum=SELECT SUM(savings) FROM record WHERE userid=? WHERE userid=? AND date=concat('?' ,'-01')";
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
