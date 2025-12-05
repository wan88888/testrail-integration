# Cypress 示例项目

## 如何使用

> 注意：下面脚本中的 `-y` 选项会自动创建所有测试实体

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/cypress

# 安装项目依赖
npm install

# 运行测试
npx cypress run

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Cypress Automated Test" -f "reports/*.xml"   
```