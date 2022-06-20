package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDAO;
import model.result;
import model.user;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("allList");

		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pw = request.getParameter("pw");

		// ログイン処理を行う
		userDAO iDao = new userDAO();
		HttpSession session = request.getSession();
		if (iDao.isLoginOK(new user(0, user, "", pw))) {	// ログイン成功
			userDAO dao = new userDAO();
			user cardList = dao.select(new user(0, user, "", pw));

			// セッションスコープにIDを格納する
			session.setAttribute("allList", cardList);


			// ホームサーブレットにリダイレクトする
			response.sendRedirect("/EngelS/homeServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープにメッセージを格納する
			session.setAttribute("result", (new result("", "ログインに失敗しました。", "")));

			result result=(result)session.getAttribute("result");
			String msg = result.getMessage2();

			System.out.println(msg);
			// ログインサーブレットにリダイレクトする
			response.sendRedirect("/EngelS/loginServlet");
		}


	}

}
