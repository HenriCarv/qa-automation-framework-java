package com.advantage.web.hooks;

import com.advantage.drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before("@web")
    public void setUp() {

        DriverFactory.getDriver();

        DriverFactory.getDriver()
                .manage()
                .deleteAllCookies();
    }

    @AfterStep("@web")
    public void afterStep(Scenario scenario) {

        try {

            if (DriverFactory.getDriver() != null) {

                byte[] screenshot =
                        ((TakesScreenshot) DriverFactory.getDriver())
                                .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Step Screenshot"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro screenshot step: "
                            + e.getMessage()
            );
        }
    }

    @After("@web")
    public void tearDown(Scenario scenario) {

        try {

            if (DriverFactory.getDriver() != null
                    && scenario.isFailed()) {

                byte[] screenshot =
                        ((TakesScreenshot) DriverFactory.getDriver())
                                .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failure Screenshot"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro screenshot falha: "
                            + e.getMessage()
            );

        } finally {

            try {

                DriverFactory.quitDriver();

            } catch (Exception e) {

                System.out.println(
                        "Erro ao fechar driver: "
                                + e.getMessage()
                );
            }
        }
    }
}