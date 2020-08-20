package com.apaoduqs.example.setup;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Cucumber setup. This class configure cucumber to start functional tests.
 * {@link CucumberOptions#features()} is the location of features.
 * {@link CucumberOptions#glue()} is the location of steps.
 *
 * @see CucumberOptions documentation here: https://cucumber.io/docs/cucumber/.
 */
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.apaoduqs.example.steps"},
        format = {"pretty", // Cucumber report formats and location to store them in phone
                "html:target/CucumberReports/cucumber-html-report",
                "json:target/CucumberReports/cucumber.json",
                "junit:target/CucumberReports/cucumber.xml"
        }
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests { }