//Viết một chương trình Java sử dụng CallableStatement để gọi stored procedure getEmployeeDetails.
//Với getEmployeeDetails nhận vào tham số id nhân viên và thực hiện hiển thị thông tin nhân viên đó ra màn hình
package bt4;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            connection = ConnectionDB.openConnection();
            if (connection == null) {
                System.out.println("Failed to connect to database.");
                return;
            }

            createStoredProcedure(connection);

            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();

            String call = "{call getEmployeeDetails(?)}";
            callableStatement = connection.prepareCall(call);

            callableStatement.setInt(1, employeeId);

            boolean hasResults = callableStatement.execute();

            if (hasResults) {
                ResultSet resultSet = callableStatement.getResultSet();
                if (resultSet.next()) {
                    System.out.println("\nEmployee Details:");
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Salary: " + resultSet.getDouble("salary"));
                } else {
                    System.out.println("No employee found with ID: " + employeeId);
                }
                resultSet.close();
            } else {
                System.out.println("No results returned from stored procedure");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    private static void createStoredProcedure(Connection connection) throws SQLException {
        boolean procedureExists = false;
        ResultSet rs = connection.getMetaData().getProcedures(null, null, "getEmployeeDetails");
        if (rs.next()) {
            procedureExists = true;
        }
        rs.close();

        if (!procedureExists) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employees (" +
                        "id INT PRIMARY KEY, " +
                        "name VARCHAR(255), " +
                        "salary DOUBLE)");

                rs = stmt.executeQuery("SELECT COUNT(*) FROM employees");
                rs.next();
                if (rs.getInt(1) == 0) {
                    stmt.executeUpdate("INSERT INTO employees VALUES (1, 'John Doe', 5000.0)");
                    stmt.executeUpdate("INSERT INTO employees VALUES (2, 'Jane Smith', 6000.0)");
                    stmt.executeUpdate("INSERT INTO employees VALUES (3, 'Mike Johnson', 5500.0)");
                }
                rs.close();

                String procedureSQL = "CREATE PROCEDURE getEmployeeDetails(IN empId INT) " +
                        "BEGIN " +
                        "SELECT * FROM employees WHERE id = empId; " +
                        "END";
                stmt.executeUpdate(procedureSQL);
                System.out.println("Stored procedure 'getEmployeeDetails' created successfully.");
            }
        }
    }
}
