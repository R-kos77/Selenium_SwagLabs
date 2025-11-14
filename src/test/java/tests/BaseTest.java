package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Optional Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // maximize window
        // options.addArguments("--headless"); // uncomment to run without GUI

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
