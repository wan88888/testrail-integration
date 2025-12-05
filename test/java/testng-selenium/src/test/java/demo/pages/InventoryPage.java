package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Page Object for the SauceDemo inventory/products page
 */
public class InventoryPage extends BasePage {
    
    // Locators
    private static final By PAGE_TITLE = By.className("title");
    private static final By INVENTORY_LIST = By.className("inventory_list");
    private static final By INVENTORY_ITEM = By.className("inventory_item");
    private static final By APP_LOGO = By.className("app_logo");
    private static final By SHOPPING_CART = By.className("shopping_cart_link");
    
    public InventoryPage() {
        super();
        waitForPageLoad();
    }
    
    private void waitForPageLoad() {
        waitForUrlContains("inventory.html");
        waitForElement(INVENTORY_LIST);
    }
    
    public boolean isPageLoaded() {
        return getCurrentUrl().contains("inventory.html") && isDisplayed(INVENTORY_LIST);
    }
    
    public String getPageTitle() {
        return getText(PAGE_TITLE);
    }
    
    public boolean isTitleDisplayed() {
        return isDisplayed(PAGE_TITLE);
    }
    
    public boolean isInventoryListDisplayed() {
        return isDisplayed(INVENTORY_LIST);
    }
    
    public int getProductCount() {
        List<WebElement> items = driver.findElements(INVENTORY_ITEM);
        return items.size();
    }
    
    public boolean hasProducts() {
        return getProductCount() > 0;
    }
    
    public boolean isAppLogoDisplayed() {
        return isDisplayed(APP_LOGO);
    }
    
    public boolean isShoppingCartDisplayed() {
        return isDisplayed(SHOPPING_CART);
    }
}

