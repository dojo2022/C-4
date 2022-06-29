package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.alertDAO;
import dao.userDAO;
import model.alert;
import model.result;
import model.user;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");

		// ログイン処理を行う
		userDAO iDao = new userDAO();
		if (iDao.newuser(new user(0, user, name, pw))) {	// 登録成功時
			// リクエストスコープにメッセージを格納する
			request.setAttribute("result", (new result("", "", "登録に成功しました。")));

			//デフォルトのアラート設定
			alertDAO alDao = new alertDAO();
			String[] WEEK = {"日", "月", "火", "水", "木", "金", "土"};
			user registdate = iDao.select(new user(0, user, name, pw));
			int id = registdate.getId();

			for(int i=0; i < 7; i++) {
				alDao.insert(new alert(0, id, WEEK[i], 0, 0, 0, 5, 5, 5));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);

		} else {
			// リクエストスコープにメッセージを格納する
			request.setAttribute("result", (new result("既に登録されています。", "", "")));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);

		}
	}

}
