package home.sales.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import home.sales.utility.DBUtil;
import home.sales.model.PayBean;

public class ListRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;

	public void init() throws ServletException {
		connection = DBUtil.getDBConnection();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (connection != null) {
			ResultSet recordsA = new PayBean().getAllRecords(connection, 'A');
			ResultSet recordsB = new PayBean().getAllRecords(connection, 'B');
			ResultSet recordsC = new PayBean().getAllRecords(connection, 'C');
			request.setAttribute("salesRecordsA", recordsA);
			request.setAttribute("salesRecordsB", recordsB);
			request.setAttribute("salesRecordsC", recordsC);

			request.getRequestDispatcher("displayrecord.jsp").forward(request, response);
		} else {
			System.err.println("connection is NULL.");
		}
	}

}
