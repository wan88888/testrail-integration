# NUnit SauceDemo Login Test Project

## How to use the project

- Replace the placeholders in `trcli-config.yml` with your TestRail instance details
- Execute the commands on the script below

```sh
# Install TR CLI
pip install trcli

# Install test project
dotnet restore
dotnet build

# Install Playwright browsers
pwsh SauceTest/bin/Debug/net8.0/playwright.ps1 install
# Or use: npx playwright install

# Run tests
dotnet test --logger "junit;LogFilePath=$(pwd)/reports/junit-report.xml"

# Upload test results
trcli -y -c "trcli-config.yml" parse_junit -f "reports/junit-report.xml"
```