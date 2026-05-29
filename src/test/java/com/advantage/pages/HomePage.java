package com.advantage.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "menuSearch")
    private WebElement searchIcon;

    @FindBy(id = "autoComplete")
    private WebElement searchInput;

    public void openWebsite() {
        driver.get("https://advantageonlineshopping.com/");
    }

    public void searchProduct(String product) {
        clickElement(searchIcon);
        typeText(searchInput, product);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void waitSearchProduct() {
        waitForElement(searchIcon);
    }
}