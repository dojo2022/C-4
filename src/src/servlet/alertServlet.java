package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.alertDAO;
import model.alert;
import model.result;
import model.user;

/**
 * Servlet implementation class alertServlet
 */
@WebServlet("/alertServlet")
public class alertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/alert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//各nameから情報を取る
		user user = (user) session.getAttribute("allList");
		int userid = user.getId();
		String days = request.getParameter("days");
		int morning_min = Integer.parseInt(request.getParameter("morning_min"));
		int lunch_min = Integer.parseInt(request.getParameter("lunch_min"));
		int dinner_min = Integer.parseInt(request.getParameter("dinner_min"));
		int morning_max = Integer.parseInt(request.getParameter("morning_max"));
		int lunch_max = Integer.parseInt(request.getParameter("lunch_max"));
		int dinner_max = Integer.parseInt(request.getParameter("dinner_max"));

		//るーぷ

		// 更新を行う

		alertDAO bDao = new alertDAO();
		if (request.getParameter("SUBMIT").equals("確定")) {
			if (bDao.update(new alert(0, userid, days, morning_min, lunch_min, dinner_min, morning_max, lunch_max,
					dinner_max))) {
				request.setAttribute("result",
						new result("", "", "/EngelS/homeServlet"));
			}
			else { // 更新失敗
			request.setAttribute("result",
					new result("", "", ""));
					// 結果ページにフォワードする
			}

		}
	}
}
