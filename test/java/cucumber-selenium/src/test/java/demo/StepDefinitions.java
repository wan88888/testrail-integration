package demo;

import demo.driver.DriverManager;
import demo.pages.InventoryPage;
import demo.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cucumber step definitions using Page Object Model
 */
public class StepDefinitions {
    
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Before
    public void setUp() {
        DriverManager.initDriver();
    }

    @Given("I navigate to the saucedemo website")
    public void i_navigate_to_the_saucedemo_website() {
        loginPage = new LoginPage().open();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        inventoryPage = loginPage.clickLogin();
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        assertTrue(inventoryPage.isPageLoaded(), "Should be on inventory page");
        assertTrue(inventoryPage.isTitleDisplayed(), "Products title should be displayed");
        assertEquals("Products", inventoryPage.getPageTitle());
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
