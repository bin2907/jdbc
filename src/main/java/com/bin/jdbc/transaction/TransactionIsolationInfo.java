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
public class TransactionIsolationInfo {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();

            System.out.println("Transaction Isolation level: ");
            System.out.println("TRANSACTION_NONE: " + Connection.TRANSACTION_NONE);
            System.out.println("TRANSACTION_READ_COMMITTED: " + Connection.TRANSACTION_READ_COMMITTED);
            System.out.println("TRANSACTION_READ_UNCOMMITTED: " + Connection.TRANSACTION_READ_UNCOMMITTED);
            System.out.println("TRANSACTION_REPEATABLE_READ: " + Connection.TRANSACTION_REPEATABLE_READ);
            System.out.println("TRANSACTION_SERIALIZABLE: " + Connection.TRANSACTION_SERIALIZABLE);

            System.out.println("");
            System.out.println("Get Transaction Isolation Level of RDBMS: " + conn.getTransactionIsolation());

            System.out.println("");
            System.out.println("Check TransactionIsolationLevel is supported of RDBMS: ");
            System.out.println("Support TRANSACTION_NONE: "
                    + conn.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_NONE));
            System.out.println("Support TRANSACTION_READ_COMMITTED: "
                    + conn.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED));
            System.out.println("Support TRANSACTION_READ_UNCOMMITTED: "
                    + conn.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED));
            System.out.println("Support TRANSACTION_REPEATABLE_READ: "
                    + conn.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ));
            System.out.println("Support TRANSACTION_SERIALIZABLE: "
                    + conn.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));




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
