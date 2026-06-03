package com.advantage.api.hooks;

import com.advantage.api.config.ApiConfig;
import com.advantage.api.context.ApiContext;
import com.advantage.database.DatabaseInitializer;
import com.advantage.database.TestExecution;
import com.advantage.database.TestExecutionDao;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.time.LocalDateTime;

public class ApiHooks {

    @Before("@api")
    public void setupApi() {

        ApiConfig.init();

        ApiContext.getInstance().clear();

        DatabaseInitializer.createTable();
    }

    @After("@api")
    public void saveExecution(Scenario scenario) {

        ApiContext context =
                ApiContext.getInstance();

        if (context.getResponse() == null) {
            return;
        }

        TestExecution execution =
                new TestExecution();

        execution.setScenarioName(
                scenario.getName());

        execution.setEndpoint(
                context.getRequestUrl());

        execution.setMethod(
                context.getRequestMethod());

        execution.setStatusCode(
                context.getResponse().statusCode());

        execution.setExecutionTime(
                context.getResponse().time());

        execution.setResult(
                scenario.isFailed()
                        ? "FAILED"
                        : "PASSED");

        execution.setExecutionDate(
                LocalDateTime.now().toString());

        new TestExecutionDao()
                .save(execution);
    }
}