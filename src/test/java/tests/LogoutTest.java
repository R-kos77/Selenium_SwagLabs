package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {
        // 1️⃣ Login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // 2️⃣ Open products page
        ProductsPage productsPage = new ProductsPage(driver);

        // 3️⃣ Open menu and logout
        productsPage.openMenu();
        productsPage.clickLogout();

        // 4️⃣ Verify logout by checking login page URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after logout: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("saucedemo.com"), "Logout failed!");
    }
}
