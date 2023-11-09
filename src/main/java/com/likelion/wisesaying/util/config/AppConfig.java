package com.likelion.wisesaying.util.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties pro = new Properties();

    public static String getJdbcProperty(String key) {
        InputStream in = AppConfig.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro.getProperty(key);
    }
}
