package gasoline.estore.struts2.utility;

import java.sql.*;
import javax.sql.*;

import javax.naming.*;

public class DBConnectionUtil {
	public static Connection  getDBConnection() {
		Connection connection = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)
				initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)
				envContext.lookup("jdbc/ICS114-3CSB-DB");
			connection = ds.getConnection();
			
			System.out.println((connection != null)
				?"successful connection"
				:"unable to connect to db server");	
		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
}
