# Robot Framework 示例项目

## 如何使用

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
pip install -r requirements.txt

# 运行测试
robot -d reports "./tests"

# 上传测试结果到 TestRail
trcli -y -c "../../../trcli-config.local.yml" parse_robot \
  --title "Robot Framework Automated Test Run" \
  -f "reports/output.xml"
```
