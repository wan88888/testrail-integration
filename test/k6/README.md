# K6 TestRail 集成示例项目

## 环境要求

```sh
# macOS
brew install k6
```

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/k6

# 运行测试
k6 run jsonplaceholder-test.js
```
## 上传测试结果到 TestRail

```sh
trcli -y -c ~/config.yml parse_junit --title "K6 Performance Test" -f "reports/junit-report.xml"  
```

## 测试用例命名规范

在 `check()` 名称中添加 TestRail Case ID：

```javascript
check(res, {
  'C1 - status is 200': (r) => r.status === 200,
  'C2 - response < 2s': (r) => r.timings.duration < 2000,
});
```