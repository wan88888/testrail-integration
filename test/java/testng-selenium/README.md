# TestNG 示例项目

## 环境要求

本地机器需要安装以下工具：
- Java（JDK 8 或更高版本）
- Maven
- Python3
- Chrome 浏览器

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/java/testng-selenium

# 编译项目
mvn clean compile

# 运行测试
mvn clean compile test

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "TestNG Selenium Automated Test" -f "reports/junit-report.xml"   
```