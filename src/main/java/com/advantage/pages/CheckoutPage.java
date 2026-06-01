package com.advantage.pages;

import com.advantage.utils.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Util {

    @FindBy(name = "save_to_cart")
    private WebElement addToCart;

    @FindBy(id = "shoppingCartLink")
    private WebElement cart;

    @FindBy(xpath = "(//li[@ng-click=\"$location.path('/product/' + product.productId)\"])[1]")
    private WebElement firstIten;

    @FindBy(xpath = "(//a[@class=\"productName ng-binding\"])[1]")
    private WebElement firstProductName;

    @FindBy(xpath = "//label[@class=\"roboto-regular productName ng-binding\"]")
    private WebElement cartProductName;


    public void addProductToCart() {
        waitForElement(firstIten);
        selectedProductName = firstProductName.getText().trim();
        clickElement(firstIten);
        clickElement(addToCart);
    }

    public void openCart() {
        clickElement(cart);
    }

    private String selectedProductName;

    public String getSelectedProductName() {
        return selectedProductName;
    }

    public String getCartProductName() {
        waitForElement(cartProductName);
        return cartProductName.getText().trim();
    }

}