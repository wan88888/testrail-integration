# K6 TestRail Integration
TestRail Integration With [K6](https://k6.io/)

## 安装依赖

```sh
# macOS
brew install k6

# 或其他系统参考: https://k6.io/docs/get-started/installation/
```

## 执行测试

```sh
k6 run jsonplaceholder-test.js
```

> 测试完成后会自动生成 `reports/junit-report.xml`

## 上传结果到 TestRail

```sh
trcli -y -c "trcli-config.yml" parse_junit -f "reports/junit-report.xml" --case-matcher "name"
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
