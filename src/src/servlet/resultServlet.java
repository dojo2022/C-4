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
 * Servlet implementation class resultServlet
 */
@WebServlet("/resultServlet")
public class resultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインせずにサーブレットが起動されるとログインサーブレットへリダイレクト
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("allList");
		if (user == null) {
			response.sendRedirect("/EngelS/loginServlet");
			return;
		}

		//ユーザーアイコン部分：${user1.user}と${user1.name}を使えるようにする処理
		userDAO uDao = new userDAO();
		user user1 = uDao.select(user);
		request.setAttribute("user1",user1);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}