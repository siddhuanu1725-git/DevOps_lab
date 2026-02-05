package Result_processing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class resultProcessorTest {

    resultProcessor rp = new resultProcessor();

    @Test
    void testTotal() {
        assertEquals(240, rp.total(80, 80, 80));
    }

    @Test
    void testAverage() {
        assertEquals(80.0, rp.average(70, 80, 90));
    }

    @Test
    void testGradeA() {
        assertEquals("A", rp.grade(95));
    }

    @Test
    void testGradeFail() {
        assertEquals("F", rp.grade(20));
    }

    @Test
    void testPass() {
        assertTrue(rp.isPass(50));
    }

    @Test
    void testFail() {
        assertFalse(rp.isPass(30));
    }

    @Test
    void testBoundaryPass() {
        assertTrue(rp.isPass(40));
    }
}
