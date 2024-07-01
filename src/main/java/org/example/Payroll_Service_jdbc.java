package org.example;

import java.sql.*;

public class Payroll_Service_jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "Anwarshaikh@8652741234";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
            String query = "SELECT SUM(salary) AS total_salary FROM employee_payroll WHERE gender='m' GROUP BY gender";
            statement = connection.prepareStatement(query);

            rs = statement.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("No records found for male employees.");
            } else {
                while (rs.next()) {
                    double totalSalary = rs.getDouble("total_salary");
                    System.out.println("Total Salary for Male Employees: " + totalSalary);
                }
                System.out.println("Read successful");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
