/* Student class,  abstract,and super class*/
package wguregistudent;

 /**
  *
  * @author : Bernard Nsabimana
  * Western Governors University (WGU)
  * BS - IT
  * Instructors : Pubali Banerjee / Cynthia Lang
  * written : April 2013
  * Course : Object Oriented Design and Development (Java)
 */

 //  Superclass for this application, Abstract class with several abstract methods

  public abstract class Student {
 
    protected  Integer studentID;
    protected  String firstName;
    protected  String lastName;
    protected  Float gpa;
    protected  String status;
    protected  String mentor;


    // default constructor
    Student() {
        
        studentID = 0;
        firstName = "";
        lastName  = "";
        gpa = 0.00f;
        status = "";
        mentor = "";
    }
    
    // setters methods

    public  void setStudentID(Integer stuID){
        studentID = stuID;
    }

    public void setFirstName(String stuFirst){
         firstName = stuFirst;
    }
    public void setLastName(String stuLast){
         lastName = stuLast;
    }

    public  void setGpa(float stuGpa){
        gpa = stuGpa;
    }

    public  void setStatus(String stuStatus){
        status = stuStatus;
    }

    public void setMentor(String stuMentor){
        mentor = stuMentor;
    }
    
    //getters methods

    public Integer getStudentID(){
        return studentID;
    }

    public String getFirst(){
        return firstName;
    }

    public String getLast(){
        return lastName;
    }

    public float getGpa(){
        return gpa;
    }

    public String getStatus(){
        return status;
    }

    public String getMentor(){
        return mentor;
    }
    
    // abstract method to calculate Student Tuition
    public abstract double calculateTuition();
  
    // update method, abstract method to update an existing record in student table when called
    public abstract void update();

    // add method, abstract method to create a new record in student table when called
    public abstract void add();

    // delete method, abstract method to delete an existing record in student table when called
    public abstract void delete();

    // query method, abstract method to retrieve students' information, and printed to the screen when called
    public abstract void query();
    
     // query method, abstract method to retrieve Moto records
    public abstract void queryAll();  

    //override the toString method to print out Student object
    @Override
    public String toString() {
        
        String stud = "Student ID:  " + studentID + "\n";
     //   stud += "  First Name    Last  Name    Gpa    Status    Mentor  "+ "\n";        
          
        stud += "  " + firstName;
        stud += "  " + lastName;
        stud += "  " + gpa;
        stud += "  " + status;
        stud += "  " + mentor;
       
        return stud;
    }
  }