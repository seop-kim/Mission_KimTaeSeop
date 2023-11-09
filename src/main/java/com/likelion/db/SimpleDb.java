package com.likelion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDb {
    String jdbcUrl;
    String username;
    String password;

    public SimpleDb(String host, String username, String password, String dbName) {
        this.jdbcUrl = "jdbc:mysql://" + host + ":3306/" + dbName;
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        SimpleDb simpleDB = new SimpleDb("localhost", "root", "lldj123414", "simpleDb__test");
        simpleDB.connect();
    }
    public void connect() {
        try {
            // MySQL JDBC 드라이버를 로드합니다.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스에 연결합니다.
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("MySQL 연결 성공!");
                connection.close();
            } else {
                System.out.println("MySQL 연결 실패.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("MySQL에 연결하는 동안 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public void run(String sql) {

    }
}

