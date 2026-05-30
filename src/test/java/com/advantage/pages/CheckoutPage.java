package com.advantage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "addToCart")
    private WebElement addToCart;

    @FindBy(id = "shoppingCart")
    private WebElement cart;

    @FindBy(id = "checkOutButton")
    private WebElement checkout;

    @FindBy(id = "payment")
    private WebElement paymentField;

    @FindBy(id = "confirm")
    private WebElement confirmButton;

    public void addProductToCart() {
        clickElement(addToCart);
    }

    public void openCart() {
        clickElement(cart);
    }

    public void proceedToCheckout() {
        clickElement(checkout);
    }

    public void fillPaymentData() {
        typeText(paymentField, "1234-5678-9999");
    }

    public void confirmPurchase() {
        clickElement(confirmButton);
    }

    public void validateSuccessPurchase() {
        System.out.println("Purchase completed successfully");
    }
}