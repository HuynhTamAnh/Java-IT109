package bt5;
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Tạo CSDL với hai bảng có quan hệ 1-nhiều:
//Orders
//order_id – INT (Primary Key)
//customer_name – VARCHAR(255)
//order_date – DATE
//OrderDetails
//detail_id – INT (Primary Key)
//order_id – INT (Foreign Key → Orders)
//product_name – VARCHAR(255)
//quantity – INT
//Viết một giao dịch:
//Tạo mới một đơn hàng trong bảng Orders
//Trong cùng giao dịch, thêm nhiều dòng chi tiết vào bảng OrderDetails cho đơn hàng đó
//Nếu có bất kỳ lỗi nào trong quá trình thêm chi tiết đơn hàng, ví dụ số lượng âm hoặc trùng khóa, hãy rollback toàn bộ giao dịch, bao gồm cả đơn hàng

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();

            connection.setAutoCommit(false);

            int orderId = insertOrder(connection, "John Doe", LocalDate.now());


            insertOrderDetail(connection, orderId, "Laptop", 1);
            insertOrderDetail(connection, orderId, "Mouse", 2);
            insertOrderDetail(connection, orderId, "Keyboard", 1);
            connection.commit();
            System.out.println("Transaction completed successfully!");

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

    private static int insertOrder(Connection connection, String customerName, LocalDate orderDate) throws SQLException {
        String sql = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customerName);
            statement.setDate(2, Date.valueOf(orderDate));
            statement.executeUpdate();

            // Get the generated order ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        }
    }

    private static void insertOrderDetail(Connection connection, int orderId, String productName, int quantity) throws SQLException {
        if (quantity <= 0) {
            throw new SQLException("Invalid quantity: " + quantity + ". Quantity must be positive.");
        }

        String sql = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.setString(2, productName);
            statement.setInt(3, quantity);
            statement.executeUpdate();
        }
    }
}
