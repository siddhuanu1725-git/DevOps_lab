package student_records;

import java.util.*;

public class StudentService {

    private Map<Integer, Student> db = new HashMap<>();

    // add student
    public void addStudent(Student s) {
        if (db.containsKey(s.getRollNo()))
            throw new IllegalArgumentException("Roll number already exists");

        db.put(s.getRollNo(), s);
    }

    // update student details
    public void updateStudent(int roll, String name, String branch) {
        Student s = getStudent(roll);
        s.setName(name);
        s.setBranch(branch);
    }

    // assign subject
    public void assignSubject(int roll, String subject) {
        Student s = getStudent(roll);

        if (subject == null || subject.isBlank())
            throw new IllegalArgumentException("Invalid subject");

        s.addSubject(subject);
    }

    // fetch student
    public Student getStudent(int roll) {
        Student s = db.get(roll);
        if (s == null)
            throw new IllegalArgumentException("Student not found");
        return s;
    }

    // total students
    public int count() {
        return db.size();
    }
}
