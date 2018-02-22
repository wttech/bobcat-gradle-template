package @packageName@;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/features/example", format = {"pretty",
    "html:target/cucumber-wikipedia-html-report", "json:target/cucumber-wikipedia-report.json"})
public class RunWikipediaTest {
  // empty
}
