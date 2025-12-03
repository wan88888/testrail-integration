# TestRail 集成示例项目

本仓库包含多种测试框架与 [TestRail](https://www.testrail.com/) 集成的示例项目，展示如何使用 [TestRail CLI (trcli)](https://github.com/gurock/trcli) 将自动化测试结果上传到 TestRail。

## 项目结构

```
testrail-integration/
├── trcli-config.example.yml    # TestRail CLI 配置文件模板
├── trcli-config.yml            # 本地配置文件（需创建，已被 gitignore）
├── scripts/
│   ├── collect-reports.sh      # 收集所有子项目报告到根目录
│   └── upload-reports.sh       # 批量上传所有报告到 TestRail
├── reports/                    # 收集后的报告目录（按项目分类）
└── test/
    ├── python/                 # Python 测试框架
    │   └── pytest-selenium/    # Pytest + Selenium
    │
    ├── javascript/             # JavaScript 测试框架
    │   ├── playwright/         # Playwright
    │   ├── cypress/            # Cypress
    │   ├── webdriverio/        # WebdriverIO
    │   └── postman/            # Postman/Newman API 测试
    │
    ├── java/                   # Java 测试框架
    │   ├── junit5-selenium/    # JUnit5 + Selenium
    │   ├── testng-selenium/    # TestNG + Selenium
    │   └── cucumber-selenium/  # Cucumber + Selenium
    │
    ├── dotnet/                 # .NET 测试框架
    │   └── nunit/              # NUnit + Playwright
    │
    ├── robotframework/         # Robot Framework
    │   └── robotframework-selenium/
    │
    ├── jmeter/                 # JMeter 性能测试
    │
    └── k6/                     # K6 性能测试
```

## 快速开始

### 1. 安装 TestRail CLI

所有示例项目都需要先安装 TestRail CLI：

```sh
pip install pipx
pipx install trcli
```

### 2. 配置 TestRail 连接

1. 复制配置文件模板：

```sh
cp trcli-config.example.yml trcli-config.yml
```

2. 编辑 `trcli-config.yml`，填写你的 TestRail 实例信息：

```yaml
host: https://your-instance.testrail.io
project: Your Project Name
username: your-email@example.com
password: your-password-or-api-key
```

> **提示**：`password` 可以使用密码或 API Key（在 TestRail 中通过 "My Settings" > "API Keys" 获取）
> 
> **安全**：`trcli-config.yml` 已被 `.gitignore` 忽略，不会提交到版本控制

### 3. 选择示例项目

根据你使用的测试框架，进入对应的子目录查看详细说明：

| 测试框架 | 目录 | 说明 |
|---------|------|------|
| **Pytest** | [test/python/pytest-selenium](test/python/pytest-selenium) | Python Selenium 测试 |
| **Playwright** | [test/javascript/playwright](test/javascript/playwright) | 现代化 E2E 测试框架 |
| **Cypress** | [test/javascript/cypress](test/javascript/cypress) | Cypress测试框架 |
| **WebdriverIO** | [test/javascript/webdriverio](test/javascript/webdriverio) | WebdriverIO测试框架 |
| **Postman** | [test/javascript/postman](test/javascript/postman) | API 测试集成 |
| **JUnit5** | [test/java/junit5-selenium](test/java/junit5-selenium) | Java Selenium 测试 |
| **TestNG** | [test/java/testng-selenium](test/java/testng-selenium) | Java Selenium 测试 |
| **Cucumber** | [test/java/cucumber-selenium](test/java/cucumber-selenium) | BDD 风格测试 |
| **NUnit** | [test/dotnet/nunit](test/dotnet/nunit) | .NET Playwright 测试 |
| **Robot Framework** | [test/robotframework/robotframework-selenium](test/robotframework/robotframework-selenium) | 关键字驱动测试 |
| **JMeter** | [test/jmeter](test/jmeter) | 性能测试集成 |
| **K6** | [test/k6](test/k6) | 现代化性能测试 |

## 通用工作流

### 上传测试报告（推荐）

使用 `-c` 参数指定配置文件的绝对路径，可以在**任意子项目目录**下执行上传命令，无需在每个子项目中复制配置文件：

```sh
# 在任意子项目目录下执行（例如在 test/java/junit5-selenium 目录）
trcli -y -c "/path/to/testrail-integration/trcli-config.yml" parse_junit \
  --title "JUnit5 Test Run" \
  -f "reports/junit-report.xml"
```

**示例**：

```sh
# 在 playwright 子项目中上传报告
cd test/javascript/playwright
trcli -y -c "/Users/wan/Cursor/testrail-integration/trcli-config.yml" parse_junit \
  --title "Playwright Tests" \
  -f "reports/junit-report.xml"

# 在 pytest 子项目中上传报告
cd test/python/pytest-selenium
trcli -y -c "/Users/wan/Cursor/testrail-integration/trcli-config.yml" parse_junit \
  --title "Pytest Tests" \
  -f "reports/junit-report.xml"
```

> **优势**：只需维护根目录下的一份 `trcli-config.yml` 配置文件，所有子项目共享使用

## 相关资源

- [TestRail CLI 官方文档](https://support.testrail.com/hc/en-us/articles/7146548750868-Introduction-to-the-TestRail-CLI)
- [TestRail API 文档](https://support.testrail.com/hc/en-us/articles/7077039051284-Accessing-the-TestRail-API)
