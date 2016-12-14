/* Copyright 2016 Bin */
package com.bin.jdbc.transaction;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Bin on 12/14/2016.
 */
public class TransactionSimple {
    public static void main(String[] args) {
        createTableAndInsertDataWithTransaction();

        getData();
    }

    public static void createTableAndInsertDataWithTransaction() {
        Connection conn = null;
        Statement statmt = null;

        try {
            conn = ConnectionUtil.getConnectionEmbedded();

            /*****************************************/
            conn.setAutoCommit(false); // NOTE here
            /*****************************************/

            statmt = conn.createStatement();

            String tableCreationSql = "create table `users` (`id` int, `name` varchar(255))";
            statmt.execute(tableCreationSql);

            String dataInsertionSql = "insert into `users` values(1, 'bin')";
            statmt.execute(dataInsertionSql);

            /*****************************************/
            conn.commit(); // NOTE: getData()  will have no result if don't call this method.
            /*****************************************/

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

    public static void getData() {
        Connection conn = null;
        Statement statmt = null;

        try {
            conn = ConnectionUtil.getConnectionEmbedded();

            statmt = conn.createStatement();

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
