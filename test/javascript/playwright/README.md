# Playwright 示例项目

## 如何使用

```sh
# 安装 TestRail CLI
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/playwright

# 安装项目依赖
npm install

# 运行测试
npx playwright test

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Playwright Automated Test" -f "reports/junit-report.xml"   
```