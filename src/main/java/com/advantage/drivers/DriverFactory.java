package com.advantage.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Classe responsável pelo gerenciamento do WebDriver.
 */
public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {

            // Faz download automático da versão correta do driver
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Inicia maximizado
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }
}