package cucumberSandwitch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import eventLibrary.webDriverDetails;



public class ScrrenshotManager {

	public static String takeScreenshotas(WebDriver driver,String fileName) throws IOException {
		File file=new File(fileName);
		File scrfile=((TakesScreenshot)webDriverDetails.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, file);
		return fileName;
	}

}
