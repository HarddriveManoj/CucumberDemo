package com.mgk.tau.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/**
 * The type Westwing now bdd runner.
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.mgk.tau.test",
        features = "src/test/resources",
        monochrome = true,
        dryRun = false,
        tags = {"@SmokeTest"},
        strict = true,
        plugin = {
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class WestwingNowBDDRunner {
}
