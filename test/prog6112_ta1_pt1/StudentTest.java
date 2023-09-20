package prog6112_ta1_pt1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class StudentTest {
    
    @Before
    public void setUp() {
 
    }
        

    @Test
    public void testSaveStudent() {
        //add variables manually for test
        //test against what is saved
        Student st = new Student();
        st.studentId.add(1001);
        st.studentName.add(0,"John");
        st.studentAge.add(0,21);
        st.studentEmail.add(0,"johnDoe@gmail.com");
        st.studentCourse.add(0,"BCAD");
        
        assertEquals(1001, st.studentId);
    }
    
    @Test
    public void testSearchStudent() {
        
    }
    
    @Test
    public void testSearchStudent_StudentNotFound() {
        
    }
    
    @Test
    public void testDeleteStudent() {
        
    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound() {
        
    }
    
    @Test
    public void TestStudentAge_StudentAgeValid() {
        
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        
    }
    
}
