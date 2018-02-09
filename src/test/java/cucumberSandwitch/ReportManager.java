package cucumberSandwitch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import eventLibrary.webDriverDetails;

public class ReportManager {
	String fileName="screenshot.png";
	String dir="C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\repo\\";
	ExtentReports report;
	ExtentTest test;
	ScrrenshotManager screenshot;
	
	String imagePath;
	public ReportManager() {
		 report=new ExtentReports("C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\repo\\report.html");  
		 test=report.startTest("start reporting");
		
	}
	
   public void PassReporting(String testCase,String fileName,WebDriver driver) throws IOException {
	 test.log(LogStatus.PASS, testCase + ":step Passed");
	 report.endTest(test);
	 imagePath=test.addScreenCapture(takeScreenshot(webDriverDetails.driver, fileName));
	// ScrrenshotManager.takeScreenshot(webDriverDetails.driver, dir+fileName);
	
}
  public void ErrorReporting(String testCase,String fileName,WebDriver driver) throws IOException {
	
	 test.log(LogStatus.FAIL, testCase + "step failed");
	 report.endTest(test);
	 imagePath=test.addScreenCapture(takeScreenshot(webDriverDetails.driver, fileName));
	// ScrrenshotManager.takeScreenshot(webDriverDetails.driver, dir+fileName);
	
	 
}
 public void clean() {
	report.flush();
	report.close();
}

 public  String takeScreenshot(WebDriver driver,String fileName) throws IOException {
		File file=new File(fileName);
		File scrfile=((TakesScreenshot)webDriverDetails.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, file);
		return fileName;
	}
 
}
