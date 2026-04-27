
package com.storeqa.utils;

import org.openqa.selenium.WebDriver;

public class TestContextHolder {

    private static final ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverHolder.set(driver);
    }

    public static WebDriver getDriver() {
        return driverHolder.get();
    }

    public static void removeDriver() {
        driverHolder.remove();
    }
}