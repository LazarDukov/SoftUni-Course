import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public enum Utils {
    ;

    static Connection getSqlConnection() throws SQLException {
        Properties prop = new Properties();
        prop.setProperty(Constants.USER_KEY, Constants.USER_VALUE);
        prop.setProperty(Constants.PASSWORD_KEY, Constants.PASSWORD_VALUE);

        Connection con = DriverManager.getConnection(Constants.JDBC_URL, prop);
        return con;
    }

}
