package Testing.result_processing;
public class ResultProcessor {

    public int total(int[] marks) {
        validateMarks(marks);

        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }

    public double average(int[] marks) {
        return total(marks) / (double) marks.length;
    }

    public String grade(double avg) {

        if (avg >= 90) return "A+";
        if (avg >= 80) return "A";
        if (avg >= 70) return "B";
        if (avg >= 60) return "C";
        if (avg >= 50) return "D";
        return "F";
    }

    public boolean isPass(int[] marks) {
        validateMarks(marks);

        // fail if any subject < 35
        for (int m : marks) {
            if (m < 35) return false;
        }

        return average(marks) >= 40;
    }

    public boolean isDistinction(double avg) {
        return avg >= 85;
    }

    private void validateMarks(int[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Marks list cannot be empty");
        }

        for (int m : marks) {
            if (m < 0 || m > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100");
            }
        }
    }
}
