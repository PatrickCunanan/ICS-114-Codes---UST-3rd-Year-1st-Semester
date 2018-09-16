package edu.ust.iics.forex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ust.iics.forex.model.ForexBean;
import edu.ust.iics.forex.utility.DBConnectionUtil;
import edu.ust.iics.forex.utility.ForexHelper;

import java.sql.*;

public class ProcessConversionServlet extends HttpServlet {
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

		// step 2 - get values from the form
		int phpAmount = Integer.parseInt(request.getParameter("phpAmount"));
		String currency = request.getParameter("currencyType");

		// step 3 create and populate the bean
		ForexBean forex = ForexHelper.getInstance(phpAmount, currency, connection);

		// step 4 - store the bean in ServletContext
		getServletContext().setAttribute("palitanNgPera", forex);

		// step 5 - forward the request object to JSP
		// request.getRequestDispatcher("displayvalues.jsp").forward(request,
		// response);
		response.sendRedirect("displayvalues.jsp");
	}
}
