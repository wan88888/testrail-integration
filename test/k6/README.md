# K6 TestRail 集成示例项目

## 环境要求

```sh
# macOS
brew install k6
```

## 如何使用

```sh
# 安装 TestRail CLI
pip install pipx
pipx install trcli

# 运行测试
k6 run jsonplaceholder-test.js
```

> 测试完成后会自动生成 `reports/junit-report.xml`

## 上传测试结果到 TestRail

```sh
trcli -y -c "../trcli-config.yml" parse_junit \
  --title "K6 Performance Test Run" \
  -f "reports/junit-report.xml"
```

## 测试用例命名规范

在 `check()` 名称中添加 TestRail Case ID：

```javascript
check(res, {
  'C123 - status is 200': (r) => r.status === 200,
  'C124 - response < 2s': (r) => r.timings.duration < 2000,
});
```

TRCLI 会自动将结果映射到 TestRail 中对应的 Case。
