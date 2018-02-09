package cucumberRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import eventLibrary.webDriverDetails;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features",dryRun=false,glue= {"stepsLibrary"},tags="@Gaurav",monochrome=true,format = {"html:C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\repo\\","json:C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\repo\\cucumber.json"})
public class FluidTestRunner{
	
	@BeforeClass
	public static void SetUp() {
	System.out.println("start running the test");	
	
	}
	
	
	
	@AfterClass
	public static void CleanUp() {
		
	
		
	}


}
