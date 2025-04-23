package main.ra.edu.business.dao;

import main.ra.edu.config.ConnectionDB;
import main.ra.edu.entity.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";

        try (Connection conn = ConnectionDB.openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setSex(rs.getBoolean("sex"));
                student.setBod(rs.getDate("bod"));
                student.setCourseId(rs.getInt("course_id"));
                student.setAvatar(rs.getString("avatar"));
                student.setStatus(rs.getBoolean("status"));
                students.add(student);
            }
        }
        return students;
    }

    public boolean create(Student student) throws SQLException {
        String sql = "INSERT INTO Student (id, name, email, phone, sex, bod, course_id, avatar, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhone());
            pstmt.setBoolean(5, student.isSex());
            pstmt.setDate(6, new java.sql.Date(student.getBod().getTime()));
            pstmt.setInt(7, student.getCourseId());
            pstmt.setString(8, student.getAvatar());
            pstmt.setBoolean(9, student.isStatus());

            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(Student student) throws SQLException {
        String sql = "UPDATE Student SET name = ?, email = ?, phone = ?, sex = ?, " +
                "bod = ?, course_id = ?, avatar = ?, status = ? WHERE id = ?";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getPhone());
            pstmt.setBoolean(4, student.isSex());
            pstmt.setDate(5, new java.sql.Date(student.getBod().getTime()));
            pstmt.setInt(6, student.getCourseId());
            pstmt.setString(7, student.getAvatar());
            pstmt.setBoolean(8, student.isStatus());
            pstmt.setString(9, student.getId());

            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Student WHERE id = ?";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }

    public Student findById(String id) throws SQLException {
        String sql = "SELECT * FROM Student WHERE id = ?";
        Student student = null;

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getString("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setPhone(rs.getString("phone"));
                    student.setSex(rs.getBoolean("sex"));
                    student.setBod(rs.getDate("bod"));
                    student.setCourseId(rs.getInt("course_id"));
                    student.setAvatar(rs.getString("avatar"));
                    student.setStatus(rs.getBoolean("status"));
                }
            }
        }
        return student;
    }

    public List<Student> findByName(String name) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE name LIKE ?";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getString("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setPhone(rs.getString("phone"));
                    student.setSex(rs.getBoolean("sex"));
                    student.setBod(rs.getDate("bod"));
                    student.setCourseId(rs.getInt("course_id"));
                    student.setAvatar(rs.getString("avatar"));
                    student.setStatus(rs.getBoolean("status"));
                    students.add(student);
                }
            }
        }
        return students;
    }
}