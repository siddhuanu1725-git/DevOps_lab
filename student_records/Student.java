package student_records;
import java.util.*;

public class Student {

    private String name;
    private int rollNo;
    private String studentClass;
    private String branch;
    private int semester;
    private String academicYear;
    private List<String> subjects = new ArrayList<>();

    public Student(String name, int rollNo, String studentClass,
                   String branch, int semester, String academicYear) {
        this.name = name;
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        this.branch = branch;
        this.semester = semester;
        this.academicYear = academicYear;
    }

    // getters
    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public String getStudentClass() { return studentClass; }
    public String getBranch() { return branch; }
    public int getSemester() { return semester; }
    public String getAcademicYear() { return academicYear; }
    public List<String> getSubjects() { return subjects; }

    // setters for update
    public void setName(String name) { this.name = name; }
    public void setStudentClass(String c) { this.studentClass = c; }
    public void setBranch(String b) { this.branch = b; }
    public void setSemester(int s) { this.semester = s; }
    public void setAcademicYear(String y) { this.academicYear = y; }

    public void addSubject(String subject) {
        subjects.add(subject);
    }
}
