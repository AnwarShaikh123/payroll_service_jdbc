package org.example;

import java.sql.*;

public class Payroll_Service_jdbc {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/payroll_service";
        String username="root";
        String password="Anwarshaikh@8652741234";
        Connection connection=null;
        try{
            connection=DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successfull");
        }
        catch (Exception e){
            System.out.println("Connection failed");

        }
    }
}

