/* Copyright 2016 Bin */
package com.bin.jdbc.transaction;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Bin on 12/13/2016.
 */
public class AutoCommitExample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statmt = null;

        try {
            conn = ConnectionUtil.getConnection();

            // Default for this has been true already. So we don't need to set true.
            // Except we want to handle transaction ourselves
            conn.setAutoCommit(true);

            statmt = conn.createStatement();

            String tableCreationSql = "create table `users` (`id` int, `name` varchar(255))";
            boolean result = statmt.execute(tableCreationSql);
            System.out.println(result); // false

            String dataInsertionSql = "insert into `users` values(1, 'bin')";
            result = statmt.execute(dataInsertionSql);
            System.out.println(result); // false

            String dataSelectionSql = "select * from `users`";
            ResultSet rs = statmt.executeQuery(dataSelectionSql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2));
                System.out.println(rs.getInt("id") + " : " + rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statmt != null) {
                try {
                    statmt.close();
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
