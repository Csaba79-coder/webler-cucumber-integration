package hu.webler.weblercucumberintegration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"hu.webler.weblercucumberintegration.cucumberglue"}
)
public class CucumberTestRunnerCase {

}
