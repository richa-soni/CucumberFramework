package eventLibrary;

import org.openqa.selenium.JavascriptExecutor;


public class jqueryRunner  {
	
	public void executeJquery(String arg) {
		JavascriptExecutor js=(JavascriptExecutor)webDriverDetails.driver;
		js.executeScript(arg);
	
	}

}
