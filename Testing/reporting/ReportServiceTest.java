package Testing.reporting;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ReportServiceTest {

    ReportService rs;

    @BeforeEach
    void setup() {
        rs = new ReportService();
    }

    // ---------- MARKSHEET ----------

    @Test
    void testGenerateMarksheet() {
        Map<String,Integer> m = Map.of("Math",80,"Sci",90);
        String ms = rs.generateMarksheet("Ravi",101,m);

        assertTrue(ms.contains("Ravi"));
        assertTrue(ms.contains("Total"));
    }

    @Test
    void testGenerateMarksheetEmptyThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> rs.generateMarksheet("Ravi",101,new HashMap<>()));
    }

    // ---------- PDF ----------

    @Test
    void testPdfGeneration() {
        assertTrue(rs.generatePdf("Marksheet data"));
    }

    @Test
    void testPdfFail() {
        assertFalse(rs.generatePdf("random text"));
    }

    // ---------- DOWNLOAD ----------

    @Test
    void testDownloadMarksheet() {
        assertTrue(rs.downloadMarksheet(10));
    }

    @Test
    void testDownloadInvalidRoll() {
        assertFalse(rs.downloadMarksheet(-1));
    }

    // ---------- CLASS SUMMARY ----------

    @Test
    void testClassAverage() {
        List<Integer> totals = List.of(200,250,300);
        assertEquals(250, rs.classAverage(totals));
    }

    @Test
    void testClassTopper() {
        List<Integer> totals = List.of(200,250,300);
        assertEquals(300, rs.classTopper(totals));
    }

    // ---------- SUBJECT REPORT ----------

    @Test
    void testSubjectAverage() {
        List<Integer> marks = List.of(70,80,90);
        assertEquals(80, rs.subjectAverage(marks));
    }

    // ---------- ANALYTICS ----------

    @Test
    void testPerformanceExcellent() {
        assertEquals("Excellent", rs.performanceLevel(90));
    }

    @Test
    void testPerformancePoor() {
        assertEquals("Poor", rs.performanceLevel(30));
    }
}
