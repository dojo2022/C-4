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

		//検索条件の初期化
		HttpSession session = request.getSession();
		session.removeAttribute("searchterms");
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
		String[] days = new String[7];
		days[0] = request.getParameter("Mon");
		days[1] = request.getParameter("Tue");
		days[2] = request.getParameter("Wed");
		days[3] = request.getParameter("Thu");
		days[4] = request.getParameter("Fri");
		days[5] = request.getParameter("Sat");
		days[6] = request.getParameter("Sun");
		int morning_min = Integer.parseInt(request.getParameter("morning_min"));
		int lunch_min = Integer.parseInt(request.getParameter("lunch_min"));
		int dinner_min = Integer.parseInt(request.getParameter("dinner_min"));
		int morning_max = Integer.parseInt(request.getParameter("morning_max"));
		int lunch_max = Integer.parseInt(request.getParameter("lunch_max"));
		int dinner_max = Integer.parseInt(request.getParameter("dinner_max"));
		int count = 0;
		int err = 0;
		//るーぷ

		// 更新を行う

		alertDAO bDao = new alertDAO();
		if (request.getParameter("SUBMIT").equals("確定")) {
			for(int i = 0; i < 7; i++) {
				if(days[i] != null) {
					if (bDao.update(new alert(0, userid, days[i], morning_min, lunch_min, dinner_min, morning_max, lunch_max,
							dinner_max))) {
						count++;
					} else if (bDao.insert(new alert(0, userid, days[i], morning_min, lunch_min, dinner_min, morning_max, lunch_max,
							dinner_max))){
						count++;
					}else {
						err++;
					}
				}
			}

			if(err > 0) {
				session.setAttribute("result",new result(count + err + "つ中、" + err + "つのアラート設定に失敗しました。", "", ""));
			} else {
				session.setAttribute("result",new result(count + "つのアラート設定を行いました。", "", ""));
			}
			response.sendRedirect("/EngelS/alertServlet");
		}
		//request.setAttribute("result",new result("", "", ""));
		// 結果ページにフォワードする

	}
}
