package com.likelion.wisesaying;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

public class JdbcConnectTest {

    @Test
    void connectTest() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데 문제 발생" + e.getMessage());
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "lldj123414");
            System.out.println("연결 완료!!!");
        } catch (SQLException e) {
            System.out.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null) {
                con.close();
            }
        } catch (SQLException e) {}
    }
}
