package fr.altran.testCucumber.testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"fr.altran.testCucumber.stepDefinitions"},
		format = {"pretty", "html:target/reports/cucumber/html"}
		)



public class Runner  {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

}
