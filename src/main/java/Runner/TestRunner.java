package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/main/java/Features", //the path of the feature files
			glue={"StepDefinitions"}, //the path of the step definition files
			plugin = { "pretty", "html:reports/cucumber.html" },
			monochrome = false)
	 
	public class TestRunner {
	 
	}
 