package eventLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class commonMethods implements BrowserSessionInterface{

public static Logger logger=Logger.getLogger(commonMethods.class.getName());
jqueryRunner jqRunner=new jqueryRunner();
webDriverDetails details=new webDriverDetails();	
	
	public void enterURL(String url) {
	try {
		webDriverDetails.driver.get(url);
	    logger.info("URL is entered");
		
	}catch(Exception e) {
	  logger.error("user is not able to enter URL");	
	}

}
	public void userClickOnLink(String link) {
		
		
		
	}
	public void userEnterTheTexbox(final String id,final String text) {
		StringBuilder arg1=new StringBuilder();
		arg1.append("$('input");
		arg1.append("#");
		arg1.append(id);
		arg1.append("')");
		arg1.append(".val");
		arg1.append("('");
		arg1.append(text);
		arg1.append("')");
		String arg=arg1.toString();
		this.jqRunner.executeJquery(arg);
		
	}
	public void userClickOnButton(String buttonText) {
		StringBuilder arg1=new StringBuilder();
		arg1.append("$('a')");
		arg1.append(".filter(function() {");
		arg1.append("return ($.trim(");
		arg1.append("$(this).text()) == '");
		arg1.append(buttonText);
		arg1.append("')"); 
		arg1.append("})");
		arg1.append(".click()");
		String arg=arg1.toString();
		this.jqRunner.executeJquery(arg);
	}
public WebDriver openBrowser(String browser) {
		// TODO Auto-generated method stub
		return null;
	}
	public void takeScreenshot(WebDriver driver, String string) {
		// TODO Auto-generated method stub
		
	}
	public Boolean userVerifyState(String Text) {
		StringBuilder arg1=new StringBuilder();
		arg1.append("$('a')");
		arg1.append(".filter(function() {");
		arg1.append("return ($.trim(");
		arg1.append("$(this).text()) == '");
		arg1.append(Text);
		arg1.append("')"); 
		arg1.append("})");
		arg1.append(".is(\":visible\")");
		String arg=arg1.toString();
		Boolean res=this.jqRunner.executeJqueryReturn(arg);
		return res;
	}
	
	}	
	


	
