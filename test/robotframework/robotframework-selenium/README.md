# Robot Framework 示例项目

## 如何使用

- 将 `trcli-config.yml` 中的占位符替换为你的 TestRail 实例信息
- 执行以下命令

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
pip install -r requirements.txt

# 运行测试
robot -d reports "./tests"

# 上传测试结果到 TestRail
trcli -y -c "trcli-config.yml" parse_robot -f "reports/output.xml"
```