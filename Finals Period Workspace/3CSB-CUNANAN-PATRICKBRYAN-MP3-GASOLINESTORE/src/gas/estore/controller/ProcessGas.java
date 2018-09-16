package gas.estore.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gas.estore.model.GasBean;
import gas.estore.utility.*;
public class ProcessGas extends HttpServlet {
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
		String gType = request.getParameter("gType");
		double gLiters = Integer.parseInt(request.getParameter("gLiters"));
		double pPerLiter = 0.0;
		ServletContext c = getServletContext();
		switch (gType) {
		case "Unleaded": {
			pPerLiter = Double.parseDouble(c.getInitParameter("Unleaded"));
			break;
		}
		case "Diesel": {
			pPerLiter = Double.parseDouble(c.getInitParameter("Diesel"));
			break;
		}
		case "Premium": {
			pPerLiter = Double.parseDouble(c.getInitParameter("Premium"));
			break;
		}
		}
		String cType = request.getParameter("cType");
		String cNumber = request.getParameter("cNumber");
		String url = "";
		GasBean g = null;
		try {
			g = GasBeanFactory.getInstance(gType, gLiters, pPerLiter, cType, cNumber, connection);
			request.setAttribute("gas", g);
			url = "displayresults.jsp";
		} catch (InvalidCreditCardNumberException e) {
			request.setAttribute("error", e.getMessage());
			url = "index.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
