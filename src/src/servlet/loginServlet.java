package servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		if (iDao.isLoginOK(new user(0, user, "", pw))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();

			userDAO dao = new userDAO();
			List<user> cardList = dao.select(new user(0, user, "", pw));
			session.setAttribute("allList", cardList);

			// ホームサーブレットにリダイレクトする
			response.sendRedirect("/EngelS/homeServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			//request.setAttribute("result", (new Result("", "IDまたはPWに間違いがあります。", "", "", "")));
			// ログインサーブレットにリダイレクトする
			response.sendRedirect("/EngelS/loginServlet");
		}


	}

}
