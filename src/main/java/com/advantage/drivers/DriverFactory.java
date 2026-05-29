package com.advantage.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
    Classe responsável por:
    - criar driver
    - configurar navegador
    - fechar navegador
*/
public class DriverFactory {

    // Variável estática do Selenium
    private static WebDriver driver;

    /*
        Método que cria e retorna driver
    */
    public static WebDriver getDriver() {

        // Verifica se driver ainda não existe
        if (driver == null) {

            // Baixa chromedriver automaticamente
            WebDriverManager.chromedriver().setup();

            // Configurações do Chrome
            ChromeOptions options = new ChromeOptions();

            // Abre navegador maximizado
            options.addArguments("--start-maximized");

            // Cria driver do Chrome
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    /*
        Método responsável por fechar navegador
    */
    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}