package com.storeqa.tests;

import com.storeqa.base.BaseTest;
import com.storeqa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"invalid@gmail.com", "wrongpass", "invalid"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, String type) {

        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Navigate to login page
        loginPage.navigateToLogin();

        // Step 2: Perform login
        loginPage.login(email, password);

        // Step 3: Validate error message
        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.contains("Warning"), "Error message not displayed for invalid login");
    }
}