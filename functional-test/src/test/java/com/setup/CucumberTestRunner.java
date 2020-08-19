package com.setup;

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
        glue = {"com.steps"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests { }