package home.sales.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.sales.model.PayBean;
import home.sales.utility.DBUtil;
import home.sales.utility.PayBeanFactory;

public class ProcessPay extends HttpServlet {
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
		String eName = request.getParameter("eName");
		char sCode = request.getParameter("sCode").charAt(0);
		double sAmount = 0;
		try {
			sAmount = Double.parseDouble(request.getParameter("sAmount") + "");
		} catch (NumberFormatException nfe) {
			sAmount = -1;
		}

		String url = "";

		PayBean b = PayBeanFactory.getInstance(eName, sCode, sAmount,connection);

		if (b.isValidSalesAmount() == true) {
			request.setAttribute("PayKey", b);
			url = "displayresult.jsp";
		} else if (b.isValidSalesAmount() == false) {
			request.setAttribute("error", "Error! Sales Amount input is invalid!");
			url = "index.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
