package bt7;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private ArrayList<Student> students;

    public StudentRepository() {
        students = new ArrayList<Student>();
    }

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> findByName(String name) {
        List<Student> results = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(student);
            }
        }
        return results;
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }
}