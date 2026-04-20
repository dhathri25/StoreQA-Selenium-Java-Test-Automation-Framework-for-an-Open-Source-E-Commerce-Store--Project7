package com.storeqa.tests;

import com.storeqa.base.BaseTest;
import com.storeqa.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        ProductPage productPage = new ProductPage(driver);

        productPage.searchProduct("MacBook");

        Assert.assertTrue(productPage.isSearchResultDisplayed(),
                "Search results not displayed");
    }

    @Test
    public void testSearchNoResults() {
        ProductPage productPage = new ProductPage(driver);

        productPage.searchProduct("InvalidProduct123");

        Assert.assertTrue(productPage.isNoResultMessageDisplayed(),
                "No result message not shown");
    }

    @Test
    public void testProductDetails() {
        ProductPage productPage = new ProductPage(driver);

        productPage.searchProduct("MacBook");
        productPage.openFirstProduct();

        Assert.assertTrue(productPage.getProductTitle().length() > 0);
        Assert.assertTrue(productPage.getProductPrice().length() > 0);
    }
}