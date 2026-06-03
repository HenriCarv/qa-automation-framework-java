package com.advantage.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestExecutionDao {

    public void save(TestExecution execution) {

        String sql = """
                INSERT INTO test_execution
                (
                scenario_name,
                endpoint,
                method,
                status_code,
                execution_time,
                result,
                execution_date
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1,
                    execution.getScenarioName());

            statement.setString(2,
                    execution.getEndpoint());

            statement.setString(3,
                    execution.getMethod());

            statement.setInt(4,
                    execution.getStatusCode());

            statement.setLong(5,
                    execution.getExecutionTime());

            statement.setString(6,
                    execution.getResult());

            statement.setString(7,
                    execution.getExecutionDate());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}