package com.advantage.hooks;

import com.advantage.drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.getDriver();

        DriverFactory.getDriver()
                .manage()
                .deleteAllCookies();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        try {

            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    "Step Screenshot"
            );

        } catch (Exception e) {

            System.out.println("Erro screenshot step: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        try {

            if (scenario.isFailed()) {

                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failure Screenshot"
                );
            }

        } catch (Exception e) {

            System.out.println("Erro screenshot falha: " + e.getMessage());

        } finally {

            DriverFactory.quitDriver();
        }
    }
}