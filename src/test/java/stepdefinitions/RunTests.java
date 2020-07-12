package stepdefinitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 

@RunWith(Cucumber.class) 
@CucumberOptions(glue= {"stepdefinitions"} , tags = {"@MobileWeb"} , features = {"src/test/resources/featurefiles"}, plugin = {"json:target/cucumber-report-composite.json", "pretty", "html:target/cucumber/","rerun:target/rerun.txt"}) 

public class RunTests {
}
