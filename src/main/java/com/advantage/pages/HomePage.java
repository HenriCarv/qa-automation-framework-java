package com.advantage.pages;

import com.advantage.utils.ConfigReader;
import com.advantage.utils.Util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Util {

    @FindBy(id = "searchSection")
    private WebElement searchIcon;

    @FindBy(id = "laptopsTxt")
    private WebElement categoryLaptop;

    @FindBy(name = "save_to_cart")
    private WebElement addCart;

    @FindBy(id = "autoComplete")
    private WebElement searchInput;

    public void openWebsite() {

        driver.get(
                ConfigReader.get("url")
        );
    }

    public void searchProduct() {
        waitForPageLoad();

        waitForLoaderToDisappear();

        clickElement(categoryLaptop);
    }

    public void waitSearchProduct() {
        waitForElement(searchIcon);
    }
}