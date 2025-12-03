# NUnit 示例项目

## 如何使用

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 还原依赖并编译项目
dotnet restore
dotnet build

# 安装 Playwright 浏览器
cd SauceTest/bin/Debug/net8.0/.playwright
./node/darwin-arm64/node ./package/cli.js install chromium

# 运行测试
cd /Users/wan/Cursor/testrail-integration/test/dotnet/nunit
dotnet test --logger "junit;LogFilePath=$(pwd)/reports/junit-report.xml"

# 上传测试结果到 TestRail
trcli -y -c "../../../trcli-config.local.yml" parse_junit \
  --title "NUnit Playwright Automated Test Run" \
  -f "reports/junit-report.xml"
```
