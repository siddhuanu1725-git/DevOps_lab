package Result_processing;

public class resultProcessor {

    public int total(int m1, int m2, int m3) {
        return m1 + m2 + m3;
    }

    public double average(int m1, int m2, int m3) {
        return total(m1, m2, m3) / 3.0;
    }

    public String grade(double avg) {
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    public boolean isPass(double avg) {
        return avg >= 40;
    }
}

