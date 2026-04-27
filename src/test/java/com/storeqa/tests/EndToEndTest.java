
package com.storeqa.tests;

import com.storeqa.base.BaseTest;
import com.storeqa.pages.LoginPage;
import com.storeqa.pages.RegisterPage;
import com.storeqa.utils.EmailUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test
    public void testRegisterLogoutLoginFlow() {

        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Register
        registerPage.navigateToRegister();

        String email = EmailUtil.generateUniqueEmail();
        String password = "Password@123";

        registerPage.register("John", "Doe", email, password);

        // Step 2: Verify registration success
        Assert.assertTrue(driver.getCurrentUrl().contains("success"), "Registration failed");

        // Step 3: Logout
        loginPage.logout();

        // Step 4: Login again
        loginPage.navigateToLogin();
        loginPage.login(email, password);

        // Step 5: Verify login success
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed after registration");
    }
}