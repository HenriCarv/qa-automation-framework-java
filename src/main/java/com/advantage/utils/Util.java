package com.advantage.utils;

import com.advantage.drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Util {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Util() {

        this.driver = DriverFactory.getDriver();

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        PageFactory.initElements(driver, this);
    }

    // =========================
    // BASIC ACTIONS
    // =========================

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clickSafe(WebElement element) {

        waitForPageLoad();
        waitForLoaderToDisappear();

        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            waitForLoaderToDisappear();
            element.click();
        }
    }

    protected void typeText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForText(WebElement element, String expectedText) {

        wait.until(
                ExpectedConditions.textToBePresentInElement(
                        element,
                        expectedText
                )
        );
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // =========================
    // WAIT CONDITIONS
    // =========================

    protected void waitForPageLoad() {

        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    protected void waitForLoaderToDisappear() {

        By loader = By.cssSelector(".loader");

        wait.until(driver ->
                driver.findElements(loader)
                        .stream()
                        .noneMatch(WebElement::isDisplayed)
        );
    }

    protected void waitForPopupToDisappear() {

        By popup = By.cssSelector(".PopUp");

        wait.until(driver ->
                driver.findElements(popup)
                        .stream()
                        .noneMatch(WebElement::isDisplayed)
        );
    }

    // =========================
    // VALIDATIONS
    // =========================

    protected void validateText(
            WebElement element,
            String expectedText
    ) {

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        String actualText =
                element.getText().trim();

        if (!actualText.equals(expectedText)) {

            throw new AssertionError(
                    "Texto inválido.\n" +
                            "Esperado: " + expectedText + "\n" +
                            "Obtido: " + actualText
            );
        }
    }
}