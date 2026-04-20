package com.storeqa.pages;

import com.storeqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Search
    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "button.btn.btn-default")
    private WebElement searchButton;

    @FindBy(css = ".product-thumb")
    private List<WebElement> searchResults;

    @FindBy(css = "#content p")
    private WebElement noResultsMessage;

    // Category
    @FindBy(linkText = "Desktops")
    private WebElement desktopsMenu;

    @FindBy(linkText = "Show All Desktops")
    private WebElement showAllDesktops;

    // Product
    @FindBy(css = "h1")
    private WebElement productTitle;

    @FindBy(css = ".list-unstyled h2")
    private WebElement productPrice;
    
    @FindBy(css = ".product-thumb h4 a")
    private List<WebElement> productLinks;

    // Actions

    public void searchProduct(String productName) {
        sendKeys(searchBox, productName);
        click(searchButton);
    }

    public boolean isSearchResultDisplayed() {
        return searchResults.size() > 0;
    }

    public boolean isNoResultMessageDisplayed() {
        return noResultsMessage.getText().toLowerCase().contains("no products");
    }

    public void navigateToDesktops() {
        click(desktopsMenu);
        click(showAllDesktops);
    }

    public void openFirstProduct() {
        click(productLinks.get(0));
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }
}