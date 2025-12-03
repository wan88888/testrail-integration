# Playwright 示例项目

## 如何使用

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
npm install

# 运行测试
npx playwright test

# 上传测试结果到 TestRail
trcli -y -c "../../../trcli-config.local.yml" parse_junit \
  --title "Playwright Automated Test Run" \
  -f "reports/junit-report.xml"
```
