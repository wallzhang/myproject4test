package com.wall.myproject4test;

import java.sql.*;


public class DbUtils {
//    private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
//    private static final String URL="jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "zZW@1993";
    private static final String DRIVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db_ControlManager";
//    private static final String URL="jdbc:sqlserver://127.0.0.1:1433";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "zZW@1993";

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                Class.forName(DRIVERNAME);
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                System.out.println("success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void main(String[] args) throws Exception {
        conn =  getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test1");
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }


    }
}
