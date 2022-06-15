package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.user;

public class userDAO {

	public List<user> select(user param) {
		Connection conn = null;
		List<user> cardList = new ArrayList<user>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SELECT文を準備する
			String sql = "select * from user where user = ? and pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,param.getUser());
			pStmt.setString(2,param.getPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				user card = new user(
				rs.getInt("ID"),
				rs.getString("user"),
				rs.getString("name"),
				rs.getString("pw")
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

	// ログインできるならtrueを返す
	public boolean isLoginOK(user user) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from user where user = ? and pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,user.getUser());
			pStmt.setString(2,user.getPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}


		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	//新規ユーザー登録
	public boolean newuser(user user) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from user where user = ? and pw = ?";
			PreparedStatement newuser = conn.prepareStatement(sql);
			newuser.setString(1,user.getUser());
			newuser.setString(2,user.getPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = newuser.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				result = false;
			} else {
				String Resql = "INSERT INTO IDPW (ID, PW) VALUES (?, ?)";
				PreparedStatement signup = conn.prepareStatement(Resql);
				signup.setString(1, user.getUser());
				signup.setString(2,user.getPw());

				signup.executeUpdate();
				result = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}

		// 結果を返す
		return result;
	}

	//パスワード変更
		public boolean newpw(user user) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

				// SELECT文を準備する
				String sql = "select count(*) from user where user = ? and pw = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,user.getUser());
				pStmt.setString(2,user.getPw());

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					result = false;
				} else {
					String Resql = "UPDATE user SET pw=? WHERE user=?";
					PreparedStatement newpw = conn.prepareStatement(Resql);
					newpw.setString(1, user.getPw());
					newpw.setString(2,user.getUser());

					newpw.executeUpdate();
					result = true;
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				result = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = false;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = false;
					}
				}
			}

			// 結果を返す
			return result;
		}
}
