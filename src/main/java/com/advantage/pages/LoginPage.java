package com.advantage.pages;

import com.advantage.utils.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Util {

    @FindBy(id = "menuUserLink")
    private WebElement userMenu;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "remember_me")
    private WebElement remember;

    @FindBy(id = "sign_in_btn")
    private WebElement signInButton;

    @FindBy(id = "signInResultMessage")
    private WebElement errorMessageLogin;

    @FindBy(xpath = "//label[contains(text(),'Username field is required')]")
    private WebElement usernameRequiredMessage;

    @FindBy(xpath = "//label[contains(text(),'Password field is required')]")
    private WebElement passwordRequiredMessage;

    public void openLoginModal() {
        clickSafe(userMenu);
    }

    public void fillUsername(String user) {
        typeText(username, user);
    }

    public void fillPassword(String pass) {
        typeText(password, pass);
    }

    public void clickLogin() {
        clickSafe(signInButton);
    }

    public void login(String user, String pass) {

        openLoginModal();

        fillUsername(user);

        fillPassword(pass);

        clickLogin();
    }

    public void validateLoginErrorMessage(String expectedMessage) {

        waitForText(
                errorMessageLogin,
                expectedMessage
        );

        validateText(
                errorMessageLogin,
                expectedMessage
        );
    }

    public void clickUsernameField() {
        clickSafe(username);
    }

    public void clickPasswordField() {
        clickSafe(password);
    }

    public void clickOutsideFields() {
        waitForLoaderToDisappear();
        clickSafe(remember);
    }

    public void validateUsernameRequiredMessage(String expectedMessage) {

        validateText(
                usernameRequiredMessage,
                expectedMessage
        );
    }

    public void validatePasswordRequiredMessage(String expectedMessage) {

        validateText(
                passwordRequiredMessage,
                expectedMessage
        );
    }
}