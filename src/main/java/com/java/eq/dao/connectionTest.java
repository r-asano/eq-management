package com.java.eq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionTest{

public static void main(String[] argv) throws SQLException {

    //-------------------------------------------------------------------------
    System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

    try {

        Class.forName("org.postgresql.Driver");

    } catch (ClassNotFoundException e) {

        System.out.println("Where is your PostgreSQL JDBC Driver?");
        e.printStackTrace();
        return;

    }

    System.out.println("PostgreSQL JDBC Driver Registered!");
    Connection connection = null;

    try {
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/sslcertdb?serverTimezone=JST&characterEncoding=utf8",
                        "postgres", "##Infinity22");

    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        return;
    }

    if (connection != null) {
        System.out.println("You made it, take control your database now!");
    } else {
        System.out.println("Failed to make connection!");
    }
    //-------------------------------------------------------------------------

    Statement stmt = connection.createStatement();
    boolean result = stmt.execute("CREATE TABLE Students " +
            " (student_ID INT NOT NULL, " +
            " PRIMARY KEY (student_ID), firstName varchar(255), " +
            " lastName varchar(255))");
    System.out.println("\tTable creation result: " + result + "\t");
    System.out.println("**Note: The expected result is FALSE");
}
}