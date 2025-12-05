# WebdriverIO 示例项目

## 环境要求

本地机器需要安装以下工具：
- Node.js（18.0或更高版本）
- Python3（用于 trcli）
- Chrome 浏览器

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/webdriverio

# 安装项目依赖
npm install

# 运行测试
npm test

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "WebdriverIO Automated Test" -f "reports/webdriverio-test.xml"
```

## 可用脚本

| 命令 | 说明 |
|------|------|
| `npm test` | 运行所有测试 |
| `npm run test:headless` | 以无头模式运行测试 |
| `npm run test:spec` | 运行指定的测试文件 |
