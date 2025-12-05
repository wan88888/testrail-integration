# Postman TestRail 集成示例项目

## 环境要求

本地机器需要安装以下工具：
- Postman
- Python3

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/javascript/postman

# 安装 Newman CLI
npm install -g newman

# 运行测试
newman run api-test.json -r cli,junit --reporter-junit-export ./reports/newman_junit.xml

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Postman Automated Test" -f "reports/newman_junit.xml"  
```