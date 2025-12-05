# Cucumber Selenium 示例项目

## 环境要求

本地机器需要安装以下工具：
- Java（JDK 11 或更高版本）
- Maven
- Python3（用于 trcli）
- Chrome 浏览器

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/java

# 运行 Cucumber 测试
mvn clean test -pl cucumber-selenium

# 运行所有 Java 子项目测试
mvn clean test
```

## 上传测试结果到 TestRail

```sh
cd cucumber-selenium
trcli -y -c ~/config.yml parse_junit --title "Cucumber Selenium Automated Test" -f "reports/junit-report.xml"
```