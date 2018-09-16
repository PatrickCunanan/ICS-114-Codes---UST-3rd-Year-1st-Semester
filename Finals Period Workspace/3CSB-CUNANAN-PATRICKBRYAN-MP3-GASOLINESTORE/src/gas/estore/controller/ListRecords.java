package gas.estore.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gas.estore.model.GasBean;
import gas.estore.utility.DBUtility;

public class ListRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;

	public void init(ServletConfig config) throws ServletException {
		connection = DBUtility.getDBConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (connection != null) {
			ResultSet records = new GasBean().getAllRecords(connection);
			request.setAttribute("gt", records);
			request.getRequestDispatcher("displayrecords.jsp").forward(request, response);
		} else {
			System.err.println("connection is NULL.");
		}
	}

}
