/**
 * Graduate subclass, inherited from Student
 * with additional attributes: thesisTitle, and thesisAdvisor.
 */
package wguregistudent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

 /**
  *
  * @author : Bernard Nsabimana
  * Western Governors University (WGU)
  * BS - IT
  * Instructors : Pubali Banerjee / Cynthia Lang
  * written : April 2013
  * Course : Object Oriented Design and Development (Java)
 */

 //  Graduate class extends Super class Student.

public class Graduate extends Student {
    
    private String thesisTitle;
    private String thesisAdvisor;
	private Scanner addintext;
	private Scanner addinint;
	private Scanner updateint;
	private Scanner updatetext;
	private Scanner calcuTuit;
   
    //Default constructor

    public Graduate() {
        
        super();
        thesisTitle = "";        // Thesis  Title
        thesisAdvisor = "";      // Thesis Advisor
    }
 
    //setters and getters
    
    public void setThesis(String stuThesis) {
        
        thesisTitle = stuThesis;
    }

   public void setAdvisor(String stuAdvisor) {
    
        thesisAdvisor = stuAdvisor;
   }
   
   public String getThesis()  {
       
       return thesisTitle;
   }
   
   public String getAdvisor()  {
       
       return thesisAdvisor;
   }
   
    //override the method that adds the Student to DB
    @Override
    public void add() {
        
        Statement stmt = null;
        addintext = new Scanner(System.in);
        addinint = new Scanner(System.in);
        Integer stuID = 0;
        String stuFirst = "";
        String stuLast = "";
        Float stuGpa = 0.0f;
        String stuMentor = "";
        String stuStatus = "";
        String stuThesis = "";
        String stuAdvisor = "";
                 
        // validation Student ID - positive number 
        
        do {
            
            System.out.println("");
            System.err.print("Please Enter the Unique Student ID : ");
            while (!addinint.hasNextInt()) {
                System.err.print("studentID  Must be a positive Number :");
                addinint.next();
            }
            stuID = addinint.nextInt();
        } while (stuID <= 0);   // StudentID has to be Greater than Zero 
    
        // validating Fist  Name - not null and max 20 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the First Name (20 Chars Max) : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the First Name : ");
                addintext.nextLine();
            }
            stuFirst = addintext.nextLine();
        } while (stuFirst.length() > 20 || stuFirst.isEmpty());  
    
         
        // validating Last Name - not null and max 20 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Last Name (20 Chars Max) : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the Last  Name : ");
                addintext.nextLine();
            }
            stuLast = addintext.nextLine();
        } while (stuLast.length() > 20 || stuLast.isEmpty());   
    
           
        // validating Gpa - not null 
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Gpa  (Float) : ");
            while (!addinint.hasNextFloat()) {
                System.out.print("Please Enter the Gpa : ");
                addinint.nextFloat();
            }
            stuGpa = addinint.nextFloat();
        } while (stuGpa <= 0);          
  
        // validating Status - not null and max 15 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Status (15 Chars Max) : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the Status : ");
                addintext.nextLine();
            }
            stuStatus = addintext.nextLine();
        } while (stuStatus.length() > 15 || stuStatus.isEmpty());          
        
         
        // validating Mentor  - not null and max 20 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Mentor Name (20 Chars Max) : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the Mentor : ");
                addintext.nextLine();
            }
            stuMentor = addintext.nextLine();
        } while (stuMentor.length() > 20 || stuMentor.isEmpty());   
            
                
        // validating Thesis Title - not null and max 60 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Thesis Title (60 Chars Max)  : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the Thesis Title : ");
                addintext.nextLine();
            }
            stuThesis = addintext.nextLine();
        } while (stuThesis.length() > 60 || stuThesis.isEmpty());   
    
        
        // validating Advisor  - not null and max 20 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Advisor Name (20 Chars Max) : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the Advisor : ");
                addintext.nextLine();
            }
            stuAdvisor = addintext.nextLine();
        } while (stuAdvisor.length() > 20 || stuAdvisor.isEmpty());   
            
           
        String stuLevel = "NA";   // Not Applicable, but NOT NULL
        String stuCompany = "NA"; // Not Applicable, but NOT NULL
            
        try {
            
            regiConnect stuConn = new regiConnect();
            stmt = stuConn.makeStatement();
            
            //Create SQL statement to insert  New  Graduate Student
            
            stmt.execute("Insert Into student(studentID, firstName, lastName,"
                    + " gpa, status, mentor, level, thesisTitle,"
                    + " thesisAdvisor, company)"
                     + " Values ('"
                     + stuID + "','"
                     + stuFirst + "','"
                     + stuLast + "','"
                     + stuGpa + "','"
                     + stuStatus + "','"
                     + stuMentor + "','"
                     + stuLevel + "','"
                     + stuThesis + "','"
                     + stuAdvisor + "','"
                     + stuCompany + "')");
                 
            stmt.close();
            stuConn.close();
        }
        catch (SQLException e) {
            
            e.printStackTrace();
            System.err.println("Could not Add New Student to the DB");

         }
        System.err.println("Successfully New Student Added to the DB");
     }

    //override the method that update Student in the DB
   @Override
    public void update() {
       
        Integer stuChoice;
        String sqlstr ="";
        Statement stmt = null;
        updateint = new Scanner(System.in);
        updatetext = new Scanner(System.in);
        String newFirst = "";
        String newLast = "";
        Float newGpa = 0.00f;
        String newMentor = "";
        String newStatus = "";
        String newThesis = "";
        String newAdvisor = "";        

        System.out.println("Updating an Existing Graduate Student");
        System.out.println("=====================================");
             
        System.out.println("1: First Name");
        System.out.println("2: Last Name");
        System.out.println("3: Gpa");
        System.out.println("4: Status");
        System.out.println("5: Mentor");
        System.out.println("6: Thesis");
        System.out.println("7: Advisor"); 
    
        // validation Field to update
        do {
        System.out.println("");
        System.err.print("Please Choose Field To Update: ");
        while (!updateint.hasNextInt()) {
            System.err.print("Graduate Field between 1 to 7, Try again : ");
            updateint.next();
        }
        stuChoice = updateint.nextInt();
        } while (stuChoice <= 0 || stuChoice > 7);   // Field to update (1,2,3,4,5,6,7) 
        
        if (stuChoice == 1){
            
            do {
                
                System.out.println("");
                System.err.print("Enter the New First Name (20 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New First Name : ");
                    updatetext.nextLine();
                }
                newFirst = updatetext.nextLine();
            } while (newFirst.length() > 20 || newFirst.isEmpty());  
            
            sqlstr = ("Update student SET " + "firstName" +
                    "= "+ "\"" + newFirst + "\"" + " WHERE studentID = " + studentID);
        
        } else if (stuChoice == 2){
            
            do {
                
                System.out.println("");
                System.err.print("Enter the New Last Name (20 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New Last Name : ");
                    updatetext.nextLine();
                }
                newLast = updatetext.nextLine();
            } while (newLast.length() > 20 || newLast.isEmpty());  
            
            sqlstr = ("Update student SET " + "lastName" +
                    "= "+ "\"" + newLast + "\"" + " WHERE studentID = " + studentID);
        
        } else if (stuChoice == 3){
                  
            do {
                
                System.out.println("");
                System.err.print("Please enter the new Gpa : ");
                while (!updateint.hasNextFloat()) {
                    System.out.print("Please Enter New New  Gpa : ");
                    updateint.nextFloat();
                }
                newGpa = updateint.nextFloat();
            } while (newGpa <= 0);  
            
            sqlstr = ("Update student SET " + "gpa" +
                    "= "+ "\"" + newGpa+ "\"" + " WHERE studentID = " + studentID);
        
        } else if (stuChoice == 4){
              
            do {
                
                System.out.println("");
                System.err.print("Enter the New Status (15 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New Status : ");
                    updatetext.nextLine();
                }
                newStatus = updatetext.nextLine();
            } while (newStatus.length() > 15 || newStatus.isEmpty());  
                 
            sqlstr = ("Update student SET " + "status" +
                    "= "+ "\"" + newStatus + "\"" + " WHERE studentID = " + studentID);
        
        } else if (stuChoice == 5) {
            
            do {
                
                System.out.println("");
                System.err.print("Enter the New Mentor Name (20 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New Mentor : ");
                    updatetext.nextLine();
                }
                newMentor = updatetext.nextLine();
            } while (newMentor.length() > 20 || newMentor.isEmpty());  
  
            sqlstr = ("Update student SET " + "mentor" +
                    "= "+ "\"" + newMentor + "\"" + " WHERE studentID = " + studentID);
        
        } else if (stuChoice == 6){
  
            do {
                
                System.out.println("");
                System.err.print("Enter the New Thesis (60 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New Thesis : ");
                    updatetext.nextLine();
                }
                newThesis = updatetext.nextLine();
            } while (newThesis.length() > 60 || newThesis.isEmpty());  
      
            sqlstr = ("Update student SET " + "thesisTitle" +
                    "= "+ "\"" + newThesis + "\"" + " WHERE studentID = " + studentID);
        
        } else {
             
            do {
                
                System.out.println("");
                System.err.print("Enter the New Advisor (20 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New Advisor : ");
                    updatetext.nextLine();
                }
                newAdvisor = updatetext.nextLine();
            } while (newAdvisor.length() > 20 || newAdvisor.isEmpty());  
   
            sqlstr = ("Update student SET " + "thesisAdvisor" +
                    "= "+ "\"" + newAdvisor + "\"" + " WHERE studentID = " + studentID);
        }
       
        try {
            
            regiConnect stuConn = new regiConnect();
            stmt = stuConn.makeStatement();
           
            stmt.execute(sqlstr);
           
            stmt.close();
            stuConn.close();
        }
       
        catch (SQLException e){
            
            e.printStackTrace();
            System.err.println("Student could not be updated.");
        }
       
        System.err.println("Successfully Existing Student Updated.");
    } // Update
    
     
    //override the method that deletes student from the DB
    @Override
    public void delete(){
                
        Statement stmt = null;
                
        try {
            
            regiConnect stuConn = new regiConnect();
            stmt = stuConn.makeStatement();

            //Create SQL statement to delete student

            stmt.execute("Delete From student WHERE studentID = " + getStudentID());
            
            stmt.close();
            stuConn.close();
        }
        catch (SQLException e) {
            
            e.printStackTrace();
            System.err.println("Could not delete Existing Student from the DB");

        }
        System.err.println("Successfully Existing Student deleted from the DB");
     }

    //override the method that queries DB by Student ID
 @Override
 public void query() {
     
     Statement stmt = null;
     ResultSet rs = null;
      
     try  {
         
         regiConnect stuConn = new regiConnect();
         stmt = stuConn.makeStatement();
         String sqlst = "Select * FROM student WHERE studentID = " + getStudentID();
         rs = stmt.executeQuery(sqlst);
         
         // result set returned and printed
         
         while(rs.next()) {
             this.setStudentID(rs.getInt("studentID"));
             this.setFirstName(rs.getString("firstName"));
             this.setLastName(rs.getString("lastName"));
             this.setGpa(rs.getFloat("gpa"));
             this.setStatus(rs.getString("status"));
             this.setMentor(rs.getString("mentor"));
             this.setThesis(rs.getString("thesisTitle"));
             this.setAdvisor(rs.getString("thesisAdvisor"));
         }
         
         // Close the result set, statement and the connection
         rs.close();
         stmt.close();
         stuConn.close();
     }
     catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Could not retrieve any information : SQL ERROR");
     }
     
     //use the toString method to print the object on screen
     System.out.println(this.toString());
 }
  
    //override the method that queries DB by Student ID
 @Override
 public void queryAll() {
     
     Statement stmt = null;
     ResultSet rs = null;
      
     try  {
         
         regiConnect stuConn = new regiConnect();
         stmt = stuConn.makeStatement();
         String sqlst = "Select * FROM Membres WHERE membID = " + getStudentID();
         rs = stmt.executeQuery(sqlst);
         
         // result set returned and printed
         
         while(rs.next()) {
             this.setStudentID(rs.getInt("membID"));
             this.setFirstName(rs.getString("preNom"));
             this.setLastName(rs.getString("postNom"));
             this.setGpa(rs.getFloat("sexe"));
             this.setStatus(rs.getString("ville"));
             this.setMentor(rs.getString("pays"));
             this.setThesis(rs.getString("Tel"));
             this.setAdvisor(rs.getString("email"));
         }
         
         // Close the result set, statement and the connection
         rs.close();
         stmt.close();
         stuConn.close();
     }
     catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Could not retrieve any information : SQL ERROR");
     }
     
     //use the toString method to print the object on screen
     System.out.println(this.toString());
 }
  
 
    // overridden method student Tuition
    @Override
    public double calculateTuition() {
        
        Integer stuCost;
        Integer resCost = 300;
        Integer nresCost = 350;
        
        Integer stuHours;
        Integer stuStat;
        
        calcuTuit = new Scanner(System.in);
       
        
        System.out.println("Calculating Graduate Student Tuition");
        System.out.println("====================================");
        
        // validation Student hours
        do {
            System.out.println("");
            System.err.print("Please Enter Student Hours : ");
            while (!calcuTuit.hasNextInt()) {
                System.out.print("Enter Student Hours : ");
                calcuTuit.next();
            }
            stuHours = calcuTuit.nextInt();
        } while (stuHours <= 0);   // Student Hours > 0 
         
        // validation Student Status (1 = Resident; 2 = Non-Resident)
        do {
            System.out.println("");
            System.err.print("Please Select Student status  (1 or 2) :");
            while (!calcuTuit.hasNextInt()) {
                System.out.print("Enter Student Status : ");
                calcuTuit.next();
            }
            stuStat = calcuTuit.nextInt();
        } while (stuStat <= 0 || stuStat > 2); 
               
       
        if (stuStat.equals(1)) {
            
            stuCost = stuHours * resCost;
        }
        else {
            
            stuCost = stuHours * nresCost;
        }
        
        return stuCost;
    }
 
 //override this mthod to print the variables not in super
 @Override
 public String toString() {
     
     String stud = super.toString();
    
     stud += " " + thesisTitle;
     stud += " " + thesisAdvisor;

     return stud;
 }
}
