package prog6112_ta1_pt1;


public class ABCStudentManagementApp {
    Student st = new Student();
    
    public static void main(String[] args) {
        ABCStudentManagementApp MA = new ABCStudentManagementApp();
        MA.run();
    }
    
    public void run(){
        st.intro();
        st.menu();
    }
}
