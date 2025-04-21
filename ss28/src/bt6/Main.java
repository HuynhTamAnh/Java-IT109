package bt6;
//Mô tả:
//
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Tạo bảng departments và employees với mối quan hệ 1-nhiều với thông tin như sau:
//Departments:
//Id – int
//Name – varchar(255)
//Employees:
//Id – int
//Name – varchar(255)
//Department_id – int
//Viết một giao dịch:
//Thêm một phòng ban mới vào bảng departments
//Trong cùng một giao dịch, thêm nhiều nhân viên vào bảng employees thuộc phòng ban đó
//Nếu bất kỳ thao tác nào trong giao dịch lồng bị lỗi, hãy rollback toàn bộ giao dịch

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        initializeDatabase();

        String departmentName = "IT Department";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe"));
        employees.add(new Employee("Jane Smith"));
        employees.add(new Employee("Bob Johnson"));

        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false); // Start transaction

            int departmentId = insertDepartment(connection, departmentName);

            for (Employee employee : employees) {
                insertEmployee(connection, employee.getName(), departmentId);
            }

            connection.commit();
            System.out.println("Transaction completed successfully!");
            System.out.println("Department ID: " + departmentId);

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error: " + e.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Error during rollback: " + ex.getMessage());
                }
            }
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static void initializeDatabase() {
        String createDepartmentsTable = "CREATE TABLE IF NOT EXISTS departments (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL)";

        String createEmployeesTable = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "department_id INT NOT NULL, " +
                "FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE)";

        try (Connection connection = ConnectionDB.openConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createDepartmentsTable);
            statement.execute(createEmployeesTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int insertDepartment(Connection connection, String name) throws SQLException {
        String sql = "INSERT INTO departments (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating department failed, no ID obtained.");
                }
            }
        }
    }

    private static void insertEmployee(Connection connection, String name, int departmentId) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new SQLException("Employee name cannot be null or empty");
        }

        String sql = "INSERT INTO employees (name, department_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, departmentId);
            statement.executeUpdate();
        }
    }
}
