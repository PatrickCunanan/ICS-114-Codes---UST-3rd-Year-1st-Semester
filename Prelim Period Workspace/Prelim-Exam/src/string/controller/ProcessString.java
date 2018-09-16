package string.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import string.utility.DBUtility;
import string.model.StringBean;
import string.utility.StringFactory;

public class ProcessString extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;
	public void init() throws ServletException {
		connection = DBUtility.getDBConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String input = request.getParameter("string");
		String url = "";
		StringBean s = StringFactory.getInstance(input, connection);
		request.setAttribute("s", s);
		url = "displayresult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
