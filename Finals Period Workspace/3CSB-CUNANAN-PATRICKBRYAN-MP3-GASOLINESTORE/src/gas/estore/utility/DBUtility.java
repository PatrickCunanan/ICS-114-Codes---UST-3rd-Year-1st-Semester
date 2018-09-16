package gas.estore.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtility {
	public static Connection getDBConnection() {

		Connection connection = null;

		try {
			connection = ((DataSource) InitialContext.doLookup("java:/comp/env/jdbc/MP3-GASOLINESTORE"))
					.getConnection();

			System.out.println((connection != null) ? "successful connection" : "unable to connect to db server");
		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return connection;
	}
}
