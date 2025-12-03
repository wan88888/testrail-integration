# Cypress 示例项目

## 如何使用

> 注意：下面脚本中的 `-y` 选项会自动创建所有测试实体

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
npm install

# 运行测试
npx cypress run

# 上传测试结果到 TestRail
# TestRail CLI 1.6.0 版本支持通配符路径，可以无缝合并多个报告
trcli -y -c "../../../trcli-config.local.yml" parse_junit \
  --title "Cypress Automated Test Run" \
  -f "reports/*.xml"
```
