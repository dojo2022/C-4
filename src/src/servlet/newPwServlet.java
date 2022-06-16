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
import model.user;

/**
 * Servlet implementation class newPwServlet
 */
@WebServlet("/newPwServlet")
public class newPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newPw.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("allList");
		int userid = user.getId();
		String pw = request.getParameter("newpw");

		// ログイン処理を行う
		userDAO iDao = new userDAO();
		if (iDao.newpw(new user(userid, "", "",pw))) {
			//request.setAttribute("result", (new Result("", "登録に成功しました。", "", "", "")));

			// ホームサーブレットにリダイレクトする
			response.sendRedirect("/EngelS/showPwServlet");

		} else {
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			//request.setAttribute("result", (new Result("", "既に登録されています。", "", "", "")));

			// ホームサーブレットにリダイレクトする
			response.sendRedirect("/EngelS/newPwServlet");

		}

	}

}
