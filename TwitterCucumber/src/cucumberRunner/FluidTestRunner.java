package cucumberRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import eventLibrary.webDriverDetails;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue= {"stepsLibrary"},tags="@test")
public class FluidTestRunner{
	
	@BeforeClass
	public static void SetUp() {
	System.out.println("start running the test");	
	
	}
	
	
	
	@AfterClass
	public static void CleanUp() {
		
	webDriverDetails.driver.quit();
		
	}


}
