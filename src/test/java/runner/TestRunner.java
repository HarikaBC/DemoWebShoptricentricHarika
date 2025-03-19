package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    tags="@OrderTest",
    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"},
    //monochrome = true,
    publish=false)

public class TestRunner extends AbstractTestNGCucumberTests {
}

