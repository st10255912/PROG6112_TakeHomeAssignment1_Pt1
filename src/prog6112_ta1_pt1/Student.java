package prog6112_ta1_pt1;

import java.util.ArrayList;
import java.util.Scanner;


public class Student {
    Scanner kb = new Scanner(System.in);
    String fileName = "Student_Details.txt";
    
    private int menuChoice;
    private String input;
    private int index;
    
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
    
    
    
    //Menu to choose options
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
        }else
            System.out.println("Thank you for using this program. Bye!");
        
        switch(menuChoice) {
            case 1:
                saveStudent();
                break;
            case 2:
                searchStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                studentReport();
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
    public void saveStudent() {
        System.out.println("CAPTURE A NEW STUDENT\n"
                        + "*****************************");
        
        //Capture student ID
        System.out.print("Enter the student id: ");
        studentId.add(index,kb.nextInt());
        
        //Capture student name
        System.out.print("Enter the student name: ");
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
    private int getStudentAge(Scanner kb) {
        while(true) {
            try {
                int tempStudentAge = Integer.parseInt(kb.next());
                
                if(StudentAge_StudentAgeValid(tempStudentAge)) {
                    return tempStudentAge;
                }else
                    StudentAge_StudentAgeInvalid(); 
               
            }catch (NumberFormatException e) {
                StudentAge_StudentAgeInvalidCharacter();
            }
        }
    }
    
    private boolean StudentAge_StudentAgeValid(int studentAge) {
        return studentAge > 16;
    }
    
    public void StudentAge_StudentAgeInvalid() {
        System.out.print("You have entered a incorrect age!!!\nPlease re-enter the student age >> ");
    }
    
    public void StudentAge_StudentAgeInvalidCharacter() {
        System.out.print("You have entered a incorrect age!!!\nPlease re-enter the student age >> ");
    }
    
    
    
    //Searching
    public void searchStudent() {
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
                searchStudent_StudentNotFound(searchId);
        }
        menu();
    }
    
    public void searchStudent_StudentNotFound(int searchId) {
        System.out.println("Student with Student Id: " + searchId + " was not found!");
    }
    
    
    
    //Deleting
    public void deleteStudent() {
        System.out.print("Enter the student id to delete: ");
        int deleteId = kb.nextInt();
        
        for (int i = 0; i < studentId.size(); i++) {
            if(deleteId == studentId.get(i)) {
                System.out.println("Are you sure you want to delete student " + deleteId + " from the system?"
                                    + " Yes (y) to delete.");
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
                        deleteStudent();
                        break;
                }
            }else
                deleteStudent_StudentNotFound(deleteId);
        }
        menu();
    }
    
    public void deleteStudent_StudentNotFound(int deleteId) {
        System.out.println("Student with Student Id: " + deleteId + " was not found!");
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
