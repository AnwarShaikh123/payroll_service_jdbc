package org.example;

import java.sql.*;

public class Payroll_Service_jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "********";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
            String query = "SELECT * FROM employee_payroll WHERE start BETWEEN ? AND DATE(NOW())";
            statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf("2016-11-23"));
            rs = statement.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("No records found for the specified date range.");
            } else {
                while (rs.next()) {
                    System.out.println("Employee ID: " + rs.getInt("id"));
                    System.out.println("Employee Name: " + rs.getString("name"));
                    System.out.println("Employee Gender: " + rs.getString("gender"));
                    System.out.println("Employee Salary: " + rs.getDouble("salary"));
                    System.out.println("Start Date: " + rs.getDate("start"));
                    System.out.println("Employee Phone Number: " + rs.getString("phone_no")); // Using "phone_no" here
                    System.out.println("Address: " + rs.getString("address"));
                    System.out.println("Department: " + rs.getString("department"));
                    System.out.println("Basic Pay: " + rs.getDouble("basic_pay"));
                    System.out.println("Deductions: " + rs.getDouble("deductions"));
                    System.out.println("Taxable Pay: " + rs.getDouble("taxable_pay"));
                    System.out.println("Income Tax: " + rs.getDouble("income_tax"));
                    System.out.println("Net Pay: " + rs.getDouble("net_pay"));
                    System.out.println();
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