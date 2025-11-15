package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By inventoryItem = By.className("inventory_item");
    private By sortDropdown = By.className("product_sort_container");

    // Logout locators
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public int getProductCount() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItem));
        List<WebElement> items = driver.findElements(inventoryItem);
        System.out.println("Number of products found: " + items.size());
        return items.size();
    }

    public void selectSortOption(String visibleText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
        System.out.println("Selected sort option: " + visibleText);
    }

    // Open the sidebar menu
    public void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
    }

    // Click the logout link
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}

