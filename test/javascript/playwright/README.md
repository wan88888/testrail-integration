# Playwright 示例项目

## 环境要求

本地机器需要安装以下工具：
- Node.js（18.0或更高版本）
- Python3（用于 trcli）

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/playwright

# 安装项目依赖（会自动安装 Playwright 浏览器）
npm install

# 运行测试
npm test

# 运行测试（有头模式）
npm run test:headed

# 打开 Playwright UI 界面
npm run test:ui

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Playwright Automated Test" -f "reports/junit-report.xml"
```

## 可用脚本

| 命令 | 说明 |
|------|------|
| `npm test` | 运行所有测试 |
| `npm run test:headed` | 以有头模式运行测试（可视化） |
| `npm run test:debug` | 以调试模式运行测试 |
| `npm run test:ui` | 打开 Playwright UI 交互界面 |