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
import javax.servlet.http.HttpSession;

import sql.db.ConnectBaza;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ConnectBaza db;
	private String query = "";
	String[] what;
	ArrayList<Dictionary<String, String>> result;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String label = request.getParameter("label");

		db = new ConnectBaza();
		query = "SELECT " + label + " FROM person where person_id = '" + id + "'";
		what = new String[] { label };

		try {
			result = db.select(query, what);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.isEmpty()) {
			response.getWriter().append("Bledne id");
		} else {
			request.setAttribute("value", result.get(0).get(label + "0"));
			session.setAttribute("label", label);
			session.setAttribute("id", id);

			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/edit.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		String label = session.getAttribute("label").toString();
		String edited = request.getParameter("edited");

		db = new ConnectBaza();
		result = new ArrayList<Dictionary<String, String>>();
		query = "UPDATE person SET " + label + " = '" + edited + "' WHERE person_id = " + id;

		try {
			db.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/DetailsServlet?id=" + id);
		dispatcher.forward(request, response);
	}

}
