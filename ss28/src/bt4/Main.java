package bt4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Viết chương trình Java, thực hiện các yêu cầu sau:
//
//Tạo bảng bank_accounts với các cột account_id, account_name, balance, bank_name.
//Viết một chương trình chuyển khoản giữa hai tài khoản thuộc hai ngân hàng khác nhau.
//Trừ tiền từ tài khoản ở ngân hàng A
//Cộng tiền vào tài khoản ở ngân hàng B
//Nếu bất kỳ bước nào thất bại (ví dụ: kết nối bị lỗi), hãy gọi rollback() trên cả hai kết nối.
//Nếu cả hai bước thành công, gọi commit() trên cả hai kết nối.
public class Main {
    public static void createBankAccountsTable() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS bank_accounts (" +
                    "account_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "account_name VARCHAR(100) NOT NULL," +
                    "balance DECIMAL(10,2) NOT NULL," +
                    "bank_name VARCHAR(100) NOT NULL)";

            stmt.executeUpdate(createTableSQL);
            System.out.println("Bank accounts table created successfully.");

            String checkDataSQL = "SELECT COUNT(*) FROM bank_accounts";
            ResultSet rs = stmt.executeQuery(checkDataSQL);
            if (rs.next() && rs.getInt(1) == 0) {
                String insertDataSQL = "INSERT INTO bank_accounts (account_name, balance, bank_name) VALUES " +
                        "('Alice', 1000.00, 'Bank A'), " +
                        "('Bob', 500.00, 'Bank B'), " +
                        "('Charlie', 1500.00, 'Bank A'), " +
                        "('David', 2000.00, 'Bank B')";
                stmt.executeUpdate(insertDataSQL);
                System.out.println("Test accounts created successfully.");
            }
            rs.close();

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

    public static boolean transferMoneyBetweenBanks(int fromAccountId, int toAccountId, double amount) {
        Connection connBankA = null;
        Connection connBankB = null;
        PreparedStatement checkStmt = null;
        PreparedStatement debitStmt = null;
        PreparedStatement creditStmt = null;
        ResultSet resultSet = null;
        boolean success = false;

        try {
            connBankA = ConnectionDB.openConnection();
            connBankB = ConnectionDB.openConnection();

            if (connBankA == null || connBankB == null) {
                System.out.println("Failed to establish database connections.");
                return false;
            }

            connBankA.setAutoCommit(false);
            connBankB.setAutoCommit(false);

            String checkBalanceSQL = "SELECT balance, bank_name FROM bank_accounts WHERE account_id = ?";
            checkStmt = connBankA.prepareStatement(checkBalanceSQL);
            checkStmt.setInt(1, fromAccountId);
            resultSet = checkStmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Source account not found.");
                return false;
            }

            double currentBalance = resultSet.getDouble("balance");
            String sourceBank = resultSet.getString("bank_name");

            if (currentBalance < amount) {
                System.out.println("Insufficient funds in account " + fromAccountId);
                return false;
            }

            checkStmt = connBankB.prepareStatement(checkBalanceSQL);
            checkStmt.setInt(1, toAccountId);
            resultSet = checkStmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Destination account not found.");
                return false;
            }

            String destinationBank = resultSet.getString("bank_name");

            String debitSQL = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
            debitStmt = connBankA.prepareStatement(debitSQL);
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            int debitResult = debitStmt.executeUpdate();

            String creditSQL = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
            creditStmt = connBankB.prepareStatement(creditSQL);
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);
            int creditResult = creditStmt.executeUpdate();

            if (debitResult > 0 && creditResult > 0) {
                connBankA.commit();
                connBankB.commit();
                System.out.println("Successfully transferred $" + amount +
                        " from account " + fromAccountId + " at " + sourceBank +
                        " to account " + toAccountId + " at " + destinationBank);
                success = true;
            } else {
                if (connBankA != null) connBankA.rollback();
                if (connBankB != null) connBankB.rollback();
                System.out.println("Transaction failed. One or both accounts may not exist.");
            }

        } catch (SQLException e) {
            System.out.println("Transaction error: " + e.getMessage());
            try {
                if (connBankA != null) connBankA.rollback();
                if (connBankB != null) connBankB.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (checkStmt != null) checkStmt.close();
                if (debitStmt != null) debitStmt.close();
                if (creditStmt != null) creditStmt.close();

                if (connBankA != null) {
                    connBankA.setAutoCommit(true);
                    ConnectionDB.closeConnection(connBankA);
                }
                if (connBankB != null) {
                    connBankB.setAutoCommit(true);
                    ConnectionDB.closeConnection(connBankB);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    public static void main(String[] args) {
        createBankAccountsTable();


        transferMoneyBetweenBanks(1, 2, 200.00);

    }
}