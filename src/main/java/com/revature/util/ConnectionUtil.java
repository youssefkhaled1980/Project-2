package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	public static void main(String[] args) {
		ConnectionUtil cu =new ConnectionUtil();
		System.out.println(cu +" I'm in");
	}
    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionString = "jdbc:postgresql://reimbursement-data-instance-1.c9lpqr0ua5rh.us-west-1.rds.amazonaws.com";
        String username = "postgres";
        String password = "$Argent1980";

        return  DriverManager.getConnection(connectionString, username, password);

       
    }
}
