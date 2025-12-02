// @ts-check
const { test, expect } = require('@playwright/test');
const { randomUUID } = require('crypto');

test.beforeEach(async ({ page }) => {
  await page.goto('https://www.saucedemo.com');
});

test.afterEach(async ({ page }, testInfo) => {
  if (testInfo.status !== testInfo.expectedStatus) {
    let screenshotPath = `reports/screenshots/screenshot-${randomUUID()}.png`;
    await page.screenshot({ path: screenshotPath, fullPage: true });
    testInfo.annotations.push({ type: 'testrail_attachment', description: screenshotPath });
    testInfo.annotations.push({ type: 'testrail_result_comment', description: "Login test failed - see screenshot for details." });
  }
});

// Standard test credentials for SauceDemo
const VALID_USER = {
  username: 'standard_user',
  password: 'secret_sauce'
};

test.describe('SauceDemo Login', () => {
  test('should login successfully with valid credentials', async ({ page }, testInfo) => {
    // Test case properties
    testInfo.annotations.push({ type: 'testrail_case_field', description: "refs:TR-100" });
    testInfo.annotations.push({ type: 'testrail_case_field', description: "priority_id:1" });

    // Step 1: Verify login page is displayed
    testInfo.annotations.push({ type: 'testrail_result_comment', description: "1. Verify login page is displayed" });
    await expect(page.locator('#user-name')).toBeVisible();

    // Step 2: Enter username
    testInfo.annotations.push({ type: 'testrail_result_comment', description: "2. Enter valid username" });
    await page.locator('#user-name').fill(VALID_USER.username);

    // Step 3: Enter password
    testInfo.annotations.push({ type: 'testrail_result_comment', description: "3. Enter valid password" });
    await page.locator('#password').fill(VALID_USER.password);

    // Step 4: Click login button
    testInfo.annotations.push({ type: 'testrail_result_comment', description: "4. Click login button" });
    await page.locator('#login-button').click();

    // Step 5: Verify successful login - user should be redirected to inventory page
    testInfo.annotations.push({ type: 'testrail_result_comment', description: "5. Verify successful login - redirected to inventory page" });
    await expect(page).toHaveURL(/.*inventory.html/);
    await expect(page.locator('.title')).toHaveText('Products');
  });
});