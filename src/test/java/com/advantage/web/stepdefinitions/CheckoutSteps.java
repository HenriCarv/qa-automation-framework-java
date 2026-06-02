package com.advantage.web.stepdefinitions;

import com.advantage.pages.CheckoutPage;
import com.advantage.pages.HomePage;
import com.advantage.pages.LoginPage;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @When("the user searches for a product")
    public void userSearchesProduct() {
        homePage.searchProduct();
    }

    @And("the user adds the product to the cart")
    public void userAddsProductToCart() {
        checkoutPage.addProductToCart();
    }

    @And("the user opens the shopping cart")
    public void userOpensCart() {
        checkoutPage.openCart();
    }

    @Then("the selected product should be displayed in the shopping cart")
    public void theSelectedProductShouldBeDisplayedInTheShoppingCart() {

        String selectedProduct = checkoutPage.getSelectedProductName();
        String cartProduct = checkoutPage.getCartProductName();

        System.out.println("Produto selecionado: " + selectedProduct);
        System.out.println("Produto no carrinho: " + cartProduct);

        assertTrue(
                selectedProduct.equalsIgnoreCase(cartProduct)
        );

        System.out.println("Validação realizada com sucesso: o produto do carrinho corresponde ao produto selecionado.");
    }

}