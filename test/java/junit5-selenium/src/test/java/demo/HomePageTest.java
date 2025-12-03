package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HomePageTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--no-proxy-server");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Navigate to SauceDemo website
        driver.navigate().to("https://www.saucedemo.com");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void verifyLoginPageTitle() {
        // Verify the login page title
        assertTrue(driver.getTitle().contains("Swag Labs"));
    }

    @Test
    void verifySuccessfulLoginWithValidCredentials() {
        // Enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Wait for products page to load
        wait.until(ExpectedConditions.urlContains("inventory.html"));

        // Verify we are on the products page
        WebElement productsTitle = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        assertTrue(productsTitle.isDisplayed());
        assertEquals("Products", productsTitle.getText());
    }

    @Test
    void verifyProductsDisplayedAfterLogin() {
        // Login with valid credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for products page to load
        wait.until(ExpectedConditions.urlContains("inventory.html"));

        // Verify that products are displayed
        WebElement inventoryList = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list"))
        );
        assertTrue(inventoryList.isDisplayed());

        // Verify there are products in the list
        int productCount = driver.findElements(By.className("inventory_item")).size();
        assertTrue(productCount > 0, "At least one product should be displayed");
    }
}

