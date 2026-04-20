# StoreQA – Selenium Java Automation Framework

## 📌 Project Overview

StoreQA is a Selenium-based automation framework developed using Java to test an open-source e-commerce application (OpenCart).

The framework follows the Page Object Model (POM) design pattern and includes end-to-end automation for major user workflows such as authentication, product browsing, cart operations, and wishlist management.

---

## 🚀 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports

---

## 🌐 Application Under Test

https://demo.opencart.com

---

## 📂 Project Structure

```
StoreQA-Framework/
│
├── src/main/java/com.storeqa.base        → Base classes
├── src/main/java/com.storeqa.config      → Config reader
├── src/main/java/com.storeqa.pages       → Page Object classes
├── src/main/java/com.storeqa.utils       → Utilities (Email, Screenshot, Extent)
│
├── src/test/java/com.storeqa.tests       → Test classes
├── src/test/java/com.storeqa.listeners   → TestNG listener
│
├── src/main/resources/config.properties  → Config file
├── screenshots/                          → Failure screenshots
├── reports/                              → Extent reports
├── testng.xml                            → Test suite
├── pom.xml                               → Dependencies
```

---

## 🧪 Test Coverage

### ✅ Authentication

* User Registration
* Login (valid & invalid)
* Logout

### ✅ Product Module

* Search product
* Category navigation
* Product details verification

### ✅ Cart Module

* Add to cart
* Update quantity
* Remove item

### ✅ Wishlist Module

* Add to wishlist
* Remove from wishlist
* Add to cart from wishlist

### ✅ End-to-End Flow

* Register → Logout → Login

---

## ⚙️ Configuration

File: `config.properties`

```
browser=chrome
baseUrl=https://demo.opencart.com
timeout=10
```

---

## ▶️ How to Run Tests

### Using Maven:

```
mvn test
```

### Using TestNG:

* Right click `testng.xml` → Run

---

## 📊 Reporting

* Extent Report generated at:

```
/reports/ExtentReport.html
```

* Screenshots captured on failure:

```
/screenshots/
```

---

## 🔥 Key Features

* Page Object Model (POM)
* Explicit Wait Strategy (No Thread.sleep)
* Screenshot on Failure (ITestListener)
* Extent HTML Reports
* Config-driven framework
* Reusable and scalable design

---

## 🧠 Design Highlights

* No WebDriver code inside test classes
* All actions handled in Page classes
* Centralized configuration management
* Clean separation of concerns

---

## 🎯 Conclusion

This framework demonstrates a scalable and maintainable automation design that follows industry best practices and supports real-world testing scenarios.

---

## 👤 Author

Hema K
