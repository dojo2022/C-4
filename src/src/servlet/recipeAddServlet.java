//☆今後のタスク(6/15 14:30)：レシピ追加処理のResultモデルについて(6/15 14:30時点ではモデル未作成)
//現時点ではコメントアウトでResultモデルを停止中、今後は実装要検討
//46行目辺りのエラー解消する
//73行目：セッションスコープにユーザー情報を入れるタイミング確認

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
import dao.userDAO;
import model.recipeAdd;
import model.result;
import model.user;


@WebServlet("/recipeAddServlet")
public class recipeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションからユーザー情報を得る
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("allList");

		//検索条件の削除
		session.removeAttribute("searchterms");

		//ユーザーアイコン部分：${user1.user}と${user1.name}を使えるようにする処理
		userDAO uDao = new userDAO();
		user user1 = uDao.select(user);
		request.setAttribute("user1",user1);

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

		// レシピ追加処理を行う　☆メッセージ格納をsessionからrequestに変更中！
		recipeDAO bDao = new recipeDAO();
			if (bDao.insert(new recipeAdd(0, userid, recipe, cost, time, url, remarks ))){	// 登録成功
				//リクエストスコープに登録完了のメッセージを格納する
				session.setAttribute("result", (new result("", "レシピが追加できました！", "")));

				session.setAttribute("addrecipe", new recipeAdd(0, userid, recipe, cost, time, url, remarks));

				result result=(result)session.getAttribute("result");
				String msg = result.getMessage2();

				System.out.println(msg);

				// レシピ登録結果ページにフォワードする
				response.sendRedirect("/EngelS/resultServlet");
				/*移行中：画面遷移処理のみのため一時停止
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
				*/

				}
				else {	// 登録失敗の場合(レシピ追加ページにて追加失敗の表示)
					session.setAttribute("result", (new result("", "レシピを追加できませんでした。", "")));

					result result=(result)session.getAttribute("result");
					String msg = result.getMessage1();

					System.out.println(msg);

				/*移行中、追って消去
				request.setAttribute("result",
				new result("登録エラー", "レシピを追加できませんでした。", "/EngelS/recipeAddServlet"));
				*/

				//レシピ追加サーブレットにリダイレクトする
				response.sendRedirect("/EngelS/recipeAddServlet");
				}

				/*
				else { // 登録失敗
				request.setAttribute("result",
				new Result("登録エラー", "レコードを登録できませんでした。", "/WEB-INF/jsp/result.jsp"));
				}
				*/




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

		/*☆☆リザルトモデル利用前の正常起動コード(6/20 1300)
		// レシピ追加処理を行う
		//現時点ではResultモデルを消去し画面遷移のみ行う普通のフォワード処理にしている、else無し
		recipeDAO bDao = new recipeDAO();
			if (bDao.insert(new recipeAdd(0, userid, recipe, cost, time, url, remarks ))){	// 登録成功
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
				System.out.print("レシピ追加完了");
				}
		*/

	}



}
