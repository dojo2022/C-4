package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalDAO;
import model.goal;
import model.result;
import model.user;

/**
 * Servlet implementation class goalServlet
 */
@WebServlet("/goalServlet")
public class goalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 金額設定画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/goal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得できた！
		//カレンダーからは2022-06が取得→DAOのSQL文で日付まで入れる　できてない
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("allList");
		int userid = user.getId();
		String date = request.getParameter("date");
		int money = Integer.parseInt(request.getParameter("new_money"));
		System.out.println(userid);
		System.out.println(date);
		System.out.println(money);

		//goalDAOのインスタンスを生成
		goalDAO gDao = new goalDAO();

		//Daoのupdateメソッドを実行する(dateをString型にした)
		//戻り値がtrueだったら、更新処理完了
		//更新処理完了の処理とは更新しましたのメッセージと同じページへのリダイレクト
		//コンストラクタ　public result(String message1, String message2, String message3) {
		if(gDao.update(new goal(0,userid,date,money,0))) {
			// リクエストスコープにメッセージを格納する
			request.setAttribute("result", (new result("目標金額を更新しました。", "", "")));
			response.sendRedirect("/EngelS/goalServlet");
		}else if(gDao.insert(new goal(0,userid,date,money,0))){
			// リクエストスコープにメッセージを格納する
			request.setAttribute("result", (new result("目標金額を新規登録しました。", "", "")));
			response.sendRedirect("/EngelS/goalServlet");
		}else {
			response.sendRedirect("/EngelS/goalServlet");
			request.setAttribute("result", (new result("登録できませんでした", "", "")));
			//★カレンダーを日まで入れてしまったが一応出来た！Daoのinsert文を直した、、
		}
	}
}
