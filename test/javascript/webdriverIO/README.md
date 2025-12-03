# WebdriverIO 示例项目

## 如何使用

- 将 `trcli-config.yml` 中的占位符替换为你的 TestRail 实例信息
- 注意：下面脚本中的 `-y` 选项会自动创建所有测试实体

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 安装项目依赖
npm install

# 运行测试
npx wdio run wdio.conf.js

# 上传测试结果到 TestRail
trcli -y -c "trcli-config.yml" parse_junit -f "reports/webdriverio-test.xml"
```