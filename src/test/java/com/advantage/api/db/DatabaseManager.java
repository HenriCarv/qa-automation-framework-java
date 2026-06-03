package com.advantage.api.db;

import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:target/execution.db";

    static {
        createTable();
    }

    private static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS api_execution (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                endpoint TEXT,
                method TEXT,
                status INTEGER,
                response_time INTEGER,
                result TEXT,
                created_at DATETIME DEFAULT CURRENT_TIMESTAMP
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(String endpoint, String method, int status, long time, String result) {
        String sql = """
            INSERT INTO api_execution(endpoint, method, status, response_time, result)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, endpoint);
            ps.setString(2, method);
            ps.setInt(3, status);
            ps.setLong(4, time);
            ps.setString(5, result);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}