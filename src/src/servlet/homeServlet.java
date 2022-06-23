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
import dao.userDAO;
import model.goal;
import model.recipeAdd;
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

		//useridをセッションスコープから取得
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("allList");
		int userid = user.getId();


		//今ログインしている年月を取得し変数dateに代入
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String date = sdf.format(cl.getTime())+"-01";


		//${user1.user}と${user1.name}を使えるようにする処理
		userDAO uDao = new userDAO();
		user user1 = uDao.select(user);
		request.setAttribute("user1",user1);


		//DAOのインスタンスを生成
		goalDAO gDao = new goalDAO();
		//削減金額再計算
		gDao.sumup(new goal(0,userid,date,0,0));
		//Beanを使わずに直接引数に検索条件を指定する。
		goal goal= gDao.select(0,userid, date,0,0);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("goal", goal);


		//グラフデータの作成
		//DAOのインスタンスを生成
		testDAO graphDao = new testDAO();
		//Beanを使わずに直接引数に検索条件を指定する。
		List<records> sample= graphDao.select(new records(0,userid, date, "", 0,0, "", ""));

		//グラフデータをリクエストスコープに格納
		request.setAttribute("graph", sample);


		//月の最終日を取得
		int daymax = cl.getActualMaximum(Calendar.DAY_OF_MONTH);

		//月の最終日をリクエストスコープに格納
		request.setAttribute("daymax", daymax);


		//時刻の取得
		int hour = cl.get(Calendar.HOUR_OF_DAY);
		int time = 0;

		//初めてホーム画面を表示したかを判定
		int onetime = (Integer)session.getAttribute("onetime");

		if(onetime == 0) {
			switch(hour) {
				case 6:
				case 7:
				case 8:
				case 9:
					time = 10;
					break;

				case 11:
				case 12:
				case 13:
					time = 5;
					break;

				case 18:
				case 19:
				case 20:
					time = 15;
					break;
			}


			//表示させるレシピの検索
			testDAO randomDao = new testDAO();
			List<recipeAdd> RecipeList= randomDao.randomSelect(new recipeAdd(0,userid, "", 0, time, "", ""));

			//ログイン中に再度アラートさせないための処理
			onetime = 1;
			session.setAttribute("onetime", onetime);

			//時刻をリクエストスコープに格納
			request.setAttribute("RecipeList", RecipeList);
		}

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
