package main.ra.edu.business.service;

import main.ra.edu.business.dao.CourseDAO;
import main.ra.edu.entity.Course;
import java.sql.SQLException;
import java.util.List;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new CourseDAO();
    }

    public List<Course> getAll() throws SQLException {
        return courseDAO.findAll();
    }

    public boolean add(Course course) throws SQLException {
        validateCourse(course);
        return courseDAO.create(course);
    }

    public boolean update(Course course) throws SQLException {
        validateCourse(course);
        return courseDAO.update(course);
    }

    public boolean delete(int id) throws SQLException {
        return courseDAO.delete(id);
    }

    public Course getById(int id) throws SQLException {
        return courseDAO.findById(id);
    }

    private void validateCourse(Course course) {
        if (course.getName() == null || course.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        }
        if (course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Course description cannot be empty");
        }
    }
}