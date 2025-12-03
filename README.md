# TestRail 集成示例项目

本仓库包含多种测试框架与 [TestRail](https://www.testrail.com/) 集成的示例项目，展示如何使用 [TestRail CLI (trcli)](https://github.com/gurock/trcli) 将自动化测试结果上传到 TestRail。

## 项目结构

```
test/
├── python/                     # Python 测试框架
│   └── pytest-selenium/        # Pytest + Selenium
│
├── javascript/                 # JavaScript 测试框架
│   ├── playwright/             # Playwright
│   ├── cypress/                # Cypress
│   ├── webdriverio/            # WebdriverIO
│   └── postman/                # Postman/Newman API 测试
│
├── java/                       # Java 测试框架
│   ├── junit5-selenium/        # JUnit5 + Selenium
│   ├── testng-selenium/        # TestNG + Selenium
│   └── cucumber-selenium/      # Cucumber + Selenium
│
├── dotnet/                     # .NET 测试框架
│   └── nunit/                  # NUnit + Playwright
│
├── robotframework/             # Robot Framework
│   └── robotframework-selenium/
│
├── jmeter/                     # JMeter 性能测试
│
└── k6/                         # K6 性能测试
```

## 快速开始

### 1. 安装 TestRail CLI

所有示例项目都需要先安装 TestRail CLI：

```sh
pip install pipx
pipx install trcli
```

### 2. 配置 TestRail 连接

每个子项目都包含一个 `trcli-config.yml` 配置文件，需要将其中的占位符替换为你的 TestRail 实例信息：

```yaml
host: https://your-instance.testrail.io
username: your-email@example.com
key: your-api-key
project: Your Project Name
```

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

无论使用哪种测试框架，基本工作流都是：

```sh
# 1. 运行测试并生成 JUnit XML 报告
<运行测试的命令>

# 2. 使用 trcli 上传结果到 TestRail
trcli -y -c "trcli-config.yml" parse_junit -f "reports/junit-report.xml"
```

## 相关资源

- [TestRail CLI 官方文档](https://support.testrail.com/hc/en-us/articles/7146548750868-Introduction-to-the-TestRail-CLI)
- [TestRail API 文档](https://support.testrail.com/hc/en-us/articles/7077039051284-Accessing-the-TestRail-API)