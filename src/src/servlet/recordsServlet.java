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
import dao.record_noteDAO;
import dao.recordsDAO;
import model.goal;
import model.recipeAdd;
import model.record_note;
import model.records;
import model.result;
import model.user;

/**
 * Servlet implementation class recordServlet
 */
@WebServlet("/recordsServlet")
public class recordsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//recipeAddからレシピ名とcostをSELECTする
		request.setCharacterEncoding("UTF-8");

		//セッションスコープからuseridを取り出す
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("allList");
		int userid = user.getId();

		// 検索処理を行う
		recordsDAO bDao = new recordsDAO();
		List<recipeAdd> cardList = bDao
				.select(new recipeAdd(0, userid, "", 0, 0, "", ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		//以下は別の処理
		//1か月の日にちをあらかじめ求める処理
		Calendar cls = Calendar.getInstance();
		int dayBig = cls.getActualMaximum(Calendar.DAY_OF_MONTH);

		//	目標金額をalertから持ってくる処理
		//今ログインしている年月を取得し変数dateに代入
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String date = sdf.format(cl.getTime()) + "-01";

		//DAOのインスタンスを生成
		goalDAO gDao = new goalDAO();
		//Beanを使わずに直接引数に検索条件を指定する。
		goal goal = gDao.select(0, userid, date, 0, 0);

		// 検索結果をリクエストスコープに格納する
		//★セッションスコープじゃないといけない、、？
		request.setAttribute("goal", goal);

		//今月の目標金額をgetする
		goal goals = (goal) session.getAttribute("goal");
		int goal_money = goal.getMoney();

		//とりあえずdayBigする
		int money = goal_money / dayBig;

		//リクエストスコープに割ったものを保存させる。
		request.setAttribute("money", money);

		//recordsjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/records.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//日々の食事記録を登録

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		//セッションスコープからuseridを取る
		user user = (user) session.getAttribute("allList");
		int userid = user.getId();

		//リクエストスコープから、日付を取得
		String date = request.getParameter("date");

		//リクエストスコープから、ミールタイプ＋レシピ＋金額を３食事分
		//	※レシピ＋金額は食事ごとに複数データの可能性あり
		//ArrayListにしたが、コンストラクタなどもすべて変更するか？
		//mealtimeを取得
		String[] mealtime = request.getParameterValues("mealtime");
		String[] recipe = request.getParameterValues("recipe");
		String[] savings = request.getParameterValues("savings");

		//リクエストスコープから、備考を取得　忘れないようにする
		String remarks = request.getParameter("remarks");

		// 登録処理を行う
		recordsDAO bDao = new recordsDAO();
		if (request.getParameter("SUBMIT").equals("登録する")) {
			for (int i = 0; i < mealtime.length; i++) {
				if (bDao.records_insert(
						new records(0, userid, date, mealtime[i], 0, Integer.parseInt(savings[i]), recipe[i], ""))) { // 登録成功
					/*request.setAttribute("",
							new Result("登録成功！", "レコードを登録しました。", "/EngelS/homeServlet"));*/
				} else { // 登録失敗
					request.setAttribute("result",
							new result("登録失敗！", "レコードを登録できませんでした。", "/EngelS/Servlet"));
					//↑result.jsp作ったらコメントアウト外す
				}
			}

			//備考登録作業
			record_noteDAO cDao = new record_noteDAO();
			if (cDao.insert(new record_note(0, userid, date, remarks))) {

			}
			// ホームサーブレットにリダイレクトする 備考も含め完全に登録することができたら…
			response.sendRedirect("/EngelS/homeServlet");
		}
	}
}
