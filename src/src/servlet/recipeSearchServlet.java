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

import dao.recipeDAO;
import dao.userDAO;
import model.recipeAdd;
import model.user;

/**
 * Servlet implementation class recipeSearchServlet
 */
@WebServlet("/recipeSearchServlet")
public class recipeSearchServlet extends HttpServlet {
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

		//ユーザーIDを取得
		int userid = user.getId();


		//${user1.user}と${user1.name}を使えるようにする処理
		userDAO uDao = new userDAO();
		user user1 = uDao.select(user);
		request.setAttribute("user1",user1);


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		/*
		 * Servlet processing:
		 *     Step 1:   Get data from the request
		 *     Step 2.1: Use model/Dao classes to retreieve recipe information from database.
		 *     Step 2.2: Do any processing that is needed on the retreived data.
		 *     Step 3:   Send the data as a response
		 */

		recipeAdd searchterms = (recipeAdd)session.getAttribute("searchterms");

		String recipe = "";
		String remarks = "";

		if(searchterms != null) {
			recipe = searchterms.getRecipe();
			remarks = searchterms.getRemarks();
		}


		// Step 2:
		recipeDAO sDao = new recipeDAO();
		//List <recipeAdd> rs = eDao.select(new recipeAdd(0, userid, "", 0, 0, "", ""));
		List<recipeAdd> searchList = sDao.select(new recipeAdd(0, userid, recipe, 0, 0, "", remarks));

		//検索ヒット数を保存
		int Listcount = searchList.size();
		System.out.println(Listcount);

		// Step 3:
		request.setAttribute("recipe", searchList);
		request.setAttribute("Listcount", Listcount);


		//検索時以外の検索結果欄の非表示化

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeSearch.jsp");
		dispatcher.forward(request, response);




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		//検索条件を取得
		String recipe = request.getParameter("query");
		String remarks = request.getParameter("query");

		//検索条件をセッションスコープに保存
		recipeAdd searchterms = new recipeAdd(0, 0, recipe, 0, 0, "", remarks);

		HttpSession session = request.getSession();
		session.setAttribute("searchterms", searchterms);

		//検索結果欄の表示
		int change = 1;
		session.setAttribute("change", change);

		// recipeSearchServletにリダイレクトする
		response.sendRedirect("/EngelS/recipeSearchServlet");


	}




}
//servletはa connector of "model" and "view". it is the "c" of MVC.
//