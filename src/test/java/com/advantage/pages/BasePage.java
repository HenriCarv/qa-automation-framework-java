package com.advantage.pages;

import com.advantage.drivers.DriverFactory;
import com.advantage.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Util {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}