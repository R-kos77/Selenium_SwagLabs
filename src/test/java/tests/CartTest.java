package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCartTest() {
        // Login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.addBackpackToCart();
        cartPage.openCart();

        // Verify item is in cart
        Assert.assertTrue(cartPage.isItemInCart(), "Item was not added to cart!");
    }
}
