# WebdriverIO 示例项目

## 如何使用

> 注意：下面脚本中的 `-y` 选项会自动创建所有测试实体

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
npm install

# 运行测试
npx wdio run wdio.conf.js

# 上传测试结果到 TestRail
trcli -y -c "../../../trcli-config.local.yml" parse_junit \
  --title "WebdriverIO Automated Test Run" \
  -f "reports/webdriverio-test.xml"
```
