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


		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("allList");
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



		// Step 2:
		recipeDAO eDao = new recipeDAO();
		List <recipeAdd> rs = eDao.select(new recipeAdd(0, userid, "", 0, 0, "", ""));

		// Step 3:
		//午後解説ここから
		request.setAttribute("recipe", rs);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeSearch.jsp");
		dispatcher.forward(request, response);




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);



	}



	}

//}
//servletはa connector of "model" and "view". it is the "c" of MVC.
//