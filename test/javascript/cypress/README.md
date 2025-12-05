# Cypress 示例项目

## 环境要求

本地机器需要安装以下工具：
- Node.js（18.0或更高版本）
- Python3（用于 trcli）
- Chrome 浏览器

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/cypress

# 安装项目依赖
npm install

# 运行测试（无头模式）
npm test
或者
npx cypress run

# 运行测试（有头模式，可视化）
npm run test:headed

# 打开 Cypress 交互式界面
npm run open

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Cypress Automated Test" -f "reports/*.xml"
```

## 可用脚本

| 命令 | 说明 |
|------|------|
| `npm test` | 以无头模式运行所有测试 |
| `npm run test:headed` | 以有头模式运行测试（可视化） |
| `npm run test:chrome` | 使用 Chrome 浏览器运行测试 |
| `npm run test:firefox` | 使用 Firefox 浏览器运行测试 |
| `npm run open` | 打开 Cypress 交互式界面 |