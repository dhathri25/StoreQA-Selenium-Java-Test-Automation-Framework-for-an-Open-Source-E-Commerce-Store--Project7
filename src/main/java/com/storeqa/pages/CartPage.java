package com.storeqa.pages;

import com.storeqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Add to cart
    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    // Cart button
    @FindBy(id = "cart-total")
    private WebElement cartTotal;

    @FindBy(linkText = "Shopping Cart")
    private WebElement shoppingCartLink;

    // Cart items
    @FindBy(css = ".table tbody tr")
    private List<WebElement> cartItems;

    @FindBy(css = "input[name*='quantity']")
    private WebElement quantityField;

    @FindBy(css = "button[data-original-title='Update']")
    private WebElement updateButton;

    @FindBy(css = "button[data-original-title='Remove']")
    private WebElement removeButton;

    // Actions

    public void addProductToCart() {
        click(addToCartButton);

        // wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-success")
        ));
    }

    public String getCartCount() {
        waitForVisibility(cartTotal);
        return cartTotal.getText();
    }

    public void openCart() {
        click(cartTotal);
        click(shoppingCartLink);
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public void updateQuantity(String qty) {
        sendKeys(quantityField, qty);
        click(updateButton);

        // wait for update success
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-success")
        ));
    }

    public void removeItem() {
        click(removeButton);

        // wait until empty message appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'shopping cart is empty')]")
        ));
    }

    public boolean isCartEmpty() {
        return driver.getPageSource().toLowerCase().contains("shopping cart is empty");
    }
}