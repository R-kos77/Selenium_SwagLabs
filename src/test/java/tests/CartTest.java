package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCartTest() {
        System.out.println("Logging in as standard_user...");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        System.out.println("Adding backpack to cart...");
        CartPage cartPage = new CartPage(driver);
        cartPage.addBackpackToCart();

        System.out.println("Opening cart page...");
        cartPage.openCart();

        System.out.println("Verifying item is in cart...");
        Assert.assertTrue(cartPage.isItemInCart(), "Item was not added to cart!");

        System.out.println("Add item to cart test passed.");
    }
}
