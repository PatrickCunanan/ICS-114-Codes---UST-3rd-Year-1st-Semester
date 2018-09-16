package home.sales.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.sales.model.PayBean;
import home.sales.utility.PayBeanFactory;

@WebServlet("/processpay.html")
public class ProcessPay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessPay() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
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
		try{
			sAmount = Double.parseDouble(request.getParameter("sAmount") + "");
		}catch(NumberFormatException nfe){
			sAmount = -1;
		}
		
		String url = "";

		PayBean b = PayBeanFactory.getInstance(eName, sCode, sAmount);

		if (b.isValidSalesAmount() == true && b.isValidSalesCode() == true) {
			request.setAttribute("PayKey", b);
			url = "displayresult.jsp";
		} else if (b.isValidSalesAmount() == false && b.isValidSalesCode() == true) {
			request.setAttribute("error", "Error! Sales Amount input is invalid!");
			url = "index.jsp";
		} else if (b.isValidSalesAmount() == true && b.isValidSalesCode() == false) {
			request.setAttribute("error", "Error! Sales Code input is invalid!");
			url = "index.jsp";
		} else {
			request.setAttribute("error", "Error! Sales Amount and Sales Code inputs are invalid!");
			url = "index.jsp";
		}
		System.out.println(b.isValidSalesCode());
		request.getRequestDispatcher(url).forward(request, response);
	}

}
