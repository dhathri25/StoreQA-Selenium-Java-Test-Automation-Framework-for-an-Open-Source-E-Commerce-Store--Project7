
package com.storeqa.pages;

import com.storeqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "My Account")
    private WebElement myAccount;

    @FindBy(linkText = "Register")
    private WebElement registerOption;

    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='newsletter' and @value='0']")
    private WebElement newsletterNo;

    @FindBy(name = "agree")
    private WebElement privacyPolicy;

    @FindBy(css = "input[type='submit'], button[type='submit']")
    private WebElement continueButton;

    @FindBy(css = "h1")
    private WebElement successMessage;

    // Actions

    public void navigateToRegister() {
        click(myAccount);
        click(registerOption);
    }

    public void register(String fName, String lName, String emailId, String pwd) {
        sendKeys(firstName, fName);
        sendKeys(lastName, lName);
        sendKeys(email, emailId);
        sendKeys(telephone, "9876543210");
        sendKeys(password, pwd);
        sendKeys(confirmPassword, pwd);

        click(newsletterNo);
        click(privacyPolicy);

        // ✅ Proper wait before click
        waitForVisibility(continueButton);

        // ✅ Simple reliable click (no JS needed now)
        click(continueButton);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
    public boolean isRegistrationSuccessful() {
        return driver.getCurrentUrl().contains("success");
    }
}