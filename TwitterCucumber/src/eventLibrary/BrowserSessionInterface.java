package eventLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public interface BrowserSessionInterface {
	
	
	
	public WebDriver openBrowser(String browser);
	public void enterURL(String url);
	public void userClickOnLink(String link);

	public void userClickOnButton(String buttonText);
	public void userEnterTheTexbox(String id, String text);
	public void takeScreenshot(WebDriver driver, String string);
	
}
