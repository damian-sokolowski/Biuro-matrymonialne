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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ConnectBaza db;
	private String query = "";
	String[] what;
	ArrayList<Dictionary<String, String>> result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		String url = "/login.jsp";
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		Boolean userValid = false;

		db = new ConnectBaza();
		result = new ArrayList<Dictionary<String, String>>();
		query = "SELECT * FROM users WHERE login ='" + login + "'";
		what = new String[] { "name", "usertype", "password" };

		try {
			result = db.select(query, what);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Dictionary<String, String> val : result) {
			if ((pass.equals(val.get("password0"))) & (pass != "")) {
				session.setAttribute("user", val.get("name0"));
				session.setAttribute("userType", val.get("usertype0"));
				request.setAttribute("error", null);
				url = "/IndexServlet";
				userValid = true;
				break;
			}
		}

		if (!userValid) {
			session.setAttribute("user", null);
			request.setAttribute("error", "Błędny login lub hasło");
		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
