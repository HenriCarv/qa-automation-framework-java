package com.advantage.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS test_execution (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    scenario_name TEXT,
                    endpoint TEXT,
                    method TEXT,
                    status_code INTEGER,
                    execution_time INTEGER,
                    result TEXT,
                    execution_date TEXT
                );
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                Statement statement =
                        connection.createStatement()
        ) {

            statement.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}