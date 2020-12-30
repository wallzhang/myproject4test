package com.wall.myproject4test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
    private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zZW@1993";

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                Class.forName(DRIVERNAME);
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
