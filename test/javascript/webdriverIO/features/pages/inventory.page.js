import { $ } from '@wdio/globals'
import Page from './page.js';

/**
 * sub page containing specific selectors and methods for a specific page
 */
class InventoryPage extends Page {
    /**
     * define selectors using getter methods
     */
    get inventoryList () {
        return $('.inventory_list');
    }

    get pageTitle () {
        return $('.title');
    }
}

export default new InventoryPage();

