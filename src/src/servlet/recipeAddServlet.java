//☆今後のタスク(6/15 14:30)：レシピ追加処理のResultモデルについて(6/15 14:30時点ではモデル未作成)
//現時点ではコメントアウトでResultモデルを停止中、今後は実装要検討
//46行目辺りのエラー解消する

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.recipeDAO;
import model.recipeAdd;
import model.user;


@WebServlet("/recipeAddServlet")
public class recipeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// レシピ追加ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//セッションからユーザー情報を得る
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("allList");
		int userid = user.getId();


		//画面から入力情報を得る(ユーザーによるレシピ情報入力)

		String recipe = request.getParameter("recipe");
		//一度文字列としてcostを取ってくる
		String costStr = request.getParameter("cost");
		//文字列のcostをキャスト
		int cost = Integer.parseInt(costStr);

		String timeStr = request.getParameter("time");
		int time = Integer.parseInt(timeStr);

		String url = request.getParameter("url");
		String remarks = request.getParameter("remarks");

		//レシピ登録結果(result.jsp)へ移動用のビーンズ作成(rtRec…resultRecipeの略)
		recipeAdd rtRec = new recipeAdd(0, userid, recipe, cost, time, url, remarks);

		//result.jspへ表示させるためにリクエストスコープへ格納(☆"cardList"のままで起動するか要確認)
		request.setAttribute("cardList", rtRec);

		//セッションスコープにユーザーIDを格納
		session.getAttribute(request.getParameter("userid"));

		// レシピ追加処理を行う
		//現時点ではResultモデルを消去し画面遷移のみ行う普通のフォワード処理にしている、else無し
		recipeDAO bDao = new recipeDAO();
			if (bDao.insert(new recipeAdd(0, userid, recipe, cost, time, url, remarks ))){	// 登録成功
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
				System.out.print("レシピ追加完了");
				}
				/*
				else { // 登録失敗
				request.setAttribute("result",
				new Result("登録エラー", "レコードを登録できませんでした。", "/WEB-INF/jsp/result.jsp"));
				}
				*/

		// レシピ登録結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);


		/*元のコード保留中(6/15 13:45)　Resultモデルがある場合の処理
		// レシピ追加処理を行う
				recipeDAO bDao = new recipeDAO();
					if (bDao.insert(new recipeAdd(userid, recipe, cost, time, url, remarks ))){	// 登録成功
						request.setAttribute("result",
						new Result("登録完了", "レコードを登録しました。", "/EngelS/MenuServlet"));
						}
						else {												// 登録失敗
						request.setAttribute("result",
						new Result("登録エラー", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
						}

				// レシピ登録結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
		*/
	}



}
