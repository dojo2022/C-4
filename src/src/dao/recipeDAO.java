//(☆後日タスク：レシピ一覧と照らし合わせて確認)
//☆32行目セレクト文
//①検索部分、WHERE、LIKEをどうするか確認→レシピ名と備考を検索対象にした(6/15時点)
//②末尾ORDER BYをどうするか確認(結果例：レシピ名の名前順、費用)
//☆42～78の％表示：数値部分もそのままでよいのか確認

//保留事項(現状エラー等問題なし。何かあれば確認する箇所)
//22、90～109行目：cardList、cardの名称は変更するかどうか→そのまま継続
//35行目セレクト：％の部分→String型で問題なし。何かあれば再度確認

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.recipeAdd;

public class recipeDAO {

		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<recipeAdd> select(recipeAdd param) {
			Connection conn = null;
			List<recipeAdd> cardList = new ArrayList<recipeAdd>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

				// SQL文を準備する
				//検索ボックスにてヒットする項目…レシピ名、備考
				//(費用・所要時間などの数値はソートで取り扱うので対象外。URLも対象外にする)
				String sql = "select Id, Userid, Recipe, Cost, Time, Url, Remarks from Recipe WHERE (userid = ? or userid = 0) and (recipe like ? or remarks like ?) and recipe != '外食'"; //WHEREをどうするか確認
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				if (param.getUserid() != 0) {

					pStmt.setInt(1, param.getUserid());
				}
				else {
					pStmt.setString(1, "%");
				}

				if (param.getRecipe() != "") {

					pStmt.setString(2, "%" + param.getRecipe() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}

				if (param.getRemarks() != "") {

					pStmt.setString(3, "%" + param.getRemarks() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}



				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					recipeAdd card = new recipeAdd(
					rs.getInt("id"),
					rs.getInt("userid"),
					rs.getString("recipe"),
					rs.getInt("cost"),
					rs.getInt("time"),
					rs.getString("url"),
					rs.getString("remarks")
					);
					cardList.add(card);
				}
			}//23行目try文の閉じ
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
			System.out.print("結果を返す");
			return cardList;

		}//19行目public List～の閉じ



		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(recipeAdd recipeAdd) {

			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む INSERT INTO recipe VALUES(null, ?, ?, ?, ?, ?, ?);
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6_data/C4", "sa", "");

				// SQL文を準備する
				//☆これで確定のはず！自動追加のidはinsert(の中でid削除)、?マーク一つ消して6個にしている(6/20 10:15)		set***の第1引数に指定		1, 2, 3  4, 5, 6, 7
				String sql = "insert into recipe (userid, recipe, cost, time, url, remarks) values (?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

				if (recipeAdd.getUserid() != 0) {
					pStmt.setInt(1, recipeAdd.getUserid());
				}
				else {
					pStmt.setString(1, "");
				}
				if (recipeAdd.getRecipe() != null) {
					pStmt.setString(2, recipeAdd.getRecipe());
				}
				else {
					pStmt.setString(2, "");
				}
				if (recipeAdd.getCost() != 0) {
					pStmt.setInt(3, recipeAdd.getCost());
				}
				else {
					pStmt.setString(3, "");
				}
				if (recipeAdd.getTime() != 0) {
					pStmt.setInt(4, recipeAdd.getTime());
				}
				else {
					pStmt.setString(4, "");
				}
				if (recipeAdd.getUrl() != null && !recipeAdd.getUrl().equals("")) {
					pStmt.setString(5, recipeAdd.getUrl());
				}
				else {
					pStmt.setString(5, "");
				}
				if (recipeAdd.getRemarks() != null && !recipeAdd.getRemarks().equals("")) {
					pStmt.setString(6, recipeAdd.getRemarks());
				}
				else {
					pStmt.setString(6, "");
				}


				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}//18行目 try～の閉じ
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
			}//87行目 finally～の閉じ

			// 結果を返す
			System.out.print("結果を返す");
			return result;

		}//13行目 public boolean～の閉じ


		//アラートで使用するレシピ検索
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



}//10行目DAOの閉じ
