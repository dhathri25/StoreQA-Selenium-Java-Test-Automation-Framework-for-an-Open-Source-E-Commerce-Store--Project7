# StoreQA – High-Stability Selenium Automation Framework

## Project Overview
StoreQA is a Selenium-based automation framework developed in Java for the OpenCart e-commerce platform. It utilizes the **Page Object Model (POM)** to ensure a clean separation between test logic and site-specific locators. The framework is engineered to handle modern bot-detection (Cloudflare) and synchronization issues common in automated environments.



---

## Project Structure
* **com.storeqa.base**: Contains BaseTest for driver lifecycle and BasePage for global interaction wrappers.
* **com.storeqa.pages**: Encapsulates Page Factory locators and action methods for application modules.
* **com.storeqa.tests**: Contains TestNG test classes categorized by functional module.
* **com.storeqa.utils**: Includes ScreenshotUtil, ExtentManager, and EmailUtil for dynamic data and reporting.
* **com.storeqa.listeners**: Implements ITestListener for real-time failure handling and reporting.

---

## Tech Stack
* **Language**: Java 17
* **Automation**: Selenium WebDriver 4.18.1
* **Test Runner**: TestNG 7.9.0
* **Build Tool**: Maven
* **Reporting**: ExtentReports 5.1.1
* **Driver Management**: WebDriverManager 5.8.0

---

## Technical Solutions and Key Features

### 1. Anti-Bot and Stealth Configuration
The framework addresses Cloudflare "Security Verification" loops by modifying the browser fingerprint:
* **Stealth Flags**: Uses `excludeSwitches` to disable automation indicators.
* **JS Injection**: Replaces the `navigator.webdriver` property to mirror manual user sessions.
* **Paced Interaction**: The `sendKeys` implementation processes text character-by-character to bypass speed-based detection.

### 2. Resilience and Sync Strategy
To resolve site lag and element interception errors:
* **Hybrid Click Mechanism**: Combines `ExpectedConditions` with a `JavascriptExecutor` fallback to bypass invisible UI overlays.
* **Explicit Waits**: Avoids `Thread.sleep()` in favor of dynamic polling for element states via `WebDriverWait`.

### 3. Reporting and Failure Analysis
* **Automated Screenshots**: Failure states are captured and embedded into the HTML report via the TestNG listener.
* **Thread-Safe Reporting**: Utilizes `ThreadLocal` in the listener to support parallel execution without data corruption.

---

## Test Coverage
* **Authentication**: Unique User Registration, Multi-set DataProvider Login, Logout.
* **Product Management**: Search functionality, Product Details, and Category Filtering.
* **Cart Operations**: Add to Cart, Quantity Management, and Item Removal.
* **Wishlist Management**: Transferring items from Wishlist to Cart.
* **End-to-End Flow**: Full user journey from Registration through to valid Login.

---

## Setup and Execution

### Configuration
Update `src/main/resources/config.properties`:
```properties
browser=chrome
baseUrl=https://opencart.abstracta.us/
timeout=15
```

### Execution via Maven
```bash
mvn clean test
```

---

## Artifacts
* **Extent Report**: `reports/ExtentReport.html`
* **Screenshots**: `screenshots/`

---

## Author
**Dhathri Putty**
