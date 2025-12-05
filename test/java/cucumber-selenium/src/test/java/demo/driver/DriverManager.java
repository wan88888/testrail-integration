package demo.driver;

import demo.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WebDriver manager for creating and managing browser instances
 */
public final class DriverManager {
    
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waitThreadLocal = new ThreadLocal<>();
    
    private DriverManager() {
        // Utility class, prevent instantiation
    }
    
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            initDriver();
        }
        return driverThreadLocal.get();
    }
    
    public static WebDriverWait getWait() {
        if (waitThreadLocal.get() == null && driverThreadLocal.get() != null) {
            waitThreadLocal.set(new WebDriverWait(driverThreadLocal.get(), 
                Duration.ofSeconds(TestConfig.getExplicitTimeout())));
        }
        return waitThreadLocal.get();
    }
    
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = createChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        configureDriver(driver);
        driverThreadLocal.set(driver);
        waitThreadLocal.set(new WebDriverWait(driver, Duration.ofSeconds(TestConfig.getExplicitTimeout())));
    }
    
    private static ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        if (TestConfig.isHeadless()) {
            options.addArguments("--headless");
        }
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=" + TestConfig.getWindowWidth() + "," + TestConfig.getWindowHeight());
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return options;
    }
    
    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestConfig.getImplicitTimeout()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestConfig.getPageLoadTimeout()));
    }
    
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            waitThreadLocal.remove();
        }
    }
}

