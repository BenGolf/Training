/**
 * Part_Time subclass, inherited from Student
 * with additional attribute: company.
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


 //  Part-Time class extends Super class Student.

public class Part_Time extends Student {
    
    private String company;
    private String thesisTitle;
    private String thesisAdvisor;
	private Scanner addintext;
	private Scanner addinint;
	private Scanner updateint;
	private Scanner updatetext;
	private String output;
	private String output2;
	private Scanner calcuTuit;
    
    //Default constructor
    
    public Part_Time() {
    
        super();
        company = "";
   
    }
    
    //setter and getter
    
    public void setCompany(String stuCompany) {
    
        company  = stuCompany;
   }

   public String getCompany() {
    
        return company;
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
        Float stuGpa = 0.00f;
        String stuMentor = "";
        String stuStatus = "";
        String stuCompany = "";
                 
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
            System.err.print("Enter the GPA  (Float) : ");
            while (!addinint.hasNextFloat()) {
                System.out.print("Please Enter the Status : ");
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
            
         
        // validating Company  - not null and max 20 chars
        
        do {
            
            System.out.println("");
            System.err.print("Enter the Company Name (20 Chars Max) : ");
            while (!addintext.hasNextLine()) {
                System.out.print("Please Enter the Company : ");
                addintext.nextLine();
            }
            stuCompany = addintext.nextLine();
        } while (stuCompany.length() > 20 || stuCompany.isEmpty());                  
        
            
        String stuThesis = "NA";   // Not Applicable, but NOT NULL
        String stuAdvisor = "NA";   // Not Applicable, but NOT NULL
        String stuLevel = "NA"; // Not Applicable, but NOT NULL
            
        try {
            
            regiConnect stuConn = new regiConnect();
            stmt = stuConn.makeStatement();
            
            // SQL statement to insert  New  UnderGraduate Student
            
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
        String newCompany = "";
        
        System.out.println("Updating an Existing Part_Time");
        System.out.println("==============================");
             
        System.out.println("1: First Name");
        System.out.println("2: Last Name");
        System.out.println("3: Gpa");
        System.out.println("4: Status");
        System.out.println("5: Mentor");
        System.out.println("6: Company");
      
        // validation Choice Field to update
        do {
        System.out.println("");
        System.err.print("Please Choose Field To Update: ");
        while (!updateint.hasNextInt()) {
            System.err.print("Part_Time Field between 1 to 6, Try again : ");
            updateint.next();
        }
        stuChoice = updateint.nextInt();
        } while (stuChoice <= 0 || stuChoice > 6);   // Field to update (1,2,3,4,5,6) 
        
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
        
        } else {
             
            do {
                
                System.out.println("");
                System.err.print("Enter Student New Company (20 Chars Max) : ");
                while (!updatetext.hasNextLine()) {
                    System.out.print("Please Enter New Company : ");
                    updatetext.nextLine();
                }
                newCompany = updatetext.nextLine();
            } while (newCompany.length() > 20 || newCompany.isEmpty());  
   
            sqlstr = ("Update student SET " + "company" +
                    "= "+ "\"" + newCompany + "\"" + " WHERE studentID = " + studentID);
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
    } // Update Part_Time Student
    
     
    //override the method that deletes student from the DB

    @Override
    public void delete() {
    
        Statement stmt = null;

        try  {
        
            regiConnect stuConn = new regiConnect();
            stmt = stuConn.makeStatement();

            //Create SQL statement to delete

            stmt.execute("Delete From student WHERE studentID = " +getStudentID());

            stmt.close();
            stuConn.close();
        }
        catch (SQLException e) {
        
            e.printStackTrace();
            System.err.println("Could not delete existing Student from the DB");

         }
        System.out.println("Successfully Existing Student deleted from the DB");
     }

    //override the method that queries db by student ID
 @Override
 public void query() {
 
        Statement stmt = null;
        ResultSet rs = null;
        setOutput(" ");

    try  {
        
        regiConnect stuConn = new regiConnect();
        stmt = stuConn.makeStatement();
        String sqlst = "Select * FROM student WHERE studentID = " + getStudentID();
        rs = stmt.executeQuery(sqlst);
        
        //Parse the result set returned and print
        
        while(rs.next()) {
            
            this.setStudentID(rs.getInt("studentID"));
            this.setFirstName(rs.getString("firstName"));
            this.setLastName(rs.getString("lastName"));
            this.setGpa(rs.getFloat("gpa"));
            this.setStatus(rs.getString("status"));
            this.setMentor(rs.getString("mentor"));
            this.setCompany(rs.getString("company"));
        }
        
        // Close the result set, statement and the connection
        rs.close();
        stmt.close();
        stuConn.close();
        stuConn.close();
    }
    catch (SQLException e) {
                
        e.printStackTrace();
        System.err.println("Could not retrieve any information : SQL ERROR");
    }
        
    //use the toString method to print the object on screen
    System.out.println(this.toString());
 }
   
 
    //override the method that queries db by student ID
 @Override
 public void queryAll() {
 
        Statement stmt = null;
        ResultSet rs = null;
        setOutput2(" ");

    try  {
        
        regiConnect stuConn = new regiConnect();
        stmt = stuConn.makeStatement();
        String sqlst = "Select * FROM student WHERE studentID = " + getStudentID();
        rs = stmt.executeQuery(sqlst);
        
        //Parse the result set returned and print
        
        while(rs.next()) {
            
            this.setStudentID(rs.getInt("studentID"));
            this.setFirstName(rs.getString("firstName"));
            this.setLastName(rs.getString("lastName"));
            this.setGpa(rs.getFloat("gpa"));
            this.setStatus(rs.getString("status"));
            this.setMentor(rs.getString("mentor"));
            this.setCompany(rs.getString("company"));
        }
        
        // Close the result set, statement and the connection
        rs.close();
        stmt.close();
        stuConn.close();
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
        Integer resCost = 250;
        Integer nresCost = 450;    
        Integer stuHours;
        Integer stuStat;
       
        calcuTuit = new Scanner(System.in);    
       
        System.out.println("Calculating Part_Time Student Tuition");
        System.out.println("=====================================");
        
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
        
        } else {
            
            stuCost = stuHours * nresCost;
        }
        
        return stuCost;
    }
          
 //override this method to print the variables not in super
 @Override
 public String toString() {
     
     String stud = super.toString();
    
     stud += " " + company;
     return stud;
 }

public String getThesisTitle() {
	return thesisTitle;
}

public void setThesisTitle(String thesisTitle) {
	this.thesisTitle = thesisTitle;
}

public String getThesisAdvisor() {
	return thesisAdvisor;
}

public void setThesisAdvisor(String thesisAdvisor) {
	this.thesisAdvisor = thesisAdvisor;
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