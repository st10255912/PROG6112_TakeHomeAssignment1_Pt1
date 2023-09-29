package prog6112_ta1_pt1;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class StudentTest {
    Student st = new Student();
        

    @Test
    public void testSaveStudent() {
//        int expectedStudentNum = 10111;
//        String expectedName = "John Boggs";
//        int expectedAge = 21;
//        String expectedEmail = "johnBoggs@ymail.com";
//        String expectedCourse = "bcad";
//        
//        Scanner kb = new Scanner("10111\nJ.Boggs\n21\njohnBoggs@ymail.com\nbcad");
//        
//        st.saveStudent(kb);
        
//        assertEquals("10111", st.studentId.get(0));
//        assertEquals("J.Boggs", st.studentName.get(0));
//        assertEquals("21", st.studentAge.get(0));
//        assertEquals("johnBoggs@ymail.com", st.studentEmail.get(0));
//        assertEquals("bcad", st.studentCourse.get(0));
    }
    
    @Test
    public void testSearchStudent() {
//        //create student info
//        Scanner kb = new Scanner("10111\nJ.Boggs\n21\njohnBoggs@ymail.com\nbcad");
//        
//        //save student info
//        st.saveStudent(kb);
//        
//        st.searchStudent(kb);
        
//        assertEquals("10111", st.studentId.get(0));
//        assertEquals("J.Boggs", st.studentName.get(0));
//        assertEquals("21", st.studentAge.get(0));
//        assertEquals("johnBoggs@ymail.com", st.studentEmail.get(0));
//        assertEquals("bcad", st.studentCourse.get(0));

    }
    
    @Test
    public void testSearchStudent_StudentNotFound() {
        String expectedOutput = "Student with Student Id: 10111 was not found!";
        
        assertEquals(expectedOutput, st.searchStudent_StudentNotFound(10111));
    }
    
    @Test
    public void testDeleteStudent() {
//        Student stu = new Student();
//        
//        //create student info
//        Scanner kb = new Scanner("121\nMatthew\n21\nnah@gmail.com\nBCAD");
//        
//        //save student info
//        st.saveStudent(kb);
//        
//        //search for student

    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound() {
        String expectedOutput = "Student with Student Id: 10111 was not found!";
        
        assertEquals(expectedOutput, st.deleteStudent_StudentNotFound(10111));
    }
    
    @Test
    public void TestStudentAge_StudentAgeValid() {
        
        // Test valid age
        assertTrue(st.StudentAge_StudentAgeValid(18));
        assertFalse(st.StudentAge_StudentAgeValid(6));
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalid() {

        assertTrue(st.StudentAge_StudentAgeInvalid(15));
        assertFalse(st.StudentAge_StudentAgeInvalid(21));
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        String expectedOutput = "You have entered a incorrect age!!!\nPlease re-enter the student age >> ";
        
        assertEquals(expectedOutput, st.StudentAge_StudentAgeInvalidCharacter());
    }
    
}
