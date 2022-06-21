package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalDAO;
import dao.testDAO;
import model.goal;
import model.records;
import model.user;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
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
		//Beanを使わずに直接引数に検索条件を指定する。
		goal goal= gDao.select(0,userid, date,0,0);

		// 検索結果をリクエストスコープに格納する
		//★セッションスコープじゃないといけない、、？
		request.setAttribute("goal", goal);

		//グラフデータの作成
		//DAOのインスタンスを生成
		testDAO graphDao = new testDAO();
		//Beanを使わずに直接引数に検索条件を指定する。
		List<records> sample= graphDao.select(0,userid, date,0,0, "");

		//グラフデータをリクエストスコープに格納
		request.setAttribute("graph", sample);

		//月の最終日を取得
		int daymax = cl.getActualMaximum(Calendar.DAY_OF_MONTH);

		//月の最終日をリクエストスコープに格納
		request.setAttribute("daymax", daymax);

		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
