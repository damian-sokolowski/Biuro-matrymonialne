package sql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class ConnectBaza {
	private static final long serialVersionUID = 1L;

	private final static String dbUrl = "jdbc:mysql://127.0.0.1:3306/biuro_matrymonialne";
	private final static String dbUser = "admin";
	private final static String dbPassword = "admin";
	private final static String dbDriver = "com.mysql.jdbc.Driver";

	private Connection connection;
	private Statement statement;
	ResultSet resultset = null;

	ArrayList<Dictionary<String, String>> result;
	Dictionary<String, String> resultDic;

	public ConnectBaza() {
		super();
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drop(String query) throws SQLException {
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultset != null)
				resultset.close();
			if (statement != null)
				statement.close();
			if (connection != null) {
				connection.close();
			}
		}

	}

	public void update(String query) throws SQLException {
		try {
			statement = connection.prepareStatement(query);
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultset != null)
				resultset.close();
			if (statement != null)
				statement.close();
			if (connection != null) {
				connection.close();
			}
		}

	}

	public ArrayList<Dictionary<String, String>> select(String query, String[] what) throws SQLException {
		int index = 0;
		result = new ArrayList<Dictionary<String, String>>();
		resultDic = new Hashtable<String, String>();
		try {
			statement = connection.prepareStatement(query);
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				for (String key : what) {
					resultDic.put(key + index, resultset.getString(key).trim());
				}
				result.add(resultDic);
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultset != null)
				resultset.close();
			if (statement != null)
				statement.close();
			if (connection != null) {
				connection.close();
			}
		}

		return result;
	}
}
