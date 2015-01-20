/*the tester class for mediaLib application*/
package mediamanager;


import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Pubali Banerjee
 * written on 11/14/2012
 * this is the manager class that uses the other classes
 */
public class MediaManager 
{

private static Scanner menuint;
private static Scanner addintext;
private static Scanner addinint;
private static String st;
private static Scanner queryint;
private static Scanner calcin;

public static void main(String[] args) 
{
       
    Integer swValue=0;
    menuint = new Scanner(System.in);

 do {
         // Display main menu graphics
         System.out.println("===============================");
         System.out.println("|   MAIN MENU                 |");
         System.out.println("===============================");
         System.out.println("| Options:                    |");
         System.out.println("|        1. Add Media         |");
         System.out.println("|        2. Show all media    |");
         System.out.println("|        3. Query media by ID |");
         System.out.println("|        4. Calc Cost         |");
         System.out.println("|        5. Exit              |");
         System.out.println("===============================");
         System.out.print(" Select option: ");

         try 
         {
             swValue = menuint.nextInt();
             Integer.valueOf(swValue).intValue();

         }

         catch (NumberFormatException e) 
         {
             System.out.println("Invalid input. Not an integer");
         }


         // Switch construct
         switch (swValue) 
         {
             case 5:
               System.exit(0);
             case 1:      // add media
                 AddMedia();
                 break;
             case 2:      // query media
              QueryMedia();               
                 break;
             case 3:
              QueryMediabyId();//show media by id
                 break;
             case 4:      
                calcCost();   // calculate shipping cost
                 break;  

             default:
                 break;

         }
  } while (swValue != 5);  // while loop  

     
}//main loop
    
public static void AddMedia() 
{

     Integer answer=0;

     addintext = new Scanner(System.in);
     addinint = new Scanner(System.in);

     //media.initializeall();

     System.out.println("Add a media");
     System.out.println("Please enter the Unique Media ID >");
     int id = addinint.nextInt();

     System.out.println("Please enter the Title (20 char max) >");
     String title = addintext.nextLine();

     System.out.println("Please enter the Year (20 char max) >");
     String year = addintext.nextLine();

     System.out.println("Please enter the cost (numeric) >");
     Double cost = addinint.nextDouble();    

     System.out.println("Is this a DVD or VHS? (1=DVD or 2=VHS) >");
     answer = addinint.nextInt();
     if (answer.equals(1)) 
     {

         dvd dvdMedia = new dvd();
         dvdMedia.setmediaID(id);
         dvdMedia.setTitle(title);
         dvdMedia.setCost(cost);
         dvdMedia.setYear(year);
         dvdMedia.setType("DVD");
         dvdMedia.add();

     }
     else
     {
         vhs vhsMedia = new vhs();
         vhsMedia.setmediaID(id);
         vhsMedia.setTitle(title);
         vhsMedia.setCost(cost);
         vhsMedia.setYear(year);
         vhsMedia.setType("VHS");
         vhsMedia.add();

     }

}  // Add media

public static void QueryMedia() 
{
    //query all media
    //since this method queries the db for all media, it belongs to the manager/tester class

    Statement stmt = null;
    ResultSet rs = null;
    String st = "Select * from media" ;
    try
    {
        Connect conn = new Connect();
        stmt=conn.makeStatement();
        rs = stmt.executeQuery(st);

        //Parse the result set returned and print
        while (rs.next()) 
        {
            String output = " ";
            output  += rs.getInt("mediaID") + "  "
                    + rs.getString("title") + " "
                    + rs.getString("year") + " "
                    + rs.getDouble("cost") + " "
                    + rs.getString("type") + "\n";

            System.out.printf("%s", output);
        }

        // Close the result set, statement and the connection
        rs.close();
        stmt.close();
        conn.close();
        conn.close();

      } 
   catch (Exception e) 
    {
            System.err.println("ERROR: Either cannot connect to the DB "
                    + " or error with the SQL statement");
    }
}
 
  
 
public static void QueryMediabyId() 
{
        //call querybyid method for appropriate object in here
    
        setSt("");
        queryint = new Scanner(System.in);


        System.err.println("Please enter the MediaID number");
        int sid = queryint.nextInt();

        System.out.println("Is it a DVD or a VHS? (1=DVD or 2=VHS) >");
        Integer answer = queryint.nextInt();


        if(answer.equals(1)) 
        {
            dvd dvdMedia = new dvd();
            dvdMedia.setmediaID(sid);
            dvdMedia.querybyid();
         }  
        else if(answer.equals(2))
        {
            vhs vhsMedia = new vhs();
            vhsMedia.setmediaID(sid);
            vhsMedia.querybyid();        
        }

}
   
public static void calcCost()
{
        //call calcCost for appropriate object in here
        Integer SID=0;
        calcin = new Scanner(System.in);    

        System.out.println("Please enter the Media ID for the media for which you want to calculate the total cost >");
        SID = calcin.nextInt();

         System.out.println("Is this a DVD or VHS? (1=DVD or 2=VHS) >");
         Integer answer = calcin.nextInt();
         if (answer.equals(1)) 
         {
             dvd mydvd = new dvd();
             mydvd.setmediaID(SID);
             System.out.println("The cost for this dvd would be $" + mydvd.calcCost(SID));
         }
         else
         {
             vhs myvhs = new vhs();
             System.out.println("The cost for this vhs is $" + myvhs.calcCost(SID));
         }
}

public static String getSt() {
	return st;
}

public static void setSt(String st) {
	MediaManager.st = st;
}
}
