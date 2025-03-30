package bt7;

import java.util.List;

public class StudentService {
    private StudentRepository repository;

    public StudentService() {
        repository = new StudentRepository();
    }

    public void addStudent(String name, int age, double gpa) {
        Student student = new Student(name, age, gpa);
        repository.add(student);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public List<Student> findStudentsByName(String name) {
        return repository.findByName(name);
    }

    public boolean hasStudents() {
        return !repository.isEmpty();
    }
}
