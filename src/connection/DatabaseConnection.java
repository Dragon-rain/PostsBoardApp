package connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
	public static Connection initializeDatabase() throws ClassNotFoundException, SQLException {
		InitialContext initialContext = null;
		DataSource ds= null;
		try {
			initialContext = new InitialContext();
			ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/test");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Connection con = ds.getConnection();
		return con;
	}

}
