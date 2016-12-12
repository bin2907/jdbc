/* Copyright 2016 Bin */
package com.bin.jdbc.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class demo a connection to h2database (in-memory)
 *
 * Created by Bin on 12/1/2016.
 */
public class ConnectionSimple {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Registry driver
            Class.forName("org.h2.Driver");

            // Connect to database
            conn = DriverManager.getConnection("jdbc:h2:mem:./src/main/resources/jdbc.db", "sa", "");

            // Do a simple test to make sure that the connection is okay.
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println("DatabaseProductVersion: " + databaseMetaData.getDatabaseProductVersion());
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
