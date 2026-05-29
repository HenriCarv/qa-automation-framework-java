package com.advantage;

import com.advantage.base.BaseTest;
import com.advantage.drivers.DriverFactory;
import org.junit.Test;

public class OpenBrowserTest extends BaseTest {

    @Test
    public void shouldOpenBrowser() {

        DriverFactory.getDriver()
                .get("https://www.google.com");
    }
}