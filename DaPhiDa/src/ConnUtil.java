import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility to return jdbc connections
 * To get a connection, call 
 * 
 * Connection x = ConnUtil.getConnection();
 * 
 * It is a good idea to use a try-with-resources block, that is:
 * 
 * try (Connection x = ConnUtil.getConnection()) {
 *      // Code involving connection
 * }
 * catch (Exception e) { ... }
 * 
 * Note this is hardcoded with our database, if we need to change or modify the connection check here.
 * @author Darren Ling, Phillip Huang
 *
 */
public class ConnUtil {

    private static String protocol = "jdbc:mysql://";
    private static String host = "mysql4.cs.stonybrook.edu";
    private static String port = "3306";
    private static String db = "daling";
    private static String user = "daling";
    private static String password = "110429955";
    
    private static boolean isDriverInstantiated = false;
    
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException, 
	                                        InstantiationException, IllegalAccessException {
        if (!isDriverInstantiated ) {
            String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
            Class.forName(mysJDBCDriver).newInstance();
            
            isDriverInstantiated = true;
        }

        String url = protocol + host + ":" + port + "/" + db;
        Connection ret = DriverManager.getConnection(url, user, password);
		return ret;
    }
}
