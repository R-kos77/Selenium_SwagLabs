package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {
        System.out.println("Logging in as standard_user...");
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        System.out.println("Sorting products by Price (low to high)...");
        ProductsPage products = new ProductsPage(driver);
        products.selectSortOption("Price (low to high)");

        System.out.println("Adding backpack to cart...");
        CartPage cart = new CartPage(driver);
        cart.addBackpackToCart();

        System.out.println("Opening cart page...");
        cart.openCart();

        System.out.println("Verifying item is in cart...");
        Assert.assertTrue(cart.isItemInCart(), "No items in cart!");

        System.out.println("Clicking checkout...");
        cart.clickCheckout();

        System.out.println("Entering checkout information...");
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterFirstName("John");
        checkout.enterLastName("Doe");
        checkout.enterPostalCode("12345");

        System.out.println("Continuing and finishing checkout...");
        checkout.clickContinue();
        checkout.clickFinish();

        String message = checkout.getCompleteMessage();
        System.out.println("Order completion message: " + message);

        Assert.assertEquals(message, "THANK YOU FOR YOUR ORDER!", "Checkout confirmation not displayed!");

        System.out.println("Checkout flow test passed.");
    }
}
