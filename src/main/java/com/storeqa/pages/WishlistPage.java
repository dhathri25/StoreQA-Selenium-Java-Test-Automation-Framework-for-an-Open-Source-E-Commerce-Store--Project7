
package com.storeqa.pages;

import com.storeqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Add to wishlist (product page)
    @FindBy(css = "button[data-original-title='Add to Wish List']")
    private WebElement addToWishlistButton;

    // Success message
    @FindBy(css = ".alert-success")
    private WebElement successAlert;

    @FindBy(css = "#wishlist-total")
    private WebElement wishlistLink;

    // Wishlist table rows
    @FindBy(css = ".table tbody tr")
    private List<WebElement> wishlistItems;

    @FindBy(xpath = "//a[contains(@data-original-title,'Remove')]")
    private WebElement removeButton;

    @FindBy(css = "button[data-original-title='Add to Cart']")
    private WebElement addToCartFromWishlist;

    // Actions

    public void addToWishlist() {
        click(addToWishlistButton);

        wait.until(ExpectedConditions.visibilityOf(successAlert));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#wishlist-total")
        ));
    }

    public void openWishlist() {
        click(wishlistLink);
    }

    public int getWishlistItemCount() {
        return wishlistItems.size();
    }

    public void removeFromWishlist() {
        click(removeButton);

        wait.until(ExpectedConditions.invisibilityOf(removeButton));
    }

    public void addToCartFromWishlist() {
        click(addToCartFromWishlist);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-success")
        ));
    }
}