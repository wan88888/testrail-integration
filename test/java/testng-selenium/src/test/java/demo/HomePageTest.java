package demo;

import demo.driver.DriverManager;
import demo.pages.InventoryPage;
import demo.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Test cases for SauceDemo login and home page functionality
 * Uses Page Object Model pattern for better maintainability
 */
public class HomePageTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        loginPage = new LoginPage().open();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test(description = "Verify login page title contains 'Swag Labs'")
    public void verifyLoginPageTitle() {
        assertTrue(loginPage.getTitle().contains("Swag Labs"),
            "Page title should contain 'Swag Labs'");
    }

    @Test(description = "Verify successful login with valid credentials")
    public void verifySuccessfulLoginWithValidCredentials() {
        // Login using Page Object
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();

        // Verify successful login
        assertTrue(inventoryPage.isPageLoaded(), "Should be redirected to inventory page");
        assertTrue(inventoryPage.isTitleDisplayed(), "Products title should be displayed");
        assertEquals(inventoryPage.getPageTitle(), "Products", "Page title should be 'Products'");
    }

    @Test(description = "Verify products are displayed after login")
    public void verifyProductsDisplayedAfterLogin() {
        // Login using Page Object
        InventoryPage inventoryPage = loginPage.loginAsStandardUser();

        // Verify products are displayed
        assertTrue(inventoryPage.isInventoryListDisplayed(), "Inventory list should be displayed");
        assertTrue(inventoryPage.hasProducts(), "At least one product should be displayed");
    }

    @Test(description = "Verify login page elements are displayed")
    public void verifyLoginPageElements() {
        assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field should be displayed");
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be displayed");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be displayed");
        assertTrue(loginPage.isLogoDisplayed(), "Logo should be displayed");
        assertEquals(loginPage.getLogoText(), "Swag Labs", "Logo text should be 'Swag Labs'");
    }
}
