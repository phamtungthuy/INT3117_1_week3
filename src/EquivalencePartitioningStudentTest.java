import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquivalencePartitioningStudentTest {
    @Test
    @Description("(normal student, gpa < 0)")
    public void EquivalencePartitioningStudentTest1() {
        Student student = new Student(StudentSituation.NORMAL, -1.0);
        assertThrows(RuntimeException.class, student::isEligibleForLoan);
        assertThrows(RuntimeException.class, student::getLoanAmount);
    }

    @Test
    @Description("(needy student, 0 <= gpa < 3.2)")
    public void EquivalencePartitioningStudentTest2() {
        Student student = new Student(StudentSituation.NEEDY, 3.0);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("(needy student, 3.2 <= gpa < 3.6)")
    public void EquivalencePartitioningStudentTest3() {
        Student student = new Student(StudentSituation.NEEDY, 3.5);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 6_000_000);
    }

    @Test
    @Description("(needy student, 3.6 <= gpa <= 4.0)")
    public void EquivalencePartitioningStudentTest4() {
        Student student = new Student(StudentSituation.NEEDY, 3.9);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 12_000_000);
    }

    @Test
    @Description("(poor student, 0 <= gpa < 2.5)")
    public void EquivalencePartitioningStudentTest5() {
        Student student = new Student(StudentSituation.POOR, 2.3);
        assertFalse(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 0);
    }

    @Test
    @Description("(poor student, 2.5 <= gpa < 3.2)")
    public void EquivalencePartitioningStudentTest6() {
        Student student = new Student(StudentSituation.POOR, 3.1);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 6_000_000);
    }

    @Test
    @Description("(poor student, 3.2 <= gpa < 3.6)")
    public void EquivalencePartitioningStudentTest7() {
        Student student = new Student(StudentSituation.POOR, 3.3);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 12_000_000);
    }

    @Test
    @Description("(poor student, 3.6 <= gpa <= 4.0)")
    public void EquivalencePartitioningStudentTest8() {
        Student student = new Student(StudentSituation.POOR, 3.6);
        assertTrue(student.isEligibleForLoan());
        assertEquals(student.getLoanAmount(), 15_000_000);
    }
}
