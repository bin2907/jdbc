/* Copyright 2016 Bin */
package com.bin.jdbc.preparedstatement;

import com.bin.jdbc.connection.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement simple demo.
 *
 * Created by Bin on 12/1/2016.
 */
public class PreparedStatementSimple {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatmt = null;

        try {
            conn = ConnectionUtil.getConnection();

            preparedStatmt = conn.prepareStatement("show tables");

            boolean result = preparedStatmt.execute();

            System.out.println(result);//true: return ResultSet
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatmt != null) {
                try {
                    preparedStatmt.close();
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
