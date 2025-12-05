# WebdriverIO 示例项目

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/webdriverio

# 安装项目依赖
npm install

# 运行测试
npx wdio run wdio.conf.js

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "WebdriverIO Automated Test" -f "reports/webdriverio-test.xml"   
```