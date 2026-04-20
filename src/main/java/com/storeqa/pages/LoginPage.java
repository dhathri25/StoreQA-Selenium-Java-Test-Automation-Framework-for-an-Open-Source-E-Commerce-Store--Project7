package com.storeqa.pages;

import com.storeqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "My Account")
    private WebElement myAccount;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(css = "input[value='Login']")
    private WebElement loginButton;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;
    
    @FindBy(linkText = "Logout")
    private WebElement logoutOption;

    

    @FindBy(css = "h2")
    private WebElement accountHeader;

    // Actions

    public void navigateToLogin() {
        click(myAccount);
        click(loginOption);
    }

    public void login(String email, String password) {
        sendKeys(emailField, email);
        sendKeys(passwordField, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
    public void logout() {
        click(myAccount);
        click(logoutOption);
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("account");
    }
}