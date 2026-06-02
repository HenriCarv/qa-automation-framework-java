package com.advantage.web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features/web",
        glue = {
                "com.advantage.web.stepdefinitions",
                "com.advantage.web.hooks"
        },

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },

        monochrome = true
)

public class WebRunner {
}