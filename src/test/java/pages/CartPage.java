package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCartLink = By.className("shopping_cart_link");
    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");  // <-- move here

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void addBackpackToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public boolean isItemInCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void clickCheckout() {  // <-- move here
        driver.findElement(checkoutButton).click();
    }
}
