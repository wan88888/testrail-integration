import { Given, When, Then } from '@wdio/cucumber-framework';
import { expect, $ } from '@wdio/globals'

import LoginPage from '../pages/login.page.js';
import InventoryPage from '../pages/inventory.page.js';

const pages = {
    login: LoginPage
}

Given(/^I am on the (\w+) page$/, async (page) => {
    await pages[page].open()
});

When(/^I login with (\w+) and (.+)$/, async (username, password) => {
    await LoginPage.login(username, password)
});

Then(/^I should be on the inventory page$/, async () => {
    await expect(InventoryPage.inventoryList).toBeExisting();
    await expect(InventoryPage.pageTitle).toHaveText('Products');
});

Then(/^I should see an error message saying (.*)$/, async (message) => {
    await expect(LoginPage.errorMessage).toBeExisting();
    await expect(LoginPage.errorMessage).toHaveText(expect.stringContaining(message));
});

