package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\Features",
					glue = {"com.grt","com.policybazaar","com.hooksclass"},
					tags= "@grt",
					monochrome = true,
					dryRun = false,
					plugin= {"json:target/report.json","html:target"}
					)
public class TestRunner {
	

}

