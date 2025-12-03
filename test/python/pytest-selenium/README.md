# Pytest 示例项目

## 如何使用

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
pip install -r requirements.txt

# 运行测试
pytest --junitxml "reports/junit-report.xml" "./tests"

# 上传测试结果到 TestRail
trcli -y -c "../../trcli-config.yml" parse_junit \
  --title "Pytest Automated Test Run" \
  -f "reports/junit-report.xml"
```
