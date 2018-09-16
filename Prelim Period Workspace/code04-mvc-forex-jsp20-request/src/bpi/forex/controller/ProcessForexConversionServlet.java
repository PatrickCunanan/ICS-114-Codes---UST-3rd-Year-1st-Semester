package bpi.forex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bpi.forex.model.ForexBean;
import bpi.forex.utility.ForexBeanFactory;;
@WebServlet("/processconversion.html")
public class ProcessForexConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProcessForexConversionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int phpAmount = Integer.parseInt(request.getParameter("phpAmount"));
		String currency = request.getParameter("currency");
		
		ForexBean forex = ForexBeanFactory.getInstance(phpAmount, currency);
	
		request.setAttribute("pinagpalitanNgPera", forex);
		request.getRequestDispatcher("displayresults.jsp").forward(request, response);
		
	}

}
