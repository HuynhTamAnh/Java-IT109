package bt3;
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Tạo một bảng mới trong cơ sở dữ liệu, ví dụ: bảng accounts với các cột id, name, balance
//Viết một chương trình chuyển tiền giữa hai tài khoản:
//Trừ tiền từ tài khoản A
//Cộng tiền vào tài khoản B
//Nếu bất kỳ bước nào thất bại (ví dụ: không đủ số dư), hãy thực hiện rollback()
//Nếu cả hai bước thành công, gọi commit()

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void createAccountsTable() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "balance DECIMAL(10,2) NOT NULL)";

            stmt.executeUpdate(createTableSQL);
            System.out.println("Accounts table created successfully.");

            String checkDataSQL = "SELECT COUNT(*) FROM accounts";
            if (stmt.executeQuery(checkDataSQL).next() && stmt.executeQuery(checkDataSQL).getInt(1) == 0) {
                String insertDataSQL = "INSERT INTO accounts (name, balance) VALUES " +
                        "('Account A', 1000.00), " +
                        "('Account B', 500.00)";
                stmt.executeUpdate(insertDataSQL);
                System.out.println("Test accounts created successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectionDB.closeConnection(conn);
        }
    }

    public static boolean transferMoney(int fromAccountId, int toAccountId, double amount) {
        Connection conn = null;
        PreparedStatement debitStmt = null;
        PreparedStatement creditStmt = null;

        try {
            conn = ConnectionDB.openConnection();
            if (conn == null) {
                return false;
            }

            conn.setAutoCommit(false);

            String checkBalanceSQL = "SELECT balance FROM accounts WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkBalanceSQL);
            checkStmt.setInt(1, fromAccountId);
            var resultSet = checkStmt.executeQuery();

            if (resultSet.next() && resultSet.getDouble("balance") < amount) {
                System.out.println("Insufficient funds in account " + fromAccountId);
                conn.rollback();
                return false;
            }

            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            debitStmt = conn.prepareStatement(debitSQL);
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            int debitResult = debitStmt.executeUpdate();

            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            creditStmt = conn.prepareStatement(creditSQL);
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);
            int creditResult = creditStmt.executeUpdate();

            if (debitResult > 0 && creditResult > 0) {
                conn.commit();
                System.out.println("Successfully transferred $" + amount +
                        " from account " + fromAccountId +
                        " to account " + toAccountId);
                return true;
            } else {
                conn.rollback();
                System.out.println("Transaction failed. One or both accounts may not exist.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Transaction error: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (debitStmt != null) debitStmt.close();
                if (creditStmt != null) creditStmt.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    ConnectionDB.closeConnection(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        createAccountsTable();


        transferMoney(1, 2, 200.00);


    }
}