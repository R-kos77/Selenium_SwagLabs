Selenium SwagLabs Automation Suite

This project is a complete Selenium TestNG automation framework for the Swag Labs web application.
It includes login validation, product listing checks, sorting tests, cart functionality, checkout flow, and logout verification.

Project Structure
src
 ├── main
 │    └── java
 │         └── pages
 │               LoginPage.java
 │               ProductsPage.java
 │               CartPage.java
 │               CheckoutPage.java
 └── test
      └── java
           └── tests
                BaseTest.java
                LoginTest.java
                ProductsTest.java
                CartTest.java
                CheckoutTest.java
                LogoutTest.java

testng.xml
pom.xml
README.md

Technologies Used

Java 17+

Selenium WebDriver 4.x

TestNG 7.x

Maven

ChromeDriver

Page Object Model (POM)

Features Automated
Login Tests

Valid login with standard user

Invalid login with error message validation

Product Tests

Validate total number of products displayed

Test sorting functionality

Cart Tests

Add item to cart and verify presence

Checkout Tests

Complete checkout end-to-end

Validate final confirmation message

Logout Test

Validate menu navigation and logout functionality

How to Run the Tests
1. Install Dependencies

Run:

mvn clean install

2. Execute the Test Suite

Run the entire suite using:

mvn test


Or execute TestNG directly:

Right-click testng.xml → Run As → TestNG Suite

Test Reports

After execution, TestNG HTML reports are automatically generated in:

test-output/index.html


Open this file in any web browser to view the detailed report.

Browser Compatibility

This framework currently uses ChromeDriver.
Make sure your Chrome version matches your installed driver.

Notes

All waits are implemented using WebDriverWait for stability.

Tests are isolated using a fresh browser session per test.

Page Object Model structure ensures maintainability and scalability.

---

## Author
**Robel Kiros**  
- GitHub: R-Kos77 https://github.com/R-kos77/Selenium_SwagLabs  
- Email: robelalbeta@gmail.com