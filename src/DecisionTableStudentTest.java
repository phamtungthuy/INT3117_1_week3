import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecisionTableStudentTest {

    @Test
    @Description("Check loan of normal student with gpa < 0")
    public void DecisionTableStudentTest1() {
        Student student = new Student(StudentSituation.NORMAL, -1.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);
    }

    @Test
    @Description("Check loan of normal student with gpa >= 0 and gpa < 2.5")
    public void DecisionTableStudentTest2() {
        Student student = new Student(StudentSituation.NORMAL, 2.4);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("Check loan of normal student with gpa >= 2.5 and gpa < 3.2")
    public void DecisionTableStudentTest3() {
        Student student = new Student(StudentSituation.NORMAL, 2.8);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test

    @Description("Check loan of normal student with gpa >= 3.2 and gpa < 3.6")
    public void DecisionTableStudentTest4() {
        Student student = new Student(StudentSituation.NORMAL, 3.5);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("Check loan of normal student with gpa >= 3.6 and <= 4.0")
    public void DecisionTableStudentTest5() {
        Student student = new Student(StudentSituation.NORMAL, 3.7);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("Check loan of normal student with gpa > 4.0")
    public void DecisionTableStudentTest6() {
        Student student = new Student(StudentSituation.NORMAL, 5.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);
    }

    @Test
    @Description("Check loan of needy student with gpa < 0")
    public void DecisionTableStudentTest7() {
        Student student = new Student(StudentSituation.NEEDY, -1.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);
    }

    @Test
    @Description("Check loan of needy student with gpa >= 0 and < 2.5")
    public void DecisionTableStudentTest8() {
        Student student = new Student(StudentSituation.NEEDY, 2.4);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("Check loan of needy student with gpa >= 2.5 and gpa < 3.2")
    public void DecisionTableStudentTest9() {
        Student student = new Student(StudentSituation.NEEDY, 2.8);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("Check loan of needy student with gpa >= 3.2 and gpa < 3.6")
    public void DecisionTableStudentTest10() {
        Student student = new Student(StudentSituation.NEEDY, 3.5);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 6_000_000);

    }

    @Test
    @Description("Check loan of needy student with gpa >= 3.6 and gpa <= 4.0")
    public void DecisionTableStudentTest11() {
        Student student = new Student(StudentSituation.NEEDY, 3.7);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 12_000_000);
    }


    @Test
    @Description("Check loan of needy student with gpa > 4.0")
    public void DecisionTableStudentTest12() {
        Student student = new Student(StudentSituation.NEEDY, 5.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);

    }

    @Test
    @Description("Check loan of poor student with gpa < 0")
    public void DecisionTableStudentTest13() {
        Student student = new Student(StudentSituation.POOR, -1.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);

    }

    @Test
    @Description("Check loan of poor student with gpa >= 0 and gpa < 2.5")
    public void DecisionTableStudentTest14() {
        Student student = new Student(StudentSituation.POOR, 2.4);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("Check loan of poor student with gpa >= 2.5 and gpa < 3.2")
    public void DecisionTableStudentTest15() {
        Student student = new Student(StudentSituation.POOR, 2.8);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 6_000_000);
    }

    @Test
    @Description("Check loan of poor student with gpa >= 3.2 and gpa < 3.6")
    public void DecisionTableStudentTest16() {
        Student student = new Student(StudentSituation.POOR, 3.5);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 12_000_000);
    }

    @Test
    @Description("Check loan of poor student with gpa >= 3.6 and gpa <= 4.0")
    public void DecisionTableStudentTest17() {
        Student student = new Student(StudentSituation.POOR, 3.7);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 15_000_000);
    }


    @Test
    @Description("Check loan of poor student with gpa > 4")
    public void DecisionTableStudentTest18() {
        Student student = new Student(StudentSituation.POOR, 5.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);
    }
}