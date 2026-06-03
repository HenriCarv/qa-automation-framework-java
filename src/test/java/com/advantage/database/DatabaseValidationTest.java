package com.advantage.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseValidationTest {

    @Test
    public void showExecutions() throws Exception {

        Connection connection =
                DatabaseConnection.getConnection();

        Statement statement =
                connection.createStatement();

        ResultSet result =
                statement.executeQuery(
                        "SELECT * FROM test_execution");

        while (result.next()) {

            System.out.println(
                    result.getInt("id") + " | " +
                            result.getString("scenario_name") + " | " +
                            result.getString("endpoint") + " | " +
                            result.getInt("status_code") + " | " +
                            result.getString("result")
            );
        }

        connection.close();
    }
}