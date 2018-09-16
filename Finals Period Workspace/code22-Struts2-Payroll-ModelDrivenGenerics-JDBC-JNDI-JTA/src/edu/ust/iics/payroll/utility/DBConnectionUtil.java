package edu.ust.iics.payroll.utility;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBConnectionUtil {
	public static Connection getDBConnection() {
		
		Connection connection = null;
		
		try{
			connection = ((DataSource) InitialContext
					.doLookup("java:/comp/env/jdbc/ICS114-3CSB-DB"))
					.getConnection();
			
			System.out.println((connection != null)
				?"successful connection"
				:"unable to connect to db server");
		} catch(NamingException ne){
			ne.printStackTrace();
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return connection;
	}
}