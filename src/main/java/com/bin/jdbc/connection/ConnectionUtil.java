/* Copyright 2016 Bin */
package com.bin.jdbc.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection util.
 *
 * Created by Bin on 12/1/2016.
 */
public class ConnectionUtil {
    private final static String DRIVER = "org.h2.Driver";
    private final static String URL = "jdbc:h2:mem:./src/main/resources/jdbc.db";
    private final static String URL_EMBEDDED= "jdbc:h2:./src/main/resources/db/jdbc";
    private final static String USER = "sa";
    private final static String PWD = "";

    /**
     * Get connection using memory database.
     *
     * @return Connection
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        // Registry driver
        Class.forName(DRIVER);

        // Return new connection
        return DriverManager.getConnection(URL, USER, PWD);
    }

    /**
     * Get connection.
     *
     * @return Connection
     */
    public static Connection getConnectionEmbedded() throws ClassNotFoundException, SQLException{
        // Registry driver
        Class.forName(DRIVER);

        // Return new connection
        return DriverManager.getConnection(URL_EMBEDDED, USER, PWD);
    }

    public static void main(String[] args) {
        // Test jdbc connection util
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            System.out.println("DatabaseProductVersion: " + databaseMetaData.getDatabaseProductVersion());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
