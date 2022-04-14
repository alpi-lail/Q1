package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"src/test/java/stepdefinition/testAPI.java"},
        plugin = { "pretty", "html:target/testAPIrunner","json:target/testAPIrunner/json"},
        features={"src/test/java/features/testAPI.feature"})

public class testAPIrunner {
}
