package com.Springer.search.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports" }, features = "src/test/resources/Features/"
,glue= {"helpers","Steps"})
public class RunCucumberTest {
}