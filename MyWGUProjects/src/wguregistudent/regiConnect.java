/**
 * DB connection class
 * used to connect to database registrar
 */

package wguregistudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


 /**
  *
  * @author : Bernard Nsabimana
  * Western Governors University (WGU)
  * BS - IT
  * Instructors : Pubali Banerjee / Cynthia Lang
  * written : April 2013
  * Course : Object Oriented Design and Development (Java)
 */

public class regiConnect {

    public regiConnect() throws SQLException
    {
        makeConnection();
    }

    private Connection stuConn;

     public Connection makeConnection() throws SQLException
     {
        if (stuConn == null)
        {
           stuConn = DriverManager.getConnection(
          /**             "jdbc:mysql://localhost:3306/registrar",
                       "root",
                       "Love1967");   */
                   
                      "jdbc:mysql://173.254.28.79:3306/webdata5_IHUDAF",
                       "webdata5",
                       "hDY9eMZW$");               
             
         }
         return stuConn;
     }

     public Statement makeStatement() throws SQLException
     {
         Statement stud = stuConn.createStatement();
         return stud;
     }

     public int close() throws SQLException
     {
         stuConn.close();
         return 1;
     }

}