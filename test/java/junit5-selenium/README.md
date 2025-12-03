# JUnit5 示例项目

## 环境要求

本地机器需要安装以下工具：
- Java（JDK 8 或更高版本）
- Maven
- Python3
- Chrome 浏览器

## 如何使用

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 编译项目
mvn clean compile

# 运行测试
mvn clean compile test

# 上传测试结果到 TestRail
trcli -y -c "../../trcli-config.yml" parse_junit \
  --title "JUnit5 Selenium Automated Test Run" \
  -f "reports/junit-report.xml"
```
