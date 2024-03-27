package com.likelion.db;

import java.sql.Connection;

public class SimpleDb {

    private final String url;
    private final String username;
    private final String password;
    private final String dbName;
    private Connection connection;

    public SimpleDb(String url, String username, String password, String dbName) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    public void setDevMode(boolean devMode) {
        // 개발 모드를 설정하는 메소드입니다.
        // 이것은 필요에 따라 구현해야 할 부분입니다.
    }

    public void run(String sql) {

    }
}