package prog6112_ta1_pt1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Student {
    //making the scanner object global, makes it easier to just use it throughout the class
    Scanner kb = new Scanner(System.in);
    
    //setting up variables
    private int menuChoice;
    private String input;
    private int index;
    
    
    /*
        setting up the array lists, because there is no indication as to how many students 
        will be allowed to be registered on the application.
    */
    ArrayList <Integer> studentId = new ArrayList <Integer> ();
    ArrayList <String> studentName = new ArrayList <String> ();
    ArrayList <Integer> studentAge = new ArrayList <Integer> ();
    ArrayList <String> studentEmail = new ArrayList <String> ();
    ArrayList <String> studentCourse = new ArrayList <String> ();
    
    //Introduction for program
    public void intro() {
        System.out.println("STUDENT MANAGEMENT APPLICATION\n"
                        + "***************************************");
    }
    
    /*
        a menu is displayed, from which, the user can choose one of the 5 options:
    
        1. add a new student
            -enter their student number
            -enter their name
            -enter their age
            -enter their email
            -enter their course
        2. allows the user to search for a student via their student number.
           Their student details will be displayed if the student is on the 
           system, otherwise, it will display a student not found message.
        3. similar to the search student method in how it locates specific 
           students, however, rather than displaying student details, it 
           gives the user the option to delete the student from the application
           there is also a confirmation step to ensure that there is no 
           accidental deletion of students from the application.
        4. Displays the details of all students on the application
        5. Exits the application.
    */
    public void menu() {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int launchInput = kb.nextInt();
        
        if(launchInput == 1) {
            System.out.println("Please select one of the following menu items:\n"
                            + "(1) Capture a new student.\n"
                            + "(2) Search for a student.\n"
                            + "(3) Delete a student.\n"
                            + "(4) Print Student Report.\n"
                            + "(5) Exit Application.");
            menuChoice = kb.nextInt();
        }else {
            System.out.println("Thank you for using this program. Bye!");
            exitStudentApplication();
        }
        
        switch(menuChoice) {
            case 1:
                saveStudent(kb);
                break;
            case 2:
                if(index != 0) {
                    searchStudent(kb);
                }else {
                    System.out.println("No students in system.");
                    menu();
                }
                break;
            case 3:
                if(index != 0) {
                    deleteStudent(kb);
                }else {
                    System.out.println("No students in system.");
                    menu();
                }
                break;
            case 4:
                if(index != 0) {
                    studentReport();
                }else {
                    System.out.println("No students in system.");
                    menu();
                }
                break;
            case 5:
                exitStudentApplication();
                break;
            default:
                System.out.println("Invalid! Please enter a valid option.");
                menu();
                break;
        }
    }
    
    //Saving variables
    public void saveStudent(Scanner kb) {
        System.out.println("CAPTURE A NEW STUDENT\n"
                        + "*****************************");
        
        //Capture student ID
        System.out.print("Enter the student id: ");
        studentId.add(index,kb.nextInt());
        
        //Capture student name
        System.out.print("Enter the student name (Eg: J.Boggs): ");
        studentName.add(index,kb.next());
        
        //Capture student age
        System.out.print("Enter student age: ");
        studentAge.add(index,getStudentAge(kb));
        
        //Capture student email
        System.out.print("Enter the student email: ");
        studentEmail.add(index,kb.next());
        
        //Capture student course
        System.out.print("Enter the student course: ");
        studentCourse.add(index,kb.next());
        
        System.out.println("Student details successfully saved.");
        index++;
        menu();
    }
    
    //Student Age validation
    public int getStudentAge(Scanner kb) {
         while(true) {
            try {
                int tempStudentAge = Integer.parseInt(kb.next());
                
                if(StudentAge_StudentAgeValid(tempStudentAge) == true) {
                    return tempStudentAge;
                }else if(StudentAge_StudentAgeInvalid(tempStudentAge) == true) {
                    System.out.print("You have entered a incorrect age!!!\nPlease re-enter the student age >> ");
                }
            }catch (NumberFormatException e) {
                System.out.println(StudentAge_StudentAgeInvalidCharacter());
            }
        }
    }
    
    public boolean StudentAge_StudentAgeValid(int tempStudentAge) {
        if(tempStudentAge > 16){
            return true;
        }else 
            return false;
    }
    
    public boolean StudentAge_StudentAgeInvalid(int tempStudentAge) {
        if(tempStudentAge < 16){
            return true;
        }else 
            return false;
    }
    
    public String StudentAge_StudentAgeInvalidCharacter() {
        return "You have entered a incorrect age!!!\nPlease re-enter the student age >> ";
    }
    
    //Searching
    public void searchStudent(Scanner kb) {
        System.out.print("Enter the student id to search: ");
        int searchId = kb.nextInt();
        
        for (int i = 0; i < studentId.size(); i++) {
            if(searchId == studentId.get(i)) {
                System.out.println("\n-----------------------------------------"
                            + "\nSTUDENT ID: " + studentId.get(i)
                            + "\nSTUDENT NAME: " + studentName.get(i)
                            + "\nSTUDENT AGE: " + studentAge.get(i)
                            + "\nSTUDENT EMAIL: " + studentEmail.get(i)
                            + "\nSTUDENT COURSE: " + studentCourse.get(i)
                            + "\n-----------------------------------------");
            }else
                System.out.println(searchStudent_StudentNotFound(searchId));
        }
        menu();
    }
    
    public String searchStudent_StudentNotFound(int searchId) {
        return "Student with Student Id: " + searchId + " was not found!";
    }
    
    //Deleting
    public void deleteStudent(Scanner kb) {
        System.out.print("Enter the student id to delete: ");
        int deleteId = kb.nextInt();
        
        for (int i = 0; i < studentId.size(); i++) {
            if(deleteId == studentId.get(i)) {
                System.out.println("Are you sure you want to delete student " + deleteId + " from the system?"
                                    + " Yes (y) to delete or No (n) to cancel deletion.");
                String choice = kb.next().toLowerCase();
                switch(choice) {
                    case "y":
                        studentId.remove(i);
                        studentName.remove(i);
                        studentAge.remove(i);
                        studentEmail.remove(i);
                        studentCourse.remove(i);
                    
                        System.out.println("-----------------------------------------\n"
                                + "Student with Student Id: " + deleteId + " WAS deleted!\n"
                                + "-----------------------------------------");
                        break;
                    case "n":
                        System.out.println("-----------------------------------------\n"
                                + "Student with Student Id: " + deleteId + " WAS NOT deleted!\n"
                                + "-----------------------------------------");
                        break;
                    default:
                        System.out.println("-----------------------------------------\n"
                                + "Invalid! Please enter yes (y) or no (n)."
                                + "-----------------------------------------");
                        deleteStudent(kb);
                        break;
                }
            }else
                System.out.println(deleteStudent_StudentNotFound(deleteId));
        }
        menu();
    }
    
    public String deleteStudent_StudentNotFound(int deleteId) {
        return "Student with Student Id: " + deleteId + " was not found!";
    }
    
    //Report
    public void studentReport() {
        for (int i = 0; i < studentId.size(); i++) {
            System.out.println("STUDENT " + (i+1) 
                            + "\n-----------------------------------------"
                            + "\nSTUDENT ID: " + studentId.get(i)
                            + "\nSTUDENT NAME: " + studentName.get(i)
                            + "\nSTUDENT AGE: " + studentAge.get(i)
                            + "\nSTUDENT EMAIL: " + studentEmail.get(i)
                            + "\nSTUDENT COURSE: " + studentCourse.get(i)
                            + "\n-----------------------------------------");
        }
        menu();
    }
    
    //Exit
    public void exitStudentApplication() {
        System.exit(0);
    }
}
