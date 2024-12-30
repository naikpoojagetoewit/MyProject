
package csccorner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDao {

    private String dburl = "jdbc:mysql://localhost:3306/userdb";
    private String dbuname = "root";
    private String dbpassword = "8008";
    private String dbdriver = "com.mysql.cj.jdbc.Driver"; 

    
    public DatabaseDao() {
        loadDriver();
    }
   
    public void loadDriver() {
        try {
            Class.forName(dbdriver); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, dbuname, dbpassword);
    }
   
 
	}
  