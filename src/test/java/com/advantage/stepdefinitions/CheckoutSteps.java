package com.advantage.stepdefinitions;

import com.advantage.pages.CheckoutPage;
import com.advantage.pages.HomePage;
import com.advantage.pages.LoginPage;
import io.cucumber.java.en.*;

public class CheckoutSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("the user accesses the Advantage Shopping website")
    public void userAccessesWebsite() {
        homePage.openWebsite();
    }

    @When("the user logs in with valid credentials")
    public void userLogsIn() {
        loginPage.login("teste123", "Teste@123");
    }

    @When("the user searches for a product")
    public void userSearchesProduct() {
        homePage.searchProduct("laptop");
    }

    @And("the user adds the product to the cart")
    public void userAddsProductToCart() {
        checkoutPage.addProductToCart();
    }

    @And("the user opens the shopping cart")
    public void userOpensCart() {
        checkoutPage.openCart();
    }

    @And("the user proceeds to checkout")
    public void userProceedsToCheckout() {
        checkoutPage.proceedToCheckout();
    }

    @And("the user fills in payment details")
    public void userFillsPaymentDetails() {
        checkoutPage.fillPaymentData();
    }

    @And("the user confirms the purchase")
    public void userConfirmsPurchase() {
        checkoutPage.confirmPurchase();
    }

    @Then("the purchase should be completed successfully")
    public void purchaseShouldBeSuccessful() {
        checkoutPage.validateSuccessPurchase();
    }

    @Then("the user should see the home page")
    public void the_user_should_see_the_home_page() {
        homePage.waitSearchProduct();
    }

}