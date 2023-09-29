package prog6112_ta1_pt1;


public class ABCStudentManagementApp {
    Student st = new Student();
    
    public static void main(String[] args) {
        //setting up object to run the non-static methods from other classes.
        ABCStudentManagementApp MA = new ABCStudentManagementApp();
        MA.run();
    }
    
    public void run(){
        //calling the methods from the Student class
        st.intro();
        st.menu();
    }
}
