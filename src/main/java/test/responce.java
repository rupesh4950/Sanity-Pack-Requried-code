package test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class responce {
	String url1 = "http://www.results.manabadi.co.in/2019/AP/Inter/2nd-year/i2gen2019-ap.aspx";

	// header paraments
	Map<String, Object> head = new HashMap<String, Object>();

	
	Map<String, Object> query = new HashMap<String, Object>();
	
	Response res = given().headers(head).params(query).when().get("https://reqres.in/api/users?page=2");
	
	

}
