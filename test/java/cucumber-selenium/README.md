# Cucumber Selenium 示例项目

## 环境要求

本地机器需要安装以下工具：
- Java（JDK8或更高版本）
- Maven
- Python3
- Chrome

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/java/cucumber-selenium

# 编译项目
mvn clean compile

# 运行测试
mvn clean compile test

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Cucumber Selenium Automated Test" -f "reports/junit-report.xml"
```