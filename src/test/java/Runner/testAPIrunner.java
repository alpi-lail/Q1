package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdefinition"},
        plugin = {"pretty", "html:target/cucumber/report.html","json:target/cucumber/report.json"},
        tags = "@GET",
        features = {"src/test/java/features"})

public class testAPIrunner {
}
