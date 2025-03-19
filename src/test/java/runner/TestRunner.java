package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    plugin = {"pretty","json:target/cucumber-reports-json/Cucumber.json"},
    monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
