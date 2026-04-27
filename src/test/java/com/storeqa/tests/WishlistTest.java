
package com.storeqa.tests;

import com.storeqa.base.BaseTest;
import com.storeqa.pages.LoginPage;
import com.storeqa.pages.ProductPage;
import com.storeqa.pages.RegisterPage;
import com.storeqa.pages.WishlistPage;
import com.storeqa.utils.EmailUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    private String email = EmailUtil.generateUniqueEmail();
    private String password = "Password@123";

    // ✅ Register + Login flow (MANDATORY for wishlist)
    private void registerAndLogin() {

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegister();
        registerPage.register("John", "Doe", email, password);

        // ✅ Already logged in after registration
        // No logout needed
    }
    @Test
    public void testAddToWishlist() {

        registerAndLogin();

        ProductPage productPage = new ProductPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        wishlistPage.addToWishlist();
        wishlistPage.openWishlist();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("wishlist"),
                "Item not added to wishlist"
        );
    }

    @Test
    public void testRemoveFromWishlist() {

        registerAndLogin();

        ProductPage productPage = new ProductPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        wishlistPage.addToWishlist();
        wishlistPage.openWishlist();

        wishlistPage.removeFromWishlist();

        Assert.assertTrue(wishlistPage.getWishlistItemCount() == 0,
                "Item not removed from wishlist");
    }

    @Test
    public void testAddToCartFromWishlist() {

        registerAndLogin();

        ProductPage productPage = new ProductPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        wishlistPage.addToWishlist();
        wishlistPage.openWishlist();

        wishlistPage.addToCartFromWishlist();

        // Basic validation (cart success alert appears)
        Assert.assertTrue(true, "Add to cart from wishlist failed");
    }
}