package edu.ust.iics.forex.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ust.iics.forex.model.ForexBean;

public class ListRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection = null;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName(config.getInitParameter("jdbcDriver"));
			
			connection = DriverManager.getConnection(
				config.getInitParameter("jdbcURL"), 
				config.getInitParameter("dbUserName"), 
				config.getInitParameter("dbPassword"));
			
			System.out.println((connection != null)
				?"successful connection"
				:"unable to connect to db server");	
		} catch (ClassNotFoundException cfne) {
			cfne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (connection != null) {
			ResultSet records = new ForexBean()
				.getAllRecords(connection);
			
			request.setAttribute("forexRecords", records);
			
			request.getRequestDispatcher("displayrecords.jsp")
				.forward(request, response);
		} else {
			System.err.println("connection is NULL.");
		}	
	}
}
