# Postman TestRail 集成示例项目

## 环境要求

本地机器需要安装以下工具：
- Postman
- Python3

## 如何使用

- 将 `trcli-config.yml` 中的占位符替换为你的 TestRail 实例信息
- 执行以下命令

```sh
# 安装 Newman CLI
npm install -g newman

# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 运行测试
newman run api-test.json -r cli,junit --reporter-junit-export ./reports/newman_junit.xml

# 上传测试结果到 TestRail
trcli -y -c "trcli-config.yml" parse_junit -f "reports/newman_junit.xml"
```