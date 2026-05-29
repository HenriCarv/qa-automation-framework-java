package com.advantage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "menuUserLink")
    private WebElement userMenu;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "sign_in_btn")
    private WebElement signInButton;

    public void login(String user, String pass) {
        clickSafe(userMenu);
        typeText(username, user);
        typeText(password, pass);
        clickSafe(signInButton);
    }
}