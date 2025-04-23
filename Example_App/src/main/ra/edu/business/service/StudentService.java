package main.ra.edu.business.service;

import main.ra.edu.business.dao.CourseDAO;
import main.ra.edu.business.dao.StudentDAO;
import main.ra.edu.entity.Student;
import main.ra.edu.utils.Validator;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
        this.courseDAO = new CourseDAO();
    }

    public List<Student> getAll() throws SQLException {
        return studentDAO.findAll();
    }

    public boolean add(Student student) throws SQLException {
        validateStudent(student);
        return studentDAO.create(student);
    }

    public boolean update(Student student) throws SQLException {
        validateStudent(student);
        return studentDAO.update(student);
    }

    public boolean delete(String id) throws SQLException {
        return studentDAO.delete(id);
    }

    public Student getById(String id) throws SQLException {
        return studentDAO.findById(id);
    }

    public List<Student> searchByName(String name) throws SQLException {
        return studentDAO.findByName(name);
    }

    private void validateStudent(Student student) throws SQLException {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không được để trống");
        }

        if (!Validator.isValidEmail(student.getEmail())) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }

        if (!Validator.isValidVietnamesePhone(student.getPhone())) {
            throw new IllegalArgumentException("Số điện thoại không hợp lệ (phải là số điện thoại Việt Nam)");
        }

        if (student.getBod() == null) {
            throw new IllegalArgumentException("Ngày sinh không được để trống");
        }

        if (courseDAO.findById(student.getCourseId()) == null) {
            throw new IllegalArgumentException("Khóa học không tồn tại");
        }
    }
}