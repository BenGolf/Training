//* db connection class, can be used to connect to db*/
package mediamanager;

//import com.mysql.jdbc.Driver;
import java.sql.*;
/**
 *
 * @author  Pubali Banerjee
 * written on 11/13/2002
 */
public class Connect 
{
    public Connect() throws SQLException
    {
        makeConnection();
    } 

    private Connection conn;  

     public  Connection makeConnection() throws SQLException 
     {
        if (conn == null)
        {
                        
             conn = DriverManager.getConnection(
                       "jdbc:mysql://localhost/medialib",
                       "root",
                       "Love1967");
         }
         return conn;
     }  
     
     public Statement makeStatement() throws SQLException 
     {
         Statement st = conn.createStatement();
         return st;
     }
     
     public int close() throws SQLException
     {
         conn.close();
         return 1;
     }
     
}
