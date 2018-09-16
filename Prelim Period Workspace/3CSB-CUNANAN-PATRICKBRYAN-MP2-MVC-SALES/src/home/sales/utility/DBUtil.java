package home.sales.utility;

import java.sql.*;
import javax.sql.*;

import javax.naming.*;

public class DBUtil {
	public static Connection getDBConnection() {

		Connection connection = null;

		try {
			connection = ((DataSource) InitialContext.doLookup("java:/comp/env/jdbc/MP2-MVC-SALES")).getConnection();

			System.out.println((connection != null) ? "successful connection" : "unable to connect to db server");
		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return connection;
	}
}
