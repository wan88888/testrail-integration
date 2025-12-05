package demo.pages;

import demo.config.TestConfig;
import org.openqa.selenium.By;

/**
 * Page Object for the SauceDemo login page
 */
public class LoginPage extends BasePage {
    
    // Locators
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
    private static final By LOGIN_LOGO = By.className("login_logo");
    
    public LoginPage() {
        super();
    }
    
    public LoginPage open() {
        driver.navigate().to(TestConfig.getBaseUrl());
        return this;
    }
    
    public LoginPage enterUsername(String username) {
        type(USERNAME_INPUT, username);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }
    
    public InventoryPage clickLogin() {
        click(LOGIN_BUTTON);
        return new InventoryPage();
    }
    
    public LoginPage clickLoginExpectingError() {
        click(LOGIN_BUTTON);
        return this;
    }
    
    public InventoryPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLogin();
    }
    
    public InventoryPage loginAsStandardUser() {
        return loginAs(TestConfig.getStandardUsername(), TestConfig.getStandardPassword());
    }
    
    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(USERNAME_INPUT);
    }
    
    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(PASSWORD_INPUT);
    }
    
    public boolean isLoginButtonDisplayed() {
        return isDisplayed(LOGIN_BUTTON);
    }
    
    public boolean isLogoDisplayed() {
        return isDisplayed(LOGIN_LOGO);
    }
    
    public String getLogoText() {
        return getText(LOGIN_LOGO);
    }
    
    public String getErrorMessage() {
        return getText(ERROR_MESSAGE);
    }
    
    public boolean isErrorDisplayed() {
        return isDisplayed(ERROR_MESSAGE);
    }
}

