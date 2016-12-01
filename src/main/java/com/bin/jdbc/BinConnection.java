package com.bin.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BinConnection {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Registry driver
            Class.forName("org.h2.Driver");

            // Connect to "bin-jdbc" database
            conn = DriverManager.getConnection("jdbc:h2:mem:./src/main/resources/bin-jdbc", "sa", "");

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println("DatabaseProductVersion: "+databaseMetaData.getDatabaseProductVersion());

            System.out.println("OK");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }
}
