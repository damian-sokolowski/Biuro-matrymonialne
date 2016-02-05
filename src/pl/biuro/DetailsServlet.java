package pl.biuro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.db.ConnectBaza;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ConnectBaza db;

	private String query = "";
	String[] what;
	ArrayList<Dictionary<String, String>> result;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		db = new ConnectBaza();
		result = new ArrayList<Dictionary<String, String>>();
		query = "SELECT * FROM person where person_id = '" + id + "'";
		what = new String[] { "person_id", "short_description", "description", "name", "age", "weight", "hight" };

		try {
			result = db.select(query, what);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.isEmpty()) {
			response.getWriter().append("Bledne id");
		} else {

			request.setAttribute("persons", result.get(0));

			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/details");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
