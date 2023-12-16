package com.example;

import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        // defined in my ~/.bashrc file
        final String DB_USERNAME = System.getenv("DB_USERNAME");
        final String DB_PASSWORD = System.getenv("DB_PASSWORD");

        final String DB_URL = 
            "jdbc:sqlserver://localhost:1433;" +
            "DatabaseName=test;" +
            "encrypt=true;" +
            "trustServerCertificate=true;";

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();
            String query = "SELECT id, title, quantity FROM test.dbo.products";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                System.out.println("Id: " + result.getInt(1));
                System.out.println("Title: " + result.getString(2));
                System.out.println("Quantity: " + result.getInt(3));
            }

        } catch (Exception e) {
            System.out.println("Exception occurred" + e.getMessage());
        }
    }
}
