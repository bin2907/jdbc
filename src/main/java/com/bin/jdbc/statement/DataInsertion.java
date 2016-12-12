/* Copyright 2016 Bin */
package com.bin.jdbc.statement;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data insertion demo.
 *
 * Created by Bin on 12/1/2016.
 */
public class DataInsertion {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectionUtil.getConnection();

            stmt = conn.createStatement();

            String tableCreationSql = "create table `users` (`id` int, `name` varchar(255))";
            boolean result = stmt.execute(tableCreationSql);
            System.out.println(result); // false

            String dataInsertionSql = "insert into `users` values(1, 'bin')";
            result = stmt.execute(dataInsertionSql);
            System.out.println(result); // false: no results
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
