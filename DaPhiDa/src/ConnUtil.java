import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility to return jdbc connections
 * To get a connection, call 
 * 
 * Connection x = ConnUtil.getConnection();
 * 
 * Note this is hardcoded with our database, if we need to change or modify the connection check here.
 * @author Darren Ling
 *
 */
public class ConnUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		String host = "mysql4.cs.stonybrook.edu";
		String db = "?user=daling";
		String user = "daling";
		String password = "110429955";
		String url = "jdbc:mysql://" + host + ":3306/" + db;
		Connection ret = DriverManager.getConnection(url, user, password);
		return ret;
	}
}
