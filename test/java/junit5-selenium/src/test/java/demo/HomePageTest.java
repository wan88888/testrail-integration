package demo;

import demo.driver.DriverManager;
import demo.pages.InventoryPage;
import demo.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test cases for SauceDemo login and home page functionality
 * Uses Page Object Model pattern for better maintainability
 */
@DisplayName("SauceDemo Home Page Tests")
public class HomePageTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        DriverManager.initDriver();
        loginPage = new LoginPage().open();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test
    @DisplayName("Verify login page title contains 'Swag Labs'")
    void verifyLoginPageTitle() {
        assertTrue(loginPage.getTitle().contains("Swag Labs"),
            "Page title should contain 'Swag Labs'");
    }

    @Test
    @DisplayName("Verify successful login with valid credentials")
    void verifySuccessfulLoginWithValidCredentials() {
        // Login using Page Object
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();

        // Verify successful login
        assertTrue(inventoryPage.isPageLoaded(), "Should be redirected to inventory page");
        assertTrue(inventoryPage.isTitleDisplayed(), "Products title should be displayed");
        assertEquals("Products", inventoryPage.getPageTitle(), "Page title should be 'Products'");
    }

    @Test
    @DisplayName("Verify products are displayed after login")
    void verifyProductsDisplayedAfterLogin() {
        // Login using Page Object
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();

        // Verify products are displayed
        assertTrue(inventoryPage.isInventoryListDisplayed(), "Inventory list should be displayed");
        assertTrue(inventoryPage.hasProducts(), "At least one product should be displayed");
    }

    @Test
    @DisplayName("Verify login page elements are displayed")
    void verifyLoginPageElements() {
        assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field should be displayed");
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be displayed");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be displayed");
        assertTrue(loginPage.isLogoDisplayed(), "Logo should be displayed");
        assertEquals("Swag Labs", loginPage.getLogoText(), "Logo text should be 'Swag Labs'");
    }
}
