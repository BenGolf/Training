/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediamanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pubali Banerjee
 * written on 11/13/2012
 * vhs class is extended from media class
 * the flat cost for all vhs including shipping is $20.00
 */
public class vhs extends media
{
   private String output;


	//set cost to $20.00, no matter what
    @Override public void setCost(double c)
    {
       cost = c;
    }
    //constructor default
    public vhs()
    {
        super();
        this.setCost(20.00);
    }
    
    //like dvd
   @Override public void add() 
     {
     Statement stmt = null;
    
     try
     {
     Connect conn = new Connect();
     stmt=conn.makeStatement();
    
    
        //Create SQL statement to insert

        stmt.execute("Insert Into media (mediaID,title,year,cost,type)"
                 + " Values ('"
                 + mediaID + "','"
                 + title + "','"
                 + year + "','"
                 + cost + "','"
                 + type + "')");


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
    
       
    @Override public void querybyid()
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

             }
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
            System.out.println(this.toString()); 
    }
    
    
    
    @Override public double calcCost(int mid)
    {
        //its always 20, so no need to query database        
        return this.getCost();
     }
    
    
    @Override
    public String toString() 
    {
        return super.toString();
        
    }
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}