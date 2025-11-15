package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // maximize window
        // options.addArguments("--headless"); // uncomment to run without GUI

        // Optional: run in incognito mode (extra isolation)
        options.addArguments("--incognito");

        // Use a fresh Chrome profile to avoid popups and saved passwords
        options.addArguments("user-data-dir=C:/Selenium/FreshProfile"); // <-- change path as needed

        // Disable Chrome password manager popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Initialize Chrome driver
        driver = new ChromeDriver(options);

        // Navigate to Swag Labs
        driver.get("https://www.saucedemo.com/");

        // Print page title for debugging
        System.out.println("Browser launched. Page title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // close the browser after each test
            System.out.println("Browser closed.");
        }
    }
}
