package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.record_note;

public class record_noteDAO {
	public List<record_note> list() {
		List<record_note> cardList = new ArrayList<record_note>();

		return cardList;
	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す。
	//アクセス修飾子 戻り値　メソッド名(引数) {
	public List<record_note> select(record_note param) {
		Connection conn = null;
		List<record_note> cardList = new ArrayList<record_note>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");


			String sql = "select * from record_note where userid = ? and date = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (param.getUserid() != 0) {
				pStmt.setInt(1,  param.getUserid() );
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getDate() != null) {
				pStmt.setString(2, param.getDate());
			} else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				record_note card = new record_note(
						rs.getInt("id"),
						rs.getInt("userid"),
						rs.getString("date"),
						rs.getString("remarks")
				);
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

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(record_note card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する（ここも改造が必要）
			String sql = "insert into record_note (id, userid, date, remarks) values (null, ?, ?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUserid() != 0) {
				pStmt.setInt(1, card.getUserid());
			} else {
				pStmt.setString(1, null);
			}

			if (card.getDate() != null) {
				pStmt.setString(2, card.getDate());
			} else {
				pStmt.setString(2, null);

			}

			if (card.getRemarks() != null && !card.getRemarks().equals("")) {
				pStmt.setString(3, card.getRemarks());
			} else {
				pStmt.setString(3, null);

			}

			// SQL文を実行する。一件登録しているから　＝＝が１になっている。
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
 //更新機能はないので、コメントアウト。もし追加するってなったら、コメント外して使う。（06/15)
 public boolean update(record_note card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する（ここも改造させる）	whereで検索条件を　指定。
			String sql = "UPDATE record_note set remarks=? WHERE userid=? AND date=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる（改造する。項目が増えるはずだからね）

			if (card.getRemarks() != null) {
				pStmt.setString(1, card.getRemarks());
			} else {
				pStmt.setString(1, null);
			}
			if (card.getUserid() != 0) {
				pStmt.setInt(2, card.getUserid());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getDate() != null && !card.getRemarks().equals("")) {
				pStmt.setString(3, card.getDate());
			} else {
				pStmt.setString(3, null);
			}

			// SQL文を実行する
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



	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	//public void delete(String NUMBER) {
	public boolean delete(String id) {
		//型			変数名 = 初期値;
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SQL文を準備する。下にNUMBERが来ているが、消すときはNUMBERの情報だけで十分であることがわかる。
			String sql = "delete from BC where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//			int a = Integer.parseInt("123");

			// SQL文を完成させる
			pStmt.setString(1, id);
			// delete from BC where NUMBER='0006'

			//			pStmt.setString(1, "id");
			//			pStmt.setString(2, "userid");
			//			pStmt.setString(3, "date");
			//			pStmt.setString(4, "remarks");

			// SQL文を実行する
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

