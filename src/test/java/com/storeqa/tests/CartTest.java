package com.storeqa.tests;

import com.storeqa.base.BaseTest;
import com.storeqa.pages.CartPage;
import com.storeqa.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        cartPage.addProductToCart();

        // better validation
        Assert.assertTrue(cartPage.getCartCount().contains("item"),
                "Cart count not updated");
    }

    @Test
    public void testUpdateCartQuantity() {

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        cartPage.addProductToCart();
        cartPage.openCart();

        cartPage.updateQuantity("2");

        Assert.assertTrue(cartPage.getCartCount().contains("2"),
                "Quantity not updated");
    }

    @Test
    public void testRemoveFromCart() {

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        cartPage.addProductToCart();
        cartPage.openCart();

        cartPage.removeItem();

        Assert.assertTrue(cartPage.isCartEmpty(),
                "Item not removed from cart");
    }
}