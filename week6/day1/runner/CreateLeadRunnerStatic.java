package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/FN002_CreateLeadStatic.feature"},
 glue={"steps"},
 publish = true,
 dryRun = false)

public class CreateLeadRunnerStatic extends AbstractTestNGCucumberTests{

}