
package com.storeqa.tests;

import com.storeqa.base.BaseTest;
import com.storeqa.pages.RegisterPage;
import com.storeqa.utils.EmailUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void testUserRegistration() {

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.navigateToRegister();

        String email = EmailUtil.generateUniqueEmail();

        registerPage.register("John", "Doe", email, "Password@123");

        String message = registerPage.getSuccessMessage();
        System.out.println("ACTUAL MESSAGE: " + message);

        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration failed");
        System.out.println(driver.getPageSource());
    }
}