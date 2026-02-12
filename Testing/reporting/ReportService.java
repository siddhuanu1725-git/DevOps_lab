package Testing.reporting;

import java.util.*;

public class ReportService {

    // ---------- MARKSHEET ----------

    public String generateMarksheet(String name, int roll, Map<String,Integer> marks) {
        if (marks == null || marks.isEmpty())
            throw new IllegalArgumentException("No marks data");

        int total = marks.values().stream().mapToInt(i->i).sum();
        double avg = total / (double) marks.size();

        return "Marksheet\nName: " + name +
                "\nRoll: " + roll +
                "\nTotal: " + total +
                "\nAverage: " + avg;
    }

    // simulate PDF generation
    public boolean generatePdf(String content) {
        return content != null && content.contains("Marksheet");
    }

    // simulate download
    public boolean downloadMarksheet(int roll) {
        return roll > 0;
    }

    // ---------- CLASS SUMMARY ----------

    public double classAverage(List<Integer> totals) {
        if (totals.isEmpty())
            throw new IllegalArgumentException("No data");

        return totals.stream().mapToInt(i->i).average().orElse(0);
    }

    public int classTopper(List<Integer> totals) {
        return totals.stream().mapToInt(i->i).max().orElse(0);
    }

    // ---------- SUBJECT REPORT ----------

    public double subjectAverage(List<Integer> marks) {
        return marks.stream().mapToInt(i->i).average().orElse(0);
    }

    // ---------- PERFORMANCE ANALYTICS ----------

    public String performanceLevel(double avg) {
        if (avg >= 85) return "Excellent";
        if (avg >= 60) return "Good";
        if (avg >= 40) return "Average";
        return "Poor";
    }
}
