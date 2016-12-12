/* Copyright 2016 Bin */
package com.bin.jdbc.resultset;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ResultSet simple demo.
 *
 * Created by Bin on 12/1/2016.
 */
public class ResultSetSimple {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionUtil.getConnection();

            stmt = conn.createStatement();

            rs = stmt.executeQuery("show tables");

            System.out.println(rs.getMetaData().getColumnCount()); //2
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
