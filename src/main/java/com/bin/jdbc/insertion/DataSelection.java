/* Copyright 2016 Bin */
package com.bin.jdbc.insertion;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data selection demo.
 *
 * Created by Bin on 12/1/2016.
 */
public class DataSelection {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statmt = null;

        try {
            conn = ConnectionUtil.getConnection();

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
