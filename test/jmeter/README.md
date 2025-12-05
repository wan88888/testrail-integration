# JMeter TestRail 集成示例项目

## 环境要求

本地机器需要安装以下工具：
- JMeter
- JUnit Reporter
- Python3

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/jmeter

# 运行测试
jmeter -n -t test.jmx

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "JMeter Performance Test" -f "reports/junit-results.xml"
```