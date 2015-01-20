/** To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediamanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pubali Banerjee
 * written on 11/14/2012
 * The DVD class extends the super class media.
 * the abstract class of the super costCalc()is overridden
 * 
 * the flat shipping cost for a dvd is $2.99
 * which is added to the cost of the dvd
 * the following super methods: add(),query(), querybyid(int id), toString() are also overridden
 * 
 */
public class dvd extends media 
{
    private double dvdshipcost;
    private String blueray;
	private String output;
	private String output2;
      
    //Default constructor
    public dvd() 
    {
        super();
        dvdshipcost =2.99;//this is constant, so no setter and getter
        blueray="N";
    }
     
    //setter and getter
    public void setBlueray(String c)
    {
        blueray =c;
    }
    
    public String getBlueray()
    {
        return blueray;
    }
    
    
    //override the method that adds the media to db
    
    @Override public void add() 
     {
        Statement stmt = null;

        try
        {
            Connect conn = new Connect();
            stmt=conn.makeStatement();


            //Create SQL statement to insert

            stmt.execute("Insert Into media (mediaID,title,year,cost,type,blueray)"
                     + " Values ('"
                     + mediaID + "','"
                     + title + "','"
                     + year + "','"
                     + cost + "','"
                     + type + "','"
                     + blueray + "')");


            stmt.close();
            conn.close();
        }
         catch (SQLException e) 
         {
            e.printStackTrace();
            System.err.println("Could not insert");

         } 
        System.out.println("Successfully added media to the database");
     }
      
    //override the method that queries db by mediaID
 @Override 
 public void querybyid()
    {
        Statement stmt = null;
        ResultSet rs = null;
        setOutput(" ");
    
    try
    {
    Connect conn = new Connect();
    stmt=conn.makeStatement();
    String sqlst = "Select * FROM media WHERE mediaID = " + getmediaID();
    rs = stmt.executeQuery(sqlst);
   
    //Parse the result set returned and print
           
     while(rs.next())
     {
      this.setmediaID(rs.getInt("mediaID"));
      this.setTitle(rs.getString("title"));
      this.setYear(rs.getString("year")); 
      this.setCost(rs.getDouble("cost"));
      this.setType(rs.getString("type"));
      this.setBlueray(rs.getString("blueray"));

     }
          
        // Close the result set, statement and the connection
        rs.close();
        stmt.close();
        conn.close();
        conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL ERROR");
        }
    //use the toString method to print the object on screen
      System.out.println(this.toString()); 
    }
    
    
    //the overridden method for calculating cost
    @Override 
    public double calcCost(int mid)
    {
        
        Statement stmt = null;
        ResultSet rs = null;
        setOutput2(" ");
        double result=0;
    try
    {
        Connect conn = new Connect();
        stmt=conn.makeStatement();
        //get the cost from the db first
        String sqlst = "Select * FROM media WHERE mediaID = " + mid;
        System.out.println(sqlst);
        rs = stmt.executeQuery(sqlst);
        if(rs.next())
         result= rs.getDouble("cost");

       // Close the result set, statement and the connection
          rs.close();
          stmt.close();
          conn.close();
          conn.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.err.println("ERROR: Either cannot connect to the DB "
                    + " or error with the SQL statement");
        }
    return result+dvdshipcost;
    }
 
    
 //override this mthod to print the variables not in super   
 @Override
 public String toString() 
 {
        String s = super.toString();
        s += " Blueray:  " + blueray;
        return s;
    }

public String getOutput() {
	return output;
}

public void setOutput(String output) {
	this.output = output;
}

public String getOutput2() {
	return output2;
}

public void setOutput2(String output2) {
	this.output2 = output2;
}
}