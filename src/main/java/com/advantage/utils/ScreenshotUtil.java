package com.advantage.utils;

import com.advantage.drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {

    private ScreenshotUtil() {
    }

    public static byte[] takeScreenshot() {

        return ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}