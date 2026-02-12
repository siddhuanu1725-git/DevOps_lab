package result_processing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResultProcessorTest {

    ResultProcessor rp = new ResultProcessor();

    int[] goodMarks = {80, 90, 70, 60};

    @Test
    void testTotal() {
        assertEquals(300, rp.total(goodMarks));
    }

    @Test
    void testAverage() {
        assertEquals(75.0, rp.average(goodMarks));
    }

    @Test
    void testGradeAplus() {
        assertEquals("A+", rp.grade(92));
    }

    @Test
    void testGradeFail() {
        assertEquals("F", rp.grade(30));
    }

    @Test
    void testPassAllSubjectsAbove35() {
        assertTrue(rp.isPass(goodMarks));
    }

    @Test
    void testFailIfOneSubjectBelow35() {
        int[] marks = {80, 90, 20};
        assertFalse(rp.isPass(marks));
    }

    @Test
    void testDistinction() {
        assertTrue(rp.isDistinction(88));
    }

    @Test
    void testInvalidHighMarksThrowsException() {
        int[] marks = {110, 90};
        assertThrows(IllegalArgumentException.class,
                () -> rp.total(marks));
    }

    @Test
    void testNegativeMarksThrowsException() {
        int[] marks = {-5, 50};
        assertThrows(IllegalArgumentException.class,
                () -> rp.total(marks));
    }

    @Test
    void testEmptyArrayThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> rp.total(new int[]{}));
    }
}
