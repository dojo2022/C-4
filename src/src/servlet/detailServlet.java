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

import dao.recordsDAO;
import model.records;
import model.user;

/**
 * Servlet implementation class detailServlet
 */
@WebServlet("/detailServlet")
public class detailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		//これでもって、データを特定することができる。

		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("allList");
		int userid = user.getId();


		/*
		 * Servlet processing:
		 *     Step 1:   Get data from the request
		 *     Step 2.1: Use model/Dao classes to retreieve recipe information from database.
		 *     Step 2.2: Do any processing that is needed on the retreived data.
		 *     Step 3:   Send the data as a response
		 */



		// Step 2:
		recordsDAO rcsDao = new recordsDAO();
	List<records> rcs = rcsDao.select(new records(0, userid, "", "", 0, 0));
		//records rcs = recordsというオブジェクトに書き換わる。

		// Step 3:
	request.setAttribute("recipe",rcs);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp");
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

