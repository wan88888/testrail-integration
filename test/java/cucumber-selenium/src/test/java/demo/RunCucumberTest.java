package demo;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/sauce")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "demo")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "junit:reports/junit-report.xml")
public class RunCucumberTest {

}
