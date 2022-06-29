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

import dao.alertDAO;
import dao.goalDAO;
import dao.recipeDAO;
import dao.recordsDAO;
import dao.userDAO;
import model.alert;
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

		//ログインせずにサーブレットが起動されるとログインサーブレットへリダイレクト
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("allList");
		if (user == null) {
			response.sendRedirect("/EngelS/loginServlet");
			return;
		}

		//ユーザーIDを取得
		int userid = user.getId();

		//検索条件の初期化
		session.removeAttribute("searchterms");


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
		recordsDAO graphDao = new recordsDAO();
		//Beanを使わずに直接引数に検索条件を指定する。
		List<records> sample= graphDao.selectgraph(new records(0,userid, date, "", 0,0, "", ""));

		//グラフデータをリクエストスコープに格納
		request.setAttribute("graph", sample);


		//月の最終日を取得
		int daymax = cl.getActualMaximum(Calendar.DAY_OF_MONTH);

		//月の最終日をリクエストスコープに格納
		request.setAttribute("daymax", daymax);

		int Maxtime = 0;
		int Mintime = 0;

		//初めてホーム画面を表示したかを判定
		int onetime = (Integer)session.getAttribute("onetime");

		if(onetime == 0) {

			//時刻の取得
			//int hour = cl.get(Calendar.HOUR_OF_DAY);
			int hour = 6;

			//曜日の取得
			String[] WEEK = {"日", "月", "火", "水", "木", "金", "土"};
			int loginWeek = cl.get(Calendar.DAY_OF_WEEK)-1;

			//ユーザーのアラート設定を呼び出し
			alertDAO alDao = new alertDAO();
			alert days = alDao.select(new alert(0, userid, WEEK[loginWeek], 0, 0, 0, 0, 0, 0));

			//表示させるレシピの検索
			recipeDAO randomDao = new recipeDAO();
			List<recipeAdd> RecipeList = null;

			switch(hour) {
				case 6:
				case 7:
				case 8:
				case 9:
					Maxtime = days.getMorning_max();
					Mintime = days.getMorning_min();
					RecipeList= randomDao.randomSelect(userid, Maxtime, Mintime);
					//時刻をリクエストスコープに格納
					request.setAttribute("RecipeList", RecipeList);
					break;

				case 11:
				case 12:
				case 13:
					Maxtime = days.getLunch_max();
					Mintime = days.getLunch_min();
					RecipeList= randomDao.randomSelect(userid, Maxtime, Mintime);
					//時刻をリクエストスコープに格納
					request.setAttribute("RecipeList", RecipeList);
					break;

				case 18:
				case 19:
				case 20:
					Maxtime = days.getDinner_max();
					Mintime = days.getDinner_min();
					RecipeList= randomDao.randomSelect(userid, Maxtime, Mintime);
					//時刻をリクエストスコープに格納
					request.setAttribute("RecipeList", RecipeList);
					break;
			}


			//ログイン中に再度アラートさせないための処理
			onetime = 1;
			session.setAttribute("onetime", onetime);
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
