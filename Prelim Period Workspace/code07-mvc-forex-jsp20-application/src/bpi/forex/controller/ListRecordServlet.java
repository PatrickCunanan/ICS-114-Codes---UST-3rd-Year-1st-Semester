package bpi.forex.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bpi.forex.model.ForexBean;
import java.sql.ResultSet;

@WebServlet("/listrecords.html")
public class ListRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Connection connection = null;
    
	public void init() throws ServletException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cunanan-3csb-ics114-db", "root", "");
			
			System.out.println((connection != null)
				?"successful connection"
				:"unable to connect to db server");
		} catch(ClassNotFoundException cfne){
			cfne.printStackTrace();
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(connection != null){
			ResultSet records = new ForexBean().getAllRecords(connection);
			request.setAttribute("forexRecords", records);
			request.getRequestDispatcher("displayrecords.jsp").forward(request, response);
		}else {
			System.err.println("connection is NULL.");
		}
	}

}
