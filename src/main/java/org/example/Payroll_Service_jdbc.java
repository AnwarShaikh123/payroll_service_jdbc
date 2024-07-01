package org.example;

import java.sql.*;

public class Payroll_Service_jdbc {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/payroll_service";
        String username="root";
        String password="Anwarshaikh@8652741234";
        Connection connection=null;
        PreparedStatement updateStatement = null;
        PreparedStatement selectStatement = null;

        ResultSet rs= null;
        try{
            connection=DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successfull");
            String queryUpdate = "UPDATE employee_payroll SET Basic_pay = ? WHERE name = ?";
            updateStatement = connection.prepareStatement(queryUpdate);
            updateStatement.setDouble(1, 300000);
            updateStatement.setString(2, "Laksh");
            int rowsAffected = updateStatement.executeUpdate();
            System.out.println("Rows Affected: " + rowsAffected);

            String query= " SELECT * FROM employee_payroll";

            selectStatement = connection.prepareStatement(query);
            rs = selectStatement.executeQuery();
            while (rs.next()){
                System.out.println("Empolyee ID: " + rs.getInt(1));
                System.out.println("Employee Name: " + rs.getString(2));
                System.out.println("Employee Gender: " + rs.getString(3));
                System.out.println("Employee Salary: " + rs.getInt(4));
                System.out.println("Start Date: " + rs.getDate(5));
                System.out.println("Employee Phone number: "  +rs.getInt(6));
                System.out.println("Address: " + rs.getString(7));
                System.out.println("Department: " + rs.getString(8));
                System.out.println(" Basic pay: " + rs.getInt(9));
                System.out.println(" Deductions: " +rs.getInt(10));
                System.out.println("Taxable_pay: " +rs.getInt(11));
                System.out.println(" Income_tax: " + rs.getInt(12));
                System.out.println("Net_pay: " +rs.getInt(13));
            }
            System.out.println("Read successful");

        }
        catch (SQLException e){
            System.out.println(" Error Connection to Database" + e.getMessage());
        }
        finally{
            try {
                if (rs != null) rs.close();
                if (updateStatement != null) updateStatement.close();
                if (selectStatement != null) selectStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}