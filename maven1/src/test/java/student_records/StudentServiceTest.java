package Testing.student_records;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    StudentService service;
    Student s1;

    @BeforeEach
    void setup() {
        service = new StudentService();
        s1 = new Student("Ravi", 101, "TY", "CSE", 5, "2025-26");
        service.addStudent(s1);
    }

    // ---------- ADD / FETCH ----------

    @Test
    void testAddStudent() {
        assertEquals(1, service.count());
    }

    @Test
    void testFetchStudent() {
        Student s = service.getStudent(101);
        assertEquals("Ravi", s.getName());
    }

    // ---------- UPDATE ----------

    @Test
    void testUpdateStudent() {
        service.updateStudent(101, "Ravi Kumar", "AI");
        Student s = service.getStudent(101);

        assertEquals("Ravi Kumar", s.getName());
        assertEquals("AI", s.getBranch());
    }

    // ---------- SUBJECT ASSIGN ----------

    @Test
    void testAssignSubject() {
        service.assignSubject(101, "Math");
        assertTrue(service.getStudent(101).getSubjects().contains("Math"));
    }

    @Test
    void testAssignInvalidSubjectThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> service.assignSubject(101, ""));
    }

    // ---------- DUPLICATE ----------

    @Test
    void testDuplicateRollThrows() {
        Student s2 = new Student("Asha", 101, "TY", "ECE", 5, "2025");
        assertThrows(IllegalArgumentException.class,
            () -> service.addStudent(s2));
    }

    // ---------- NOT FOUND ----------

    @Test
    void testStudentNotFoundThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> service.getStudent(999));
    }
}
