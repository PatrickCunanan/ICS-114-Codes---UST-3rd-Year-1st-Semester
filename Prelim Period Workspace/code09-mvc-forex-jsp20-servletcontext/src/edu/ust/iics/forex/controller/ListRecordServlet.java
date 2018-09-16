package edu.ust.iics.forex.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ust.iics.forex.model.ForexBean;
import edu.ust.iics.forex.utility.DBConnectionUtil;

public class ListRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;

	public void init() throws ServletException {
		connection = DBConnectionUtil.getDBConnection(getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (connection != null) {
			ResultSet records = new ForexBean().getAllRecords(connection);

			request.setAttribute("forexRecords", records);

			request.getRequestDispatcher("displayrecords.jsp").forward(request, response);
		} else {
			System.err.println("connection is NULL.");
		}
	}
}
