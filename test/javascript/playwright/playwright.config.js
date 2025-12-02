// @ts-check
const { devices } = require('@playwright/test');

const testRailOptions = {
  // Whether to add <properties> with all annotations;
  embedAnnotationsAsProperties: true,
  // Where to put the report.
  outputFile: './reports/junit-report.xml'
};

const config = {
  testDir: './tests',
  /* Maximum time one test can run for. */
  timeout: 15 * 1000,
  expect: {
    /**
     * Maximum time expect() should wait for the condition to be met.
     * For example in `await expect(locator).toHaveText();`
     */
    timeout: 5000
  },
  /* Run tests in files in parallel */
  fullyParallel: true,
  /* Fail the build on CI if you accidentally left test.only in the source code. */
  forbidOnly: !!process.env.CI,
  /* Retry on CI only */
  retries: process.env.CI ? 2 : 0,
  /* Opt out of parallel tests on CI. */
  workers: process.env.CI ? 1 : undefined,
  reporter: [
    ['list'],
    ['html', { outputFolder: 'reports', open: 'never' }],
    ['junit', testRailOptions]
  ],
  use: {
    actionTimeout: 0,
    trace: 'on-first-retry',
  },

  outputDir: 'reports/',
};

module.exports = config;