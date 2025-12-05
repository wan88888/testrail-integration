package demo.pages;

import demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base page class with common page operations
 */
public abstract class BasePage {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    protected BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getWait();
    }
    
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    
    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void click(By locator) {
        waitForElement(locator).click();
    }
    
    protected void type(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }
    
    protected boolean isDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    protected void waitForUrlContains(String urlPart) {
        wait.until(ExpectedConditions.urlContains(urlPart));
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}

