package eventLibrary;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class webDriverDetails implements BrowserSessionInterface {
	public static WebDriver driver;
	public String CHROME_DRIVER_LOCATION="C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\chromedriver_win32\\chromedriver.exe";
	
	
	public WebDriver openBrowser(String browserType) {
		if(browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_LOCATION);
				driver =new ChromeDriver();	
				driver.manage().window().maximize();
				
			}
		return driver;
			
		}


	@Override
	public void enterURL(String url) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void userClickOnLink(String link) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void userClickOnButton(String buttonText) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void userEnterTheTexbox(String id, String text) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void takeScreenshot(WebDriver driver, String string) {
		// TODO Auto-generated method stub
		
	}


	
	
	

	
	


}
