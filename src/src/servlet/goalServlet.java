package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		request.setCharacterEncoding("UTF-8");

		//useridをセッションスコープから取得し変数useridに代入
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("allList");
		int userid = user.getId();

		//今ログインしている年月を取得し変数dateに代入
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String date = sdf.format(cl.getTime())+"-01";

		//DAOのインスタンスを生成
		goalDAO gDao = new goalDAO();

		//削減金額再計算
		gDao.sumup(new goal(0,userid,date,0,0));

		//検索をかけ変数goalに検索結果を代入
		goal goal= gDao.select(0,userid, date,0,0);

		// 検索結果をリクエストスコープに格納
		request.setAttribute("goal", goal);

		// 金額設定画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/goal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// リクエストパラメータを取得できた！
			//カレンダーからは2022-06が取得→SQL文を完成させるところで"-01"結合
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			user user = (user) session.getAttribute("allList");
			int userid = user.getId();
			String date = request.getParameter("date");
			int money = Integer.parseInt(request.getParameter("new_money"));

			//goalDAOのインスタンスを生成
			goalDAO gDao = new goalDAO();

			if(gDao.update(new goal(0,userid,date,money,0))) {
				//セッションスコープにメッセージを格納する
				session.setAttribute("result", (new result("", "", "目標金額を更新しました。")));
				//ゴールサーブレットにリダイレクトする
				response.sendRedirect("/EngelS/goalServlet");
			}else if(gDao.insert(new goal(0,userid,date,money,0))) {
				session.setAttribute("result", (new result("", "", "新規目標金額を設定しました。")));
				response.sendRedirect("/EngelS/goalServlet");
			}else{
				session.setAttribute("result", (new result("", "", "※月を設定してください！")));
				response.sendRedirect("/EngelS/goalServlet");
			}
		}
		catch (NumberFormatException e) {
			HttpSession session = request.getSession();
			session.setAttribute("result", (new result("", "", "※数字を入力してください！")));
			response.sendRedirect("/EngelS/goalServlet");
		}
		finally {

		}
	}
}

