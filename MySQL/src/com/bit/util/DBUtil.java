package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

public class DBUtil {
    private static DataSource DATA_SOURCE;

    private static final String URL = "jdbc:mysql://localhost:book_manage";
    private static final String USERNAME = "root";
    private  static final String PASSWORD = "root";

    private DBUtil(){

    }
    public static DataSource getDataSource(){
        if(DATA_SOURCE == null){
            DATA_SOURCE = new MysqlDataSource();
            ((MysqlDataSource) DATA_SOURCE).setURL(URL);
            ((MysqlDataSource) DATA_SOURCE).setUser(USERNAME);
            ((MysqlDataSource) DATA_SOURCE).setPassword(PASSWORD);
        }
        return DATA_SOURCE;
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {

        System.out.println(getConnection());
    }
}
