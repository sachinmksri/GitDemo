package com.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/features",glue={"com.StepDefinations"},
tags={"@DeletePlace"},plugin={"json:target/jsonReports/cucumber_report.json"})
public class TestRunner {

}
