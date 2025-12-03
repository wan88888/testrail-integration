package demo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
	private WebDriver driver = null;
	private WebDriverWait wait;

	@Before
	public void initWebDriverSetup() {
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
	}

	@Given("I navigate to the saucedemo website")
	public void i_navigate_to_the_saucedemo_website() {
		driver.navigate().to("https://www.saucedemo.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
	}

	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		WebElement usernameField = driver.findElement(By.id("user-name"));
		WebElement passwordField = driver.findElement(By.id("password"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	@And("I click the login button")
	public void i_click_the_login_button() {
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}

	@Then("I should be redirected to the products page")
	public void i_should_be_redirected_to_the_products_page() {
		wait.until(ExpectedConditions.urlContains("inventory.html"));
		WebElement productsTitle = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.className("title"))
		);
		Assert.assertTrue("Products page title should be displayed", productsTitle.isDisplayed());
		Assert.assertEquals("Products", productsTitle.getText());
	}

	@After
	public void terminateWebDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
