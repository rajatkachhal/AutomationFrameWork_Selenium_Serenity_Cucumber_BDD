package com.propertyfinder.practicetest;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        format = {"pretty", "html:target/html_report"},
        features = "src/test/resources/features",
        glue = "com.propertyfinder.practicetest")
public class Runner {
}
