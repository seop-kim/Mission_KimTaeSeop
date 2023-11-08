package com.likelion.wisesaying.database;

import com.likelion.wisesaying.domain.Saying;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SayingDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/saying";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lldj123414";
    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private Connection conn;

    public void register(Saying saying) {
        conn = open();
        String sql = "INSERT INTO saying(id, author, content) VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, saying.getId());
            pstmt.setString(2, saying.getAuthor());
            pstmt.setString(3, saying.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public List<Saying> findAll() {
        conn = open();
        String sql = "SELECT * FROM saying";
        List<Saying> sayings = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Saying saying = new Saying();
                saying.setId(rs.getLong("id"));
                saying.setAuthor(rs.getString("author"));
                saying.setContent(rs.getString("content"));
                sayings.add(saying);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return sayings;
    }

    public Saying findOne(Long id) {
        conn = open();
        String sql = "SELECT * FROM saying WHERE id =?";
        Saying saying = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                saying = new Saying();
                saying.setId(rs.getLong("id"));
                saying.setAuthor(rs.getString("author"));
                saying.setContent(rs.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();

        } finally {
            close();
        }
        return saying;
    }


    public void delete(Long id) {
        conn = open();
        String sql = "DELETE FROM saying WHERE id =?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void update(Saying saying) {
        conn = open();
        String sql = "UPDATE saying SET author =?, content =? WHERE id =?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, saying.getAuthor());
            pstmt.setString(2, saying.getContent());
            pstmt.setLong(3, saying.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    private Connection open() {
        Connection con = null;
        try {
            // MySQL JDBC 드라이버를 로드합니다.
            Class.forName(CLASS_NAME);

            // 데이터베이스에 연결합니다.
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (con == null) {
                System.out.println("MySQL 연결 실패.");
                return null;
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다.");

        } catch (SQLException e) {
            System.err.println("MySQL에 연결하는 동안 오류가 발생했습니다.");
        }

        return con;
    }

    private void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
