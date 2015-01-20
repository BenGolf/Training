//Tester class for Registrar Student application
package wguregistudent;

import java.util.Scanner;  // import 

/**
*
* @author : Bernard Nsabimana
* Western Governors University (WGU)
* BS - IT
* Instructors : Pubali Banerjee / Cynthia Lang
* written : April 2013
* Course : Object Oriented Design and Development (Java)
*/

// this is the tester class that uses the other classes

public class RegiStudent {

private static Scanner menuint;
private static Scanner addinint;
private static Scanner addinint2;
private static Scanner addinint3;
private static Scanner queryint;
private static Scanner queryint2;
private static Scanner calcuTuit;


public static void main(String[] args) {
    
    Integer stuOption = 0;
    menuint = new Scanner(System.in);
           
    do {
        
        // Display main menu 
        System.out.println(" ----------------------------------- ");
        System.err.println("|    STUDENT MAIN MENU              |");
        System.out.println(" ----------------------------------- ");
        System.out.println("|  Options:                         |");
        System.out.println("|        1. Add Student             |");
        System.out.println("|        2. Update Student          |");
        System.out.println("|        3. Delete Student          |");
        System.out.println("|        4. Query Any Student       |");
        System.out.println("|        5. Student Tuition         |");  
        System.out.println("|        7. Moto Query Test         |");             
        System.out.println("|        6. Exit                    |");
        System.out.println(" ----------------------------------- ");
        
        System.err.print(" Select One Option for your Choice : ");
        
        try {
            
            stuOption = menuint.nextInt();
            Integer.valueOf(stuOption).intValue();
        }
        catch (NumberFormatException e) {
            
            System.err.println("Invalid input. Not an integer");
        }
        // Switch construct
        switch (stuOption) {
            
            case 6:   // Exit
                System.exit(0);
                
            case 1:      // add Student
                AddStudent();
                break;
            case 2:      // update Student
                UpdateStudent();
                break;
            case 3:      // delete Student
                DeleteStudent();
                break;
            case 4:      // query Student by ID
                QueryStudent();
                break;
            case 5:      // Calculate Student Tuition
                TuitionStudent();
                break;
             case 7:      // query All Moto Records
                QueryMoto();
                break;                  
            default:
            break;
        }
    }
    while (stuOption != 6);  // while loop
    
} //main loop

public static void AddStudent() {

addinint = new Scanner(System.in);
Integer stuCat = 0;

// validation Category Student
do {
    System.out.println("");
    System.err.print("Student Category (1. Graduate 2. UnderGraduate  3. Part_Time): ");
    while (!addinint.hasNextInt()) {
        System.err.print("studentID  Category Must be a Number (1, 2, or 3): ");
        addinint.next();
    }
    stuCat = addinint.nextInt();
} while (stuCat <= 0 || stuCat > 3);   // Student Category  is a positive number (1, 2, and 3) 
     
if (stuCat.equals(1)) {   // Graduate
    
    Graduate GradStudent = new Graduate();
    GradStudent.add();
    
} else if (stuCat.equals(2)) {  // UnderGraduate
    
    UnderGraduate UGradStudent = new UnderGraduate();
    UGradStudent.add();

} else {  // Part_Time

    Part_Time PartStudent = new Part_Time();
    PartStudent.add();
}
   
}  // Add Student


public static void UpdateStudent(){

addinint2 = new Scanner(System.in);
Integer stuID = 0;
Integer stuCat = 0;

// validation Student ID
do {
    System.out.println("");
    System.err.print("Please Enter the Unique Student : ");
    while (!addinint2.hasNextInt()) {
        System.err.print("studentID  Must be a positive Number :");
        addinint2.next();
    }
    stuID = addinint2.nextInt();
} while (stuID <= 0);   // StudentID has to be Greater than Zero 

// Select and validation Category Student
do {
    System.out.println("");
    System.err.print("Student Category (1. Graduate 2. UnderGraduate  3. Part_Time): ");
    while (!addinint2.hasNextInt()) {
        System.err.print("studentID  Category Must be a Number (1, 2, or 3): ");
        addinint2.next();
    }
    stuCat = addinint2.nextInt();
} while (stuCat <= 0 || stuCat > 3);   // Student Category  is a positive number (1, 2, and 3) 

if (stuCat.equals(1)) {    // Graduate  Student 
    
    Graduate GradStudent = new Graduate();
    GradStudent.setStudentID(stuID);
    GradStudent.update();
    
}
else if (stuCat.equals(2)) {   // UnderGraduate Student
    
    UnderGraduate UGradStudent = new UnderGraduate();
    UGradStudent.setStudentID(stuID);
    UGradStudent.update();

}
else {   // Part_Time Student
    
    Part_Time PartStudent = new Part_Time();
    PartStudent.setStudentID(stuID);
    PartStudent.update();
}
  
}  // update any  Student's Field

public static void DeleteStudent() {

addinint3 = new Scanner(System.in);
Integer stuID = 0;
Integer stuCat = 0;

// validation Student ID
do {
    System.out.println("");
    System.err.print("Please Enter the Unique Student : ");
    while (!addinint3.hasNextInt()) {
        System.err.print("studentID  Must be a positive Number :");
        addinint3.next();
    }
    stuID = addinint3.nextInt();
} while (stuID <= 0);   // StudentID has to be Greater than Zero 

// validation Category Student
do {
    System.out.println("");
    System.err.print("Student Category (1. Graduate 2. UnderGraduate  3. Part_Time): ");
    while (!addinint3.hasNextInt()) {
        System.err.print("studentID  Category Must be a Number (1, 2, or 3): ");
        addinint3.next();
    }
    stuCat = addinint3.nextInt();
} while (stuCat <= 0 || stuCat > 3);   // Student Category  is a positive number (1, 2, and 3) 
 
if (stuCat.equals(1)) {   // Delete Graduate  Student
    
    Graduate GradStudent = new Graduate();
    GradStudent.setStudentID(stuID);
    GradStudent.delete();
    
} else if (stuCat.equals(2)) {   // UnderGraduate Student 

    UnderGraduate UGradStudent = new UnderGraduate();
    UGradStudent.setStudentID(stuID);
    UGradStudent.delete();

} else {   // Part_Time Student

    Part_Time PartStudent = new Part_Time();
    PartStudent.setStudentID(stuID);
    PartStudent.delete();
}
}  // Delete any type of Student

public static void QueryStudent() {  // queryStudent method for any type of Student

queryint = new Scanner(System.in);
Integer stuID = 0;
Integer stuCat = 0;

// validation Student ID
do {
    System.out.println("");
    System.err.print("Please Enter the Unique Student : ");
    while (!queryint.hasNextInt()) {
        System.err.print("studentID  Must be a positive Number :");
        queryint.next();
    }
    stuID = queryint.nextInt();
} while (stuID <= 0);   // StudentID has to be Greater than Zero 

// validation Category Student
do {
    System.out.println("");
    System.err.print("Student Category (1. Graduate 2. UnderGraduate  3. Part_Time): ");
    while (!queryint.hasNextInt()) {
        System.err.print("studentID  Category Must be a Number (1, 2, or 3): ");
        queryint.next();
    }
    stuCat = queryint.nextInt();
} while (stuCat <= 0  || stuCat > 3);   // Student Category  is a positive number (1, 2, and 3) 
 
if(stuCat.equals(1)) {
    
    Graduate GradStudent = new Graduate();
    GradStudent.setStudentID(stuID);
    GradStudent.query();
}
else if(stuCat.equals(2)) {
    
    UnderGraduate UGradStudent = new UnderGraduate();
    UGradStudent.setStudentID(stuID);
    UGradStudent.query();
} else {
    
    Part_Time PartStudent = new Part_Time();
    PartStudent.setStudentID(stuID);
    PartStudent.query();
}
}  // Querying any type of Student


public static void QueryMoto() {  // queryMoto method for All records

queryint2 = new Scanner(System.in);
Integer stuID = 0;
Integer stuCat = 0;

// validation Student ID
do {
    System.out.println("");
    System.err.print("Please Enter the Unique Student : ");
    while (!queryint2.hasNextInt()) {
        System.err.print("studentID  Must be a positive Number :");
        queryint2.next();
    }
    stuID = queryint2.nextInt();
} while (stuID <= 0);   // StudentID has to be Greater than Zero 

// validation Category Student
do {
    System.out.println("");
    System.err.print("Student Category (1. Graduate 2. UnderGraduate  3. Part_Time): ");
    while (!queryint2.hasNextInt()) {
        System.err.print("studentID  Category Must be a Number (1, 2, or 3): ");
        queryint2.next();
    }
    stuCat = queryint2.nextInt();
} while (stuCat <= 0  || stuCat > 3);   // Student Category  is a positive number (1, 2, and 3) 
 
if(stuCat.equals(1)) {
    
    Graduate GradStudent = new Graduate();
    GradStudent.setStudentID(stuID);
    GradStudent.queryAll();
}
else if(stuCat.equals(2)) {
    
    UnderGraduate UGradStudent = new UnderGraduate();
    UGradStudent.setStudentID(stuID);
    UGradStudent.queryAll();
} else {
    
    Part_Time PartStudent = new Part_Time();
    PartStudent.setStudentID(stuID);
    PartStudent.queryAll();
}
}  // Querying Moto records


public static void TuitionStudent()  {     // Calculate Student Tuition

calcuTuit = new Scanner(System.in);
Integer stuCat = 0;
    
// validation Category Student
do {
    System.out.println("");
    System.err.print("Student Category (1. Graduate 2. UnderGraduate  3. Part_Time): ");
    while (!calcuTuit.hasNextInt()) {
        System.err.print("studentID  Category Must be a Number (1, 2, or 3): ");
        calcuTuit.next();
    }
    stuCat = calcuTuit.nextInt();
} while (stuCat <= 0 || stuCat > 3);   // Student Category  is a positive number (1, 2, and 3) 

if (stuCat.equals(1)) {
    
    Graduate GradStudent = new Graduate();
    System.out.println("The Tuition for this Student is : $" + GradStudent.calculateTuition());

} else if (stuCat.equals(2)) {
    
    UnderGraduate UGradStudent = new UnderGraduate();
    System.out.println("The Tuition for this Student is : $" + UGradStudent.calculateTuition());

} else {
    
    Part_Time PartStudent = new Part_Time();
    System.out.println("The Tuition for this Student is : $" + PartStudent.calculateTuition());
}
}  // Calculating Student  Tuition
}