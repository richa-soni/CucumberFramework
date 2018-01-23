package stepsLibrary;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import FixtureFactory.FixtureManger;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberSandwitch.ReportManager;
import cucumberSandwitch.ScrrenshotManager;
import eventLibrary.BrowserSessionInterface;
import eventLibrary.commonMethods;
import eventLibrary.webDriverDetails;

public class commonSteps {

BrowserSessionInterface session=new commonMethods();
ReportManager report=new ReportManager();


String fileName="screenshot.png";
String dir="C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\repo\\";

public static  String rowKey;
FixtureManger fixture =new FixtureManger();

@Before(order=0)
 public static String SetUp(cucumber.api.Scenario scenario) {
	String tagFine = null;
   
    for(String tag : scenario.getSourceTagNames()){
        System.out.print("Tag: " + tag);
        if(tag.contains("Test_id")) {
        	rowKey=tag.substring(8, tag.length());
       
        }
    }
	return tagFine;
 }

@After
public void cleanup() {
	report.clean();
}




	@Given("^user opens the \"(.*?)\" browser$")
	public void user_opens_the_browser(String arg1) throws Throwable {
		try {
	
		BrowserSessionInterface session=new webDriverDetails();
	    session.openBrowser(this.fixture.fileRead(arg1));
	    report.PassReporting("user opens the browser",dir+fileName, webDriverDetails.driver);
	    
	    }
		catch(Exception e) {
		
		report.ErrorReporting("user could not open the browser",dir+fileName, webDriverDetails.driver);	
		}


	}
	
	
	@When("^user loads fixture file \"(.*?)\"$")
	public void user_loads_fixture_file(String arg1) throws Throwable {
		try {
			
		fixture.fileLoad(arg1);
		
		}
		catch(Exception e) {
			
			
			}
	
	}

	@When("^user enters the URL \"(.*?)\"$")
	public void user_enters_the_URL_url(String URL) throws Throwable {
	   try {
		
		   this.session.enterURL(this.fixture.fileRead(URL));
		   report.PassReporting("user enters the URL", dir+fileName, webDriverDetails.driver);
		   this.session.takeScreenshot(webDriverDetails.driver, dir+fileName);
	   }catch(Exception e) {
		   report.ErrorReporting("user could not enter the URL",dir+fileName, webDriverDetails.driver);
	   }
	}
	
	@When("^user enters the \"(.*?)\" in the textbox \"(.*?)\"$")
	public void user_enters_the_in_the_textbox(String text, String id) throws Throwable {
		try {
	    this.session.userEnterTheTexbox((this.fixture.fileRead(id)), this.fixture.fileRead(text));
	    report.PassReporting("user enters the URL", dir+fileName, webDriverDetails.driver);
	    this.session.takeScreenshot(webDriverDetails.driver, dir+fileName);
		}
		catch(Exception e) {
			report.ErrorReporting("user could not enter text box",dir+fileName, webDriverDetails.driver);
		}
	}
	

	@When("^user click on the link \"(.*?)\"$")
	public void user_click_on_the_link(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	

	@When("^user click on the button \"(.*?)\"$")
	public void user_click_on_the_button(String arg1) throws Throwable {
		try {
		    this.session.userClickOnButton(this.fixture.fileRead(arg1));
		    report.PassReporting("user click on the button", dir+fileName, webDriverDetails.driver);
		    this.session.takeScreenshot(webDriverDetails.driver, dir+fileName);
			}
			catch(Exception e) {
			report.ErrorReporting("user could not click on the button",dir+fileName, webDriverDetails.driver);
			}
	}
	 
}
