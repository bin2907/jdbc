/* Copyright 2016 Bin */
package com.bin.jdbc.statement;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Statement simple demo.
 *
 * Created by Bin on 12/1/2016.
 */
public class StatementSimple {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectionUtil.getConnection();

            stmt = conn.createStatement();

            boolean result = stmt.execute("show tables");

            System.out.println(result); // true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
