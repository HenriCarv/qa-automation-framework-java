package com.advantage.hooks;

import com.advantage.drivers.DriverFactory;
import com.advantage.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.getDriver();

        DriverFactory.getDriver()
                .manage()
                .deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            scenario.attach(
                    ScreenshotUtil.takeScreenshot(),
                    "image/png",
                    "Failure Screenshot"
            );
        }

        DriverFactory.quitDriver();
    }
}