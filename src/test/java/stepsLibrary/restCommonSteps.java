package stepsLibrary;

import java.util.Map;

import FixtureFactory.FixtureManger;
import cucumber.api.java.en.Given;
import cucumberSandwitch.ReportManager;
import eventLibrary.BrowserSessionInterface;
import eventLibrary.commonMethods;
import eventLibrary.webDriverDetails;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restLibrary.EndPointsConstant;
import restLibrary.RestUtility;

public class restCommonSteps {
	BrowserSessionInterface session=new commonMethods();
	ReportManager report=new ReportManager();


	String fileName="screenshot.png";
	String dir="C:\\Users\\Richa\\Documents\\APPIUM SOFTWARES\\repo\\";
	String idText="";
	String Text="";
	public static  String rowKey;
	FixtureManger fixture =new FixtureManger();

	
	@Given("^user \"(.*?)\" \"(.*?)\" as \"(.*?)\" in twitter$")
	public void user_tweets_the_twitter_as_status(String type,String query,String value) throws Throwable {
		try {
	
		RestUtility session=new RestUtility();
	    RequestSpecification rspec=session.requestSpecBuild();
	    session.setEndPoint(EndPointsConstant.STATUSES_TWEET_POST);
	    RestUtility.buildQueryParam(rspec,query,value);
	    session.responseSpecBuild();
	    Response res= session.getResponse(rspec, type);
	    JsonPath jpath=session.getJsonInstance(res);
	    idText=jpath.get("id_str");
	    }
		catch(Exception e) {
		e.printStackTrace();
		
		}
	}
		@Given("^user \"(.*?)\" status in twitter$")
		public void user_read_tweets_in_twitter(String type) throws Throwable {
			try {
		
			RestUtility session=new RestUtility();
		    RequestSpecification rspec=session.requestSpecBuild();
		    session.setEndPoint(EndPointsConstant.STATUSES_USER_TIMELINE);
		    RestUtility.buildQueryParam(rspec,"id",idText);
		    session.responseSpecBuild();
		    Response res=  session.getResponse(rspec, type);
		    JsonPath jpath=session.getJsonInstance(res);
		    Text=jpath.get("text");
		    System.out.println(idText);
		    }
			catch(Exception e) {
			e.printStackTrace();
			
			}

	}
	

}
