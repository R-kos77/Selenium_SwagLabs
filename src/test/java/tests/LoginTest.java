package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        System.out.println("Attempting valid login...");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login failed!");

        System.out.println("Valid login test passed.");
    }

    @Test
    public void invalidLoginTest() {
        System.out.println("Attempting invalid login...");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_password");

        String error = loginPage.getErrorMessage();
        System.out.println("Error message displayed: " + error);
        Assert.assertTrue(error.contains("Username and password do not match"), "Error message not shown!");

        System.out.println("Invalid login test passed.");
    }
}
