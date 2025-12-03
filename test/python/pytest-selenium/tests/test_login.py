from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webdriver import WebDriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class TestLogin:
    """Test cases for SauceDemo login functionality"""

    @staticmethod
    def test_login_with_standard_user(browser_driver: WebDriver, record_property):
        """
        Test successful login with standard_user credentials
        """
        record_property("testrail_result_comment", "1. Enter username: standard_user")
        username_input = browser_driver.find_element(By.ID, "user-name")
        username_input.send_keys("standard_user")

        record_property("testrail_result_comment", "2. Enter password: secret_sauce")
        password_input = browser_driver.find_element(By.ID, "password")
        password_input.send_keys("secret_sauce")

        record_property("testrail_result_comment", "3. Click login button")
        login_button = browser_driver.find_element(By.ID, "login-button")
        login_button.click()

        record_property("testrail_result_comment", "4. Verify redirect to inventory page")
        WebDriverWait(browser_driver, 10).until(
            EC.url_contains("/inventory.html")
        )
        assert "/inventory.html" in browser_driver.current_url

        record_property("testrail_result_comment", "5. Verify products title is displayed")
        products_title = browser_driver.find_element(By.CLASS_NAME, "title")
        assert products_title.text == "Products"

    @staticmethod
    def test_login_page_elements(browser_driver: WebDriver, record_property):
        """
        Test login page displays all required elements
        """
        record_property("testrail_result_comment", "1. Verify username input is displayed")
        username_input = browser_driver.find_element(By.ID, "user-name")
        assert username_input.is_displayed()

        record_property("testrail_result_comment", "2. Verify password input is displayed")
        password_input = browser_driver.find_element(By.ID, "password")
        assert password_input.is_displayed()

        record_property("testrail_result_comment", "3. Verify login button is displayed")
        login_button = browser_driver.find_element(By.ID, "login-button")
        assert login_button.is_displayed()

        record_property("testrail_result_comment", "4. Verify login logo is displayed")
        logo = browser_driver.find_element(By.CLASS_NAME, "login_logo")
        assert logo.is_displayed()
        assert logo.text == "Swag Labs"

    @staticmethod
    def test_inventory_items_after_login(browser_driver: WebDriver, record_property):
        """
        Test that inventory items are displayed after successful login
        """
        record_property("testrail_result_comment", "1. Login with standard_user")
        browser_driver.find_element(By.ID, "user-name").send_keys("standard_user")
        browser_driver.find_element(By.ID, "password").send_keys("secret_sauce")
        browser_driver.find_element(By.ID, "login-button").click()

        record_property("testrail_result_comment", "2. Wait for inventory page to load")
        WebDriverWait(browser_driver, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, "inventory_list"))
        )

        record_property("testrail_result_comment", "3. Verify inventory items are displayed")
        inventory_items = browser_driver.find_elements(By.CLASS_NAME, "inventory_item")
        assert len(inventory_items) > 0

        record_property("testrail_result_comment", "4. Verify at least 6 products are available")
        assert len(inventory_items) == 6

