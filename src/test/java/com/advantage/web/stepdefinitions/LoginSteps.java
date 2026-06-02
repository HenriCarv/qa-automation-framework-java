package com.advantage.web.stepdefinitions;

import com.advantage.pages.CheckoutPage;
import com.advantage.pages.HomePage;
import com.advantage.pages.LoginPage;
import com.advantage.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("the user accesses the Advantage Shopping website")
    public void userAccessesWebsite() {
        homePage.openWebsite();
    }

    @When("the user logs in with valid credentials")
    public void userLogsIn() {
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );;
    }

    @Then("the user should see the home page")
    public void the_user_should_see_the_home_page() {
        homePage.waitSearchProduct();
    }

    @When("the user enters an invalid username {string} and valid password {string}")
    public void the_user_enters_an_invalid_username_and_valid_password(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("the user should see the error message {string}")
    public void theUserShouldSeeTheErrorMessage(String expectedMessage) {

        loginPage.validateLoginErrorMessage(
                expectedMessage
        );
    }

    @When("the user opens the login modal")
    public void openLoginModal() {
        loginPage.openLoginModal();
    }

    @When("clicks on username field")
    public void clickUsernameField() {
        loginPage.clickUsernameField();
    }

    @When("clicks on password field")
    public void clickPasswordField() {
        loginPage.clickPasswordField();
    }

    @When("clicks outside the login fields")
    public void clickOutsideFields() {
        loginPage.clickOutsideFields();
    }

    @Then("the username required message should be {string}")
    public void validateUsernameRequiredMessage(String expectedMessage) {

        loginPage.validateUsernameRequiredMessage(
                expectedMessage
        );
    }

    @Then("the password required message should be {string}")
    public void validatePasswordRequiredMessage(String expectedMessage) {

        loginPage.validatePasswordRequiredMessage(
                expectedMessage
        );
    }
}