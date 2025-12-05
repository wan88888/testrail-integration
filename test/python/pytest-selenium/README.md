# Pytest 示例项目

## 如何使用

```sh
git clone https://github.com/wan88888/testrail-integration.git
cd test/python/pytest-selenium

# 安装项目依赖
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt

# 运行测试
pytest --junitxml "reports/junit-report.xml" "./tests"

# 上传测试结果到 TestRail
trcli -y -c ~/config.yml parse_junit --title "Pytest Automated Test" -f "reports/junit-report.xml"  
```