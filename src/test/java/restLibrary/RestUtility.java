package restLibrary;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class RestUtility {
	static RequestSpecification reqSpec;
	static String ENDPOINT;
	static ResponseSpecification resSpec;
	
	public  void setEndPoint(String ePoint) {
		ENDPOINT=ePoint;
	}
	public RequestSpecification requestSpecBuild() {
		AuthenticationScheme auth=RestAssured.oauth(AuthConstants.CONSUMER_KEY, AuthConstants.CONSUMER_SECRET, AuthConstants.ACESS_TOKEN, AuthConstants.ACCESS_TOKEN_SECRET);
		RequestSpecBuilder reqBuilder=new RequestSpecBuilder();
		reqBuilder.setBaseUri(PathConstants.BASE_URI);
		reqBuilder.setBasePath(PathConstants.BASE_PATH);
		reqBuilder.setAuth(auth);
		reqSpec=reqBuilder.build().log().all();
		
		return reqSpec;
	}
	
public static RequestSpecification buildQueryParam(RequestSpecification rSpec,String query,String value) {
	    
	    reqSpec=rSpec.queryParam(query, value).log().all();
	    return reqSpec;
		
	}

public ResponseSpecification responseSpecBuild() {
	ResponseSpecBuilder resBuilder=new ResponseSpecBuilder();
	resSpec=resBuilder.expectStatusCode(200).build();
	return resSpec;
}

public Response getResponse(RequestSpecification rspec ,String type) {
	Response response=null;
	rspec.spec(rspec).log().all();
	if(type.equalsIgnoreCase("get")) {
	 response=given().spec(rspec).when().get(ENDPOINT);
	}else if(type.equalsIgnoreCase("post")) {
		 response=given().spec(rspec).when().post(ENDPOINT);
	}else if(type.equalsIgnoreCase("put")) {
			 response=given().spec(rspec).when().put(ENDPOINT);
	} else if(type.equalsIgnoreCase("delete")) {
				 response=given().spec(rspec).when().delete(ENDPOINT);}
	else {
		System.out.println("nothing to be done");
	}
    response.then().spec(resSpec);
	return response;
	
}

public JsonPath getJsonInstance(Response res) {
	String path=res.asString();
	return new JsonPath(path);
}
}
