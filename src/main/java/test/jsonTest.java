package test;


import org.json.JSONObject;

import static io.restassured.RestAssured.given;

import java.util.Scanner;

import org.json.JSONArray;  
import com.google.gson.JsonObject;

import io.restassured.response.Response;

public class jsonTest {
	
	static Scanner sc=new Scanner(System.in);
	static String PreprodURL="https://preprodonprem.fireflink.com";
	static String baseURL="https://app.fireflink.com";
	static String betaURL="https://beta.fireflink.com";
	static String userID="USR107813";
	static String betaUserID="USR42040";
	static String brearer="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJHNnRfdWRTSS00UVNaZFRpaDNRMnE3Q1NvU3U5U2cyNDZ0dW5RQUdJNHdRIn0.eyJleHAiOjE3MTUyNjQyNjgsImlhdCI6MTcxNTI2MjQ2OCwianRpIjoiN2Y1NGRlYTUtZTdhMS00ZGQwLTllNTMtMWU1NDljZDEzOWI0IiwiaXNzIjoiaHR0cDovLzg1LjE5NS43NS4yMjE6MzEwMDAvcmVhbG1zL0ZpcmVGbGluayIsInN1YiI6ImY6NzYzZTNlMzQtYWQ2YS00OWZhLTlmODMtYWY1MDk3NTY5NjA1Om1la2FsYS5yQGZpcmVmbGluay5jb20iLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJmbGluay1zZXJ2aWNlIiwic2Vzc2lvbl9zdGF0ZSI6ImViMGYxNjg4LTIwYmEtNDMwMi04Njk2LWEyYWUzNDg0MDBmZCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwic2lkIjoiZWIwZjE2ODgtMjBiYS00MzAyLTg2OTYtYTJhZTM0ODQwMGZkIiwiY3VycmVudExpY2Vuc2VJZCI6IkxJQzUyODciLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImN1cnJlbnRQcml2aWxlZ2UiOiJBZG1pbiIsImZ1bGxOYW1lIjoiTWVrYWxhIiwiYWN0aXZhdGlvblN0YXR1cyI6IkFDVElWRSIsInByaXZpbGVnZSI6IkFkbWluIiwibGljZW5zZU5hbWUiOiJmaXJlLWZsaW5rLUxJQzUyODciLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJNZWthbGEiLCJ1c2VyTmFtZSI6Im1la2FsYS5yQGZpcmVmbGluay5jb20iLCJiaWxsaW5nQ3ljbGUiOiJZZWFybHkiLCJpZCI6IlVTUjQyMDUyIiwibGljZW5zZUlkIjoiTElDNTI4NyIsImVtYWlsIjoibWVrYWxhLnJAZmlyZWZsaW5rLmNvbSJ9.FhzDu2nmz3H0lgyKKh6qenA11mgLx2weWuxvJy-aU9y1HCC6oR8bL819YYze5Spna-LPbVacwVTAftWx9NgtEB5jb-43GKIvTPAo3zqsYTax_zImj4EqTz6Ar4vPct-b2GvBgcJ0tbmRiPTzMUPWECIEUZxK185ttG00dd4mnkt8fvon0ORs3J8QgaCnqoVgNNC2mPUblYNDRGGr3UWkA4dcTdfEQqYtyk-yPgNWM647Cm6KdiLjmGqMr2k5lST_NqepkC_Ve0i7zWnm20OipA75BwPUtZRfXInsRokHIZnaElQC-mvEnPqtuC4pmZYfjDzdGEtyGv2x-sAgGcvppA";
	public static void main(String[] args) {
		
		baseURL=betaURL;
		userID=betaUserID;
		boolean deleteProject=true;
		
		String url=baseURL+"/project/optimize/v1/projects/user/"+userID;
		System.out.println("started trying to connect");
		Response res = given().auth().oauth2(brearer).get(url);
		System.out.println("connection establisied");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		String val = res.asString();
		System.out.println(res.asString());
		int c=1;
		JSONObject obj = new JSONObject(val);  
		JSONArray arr=(JSONArray) obj.get("responseObject");
		System.out.println(arr.length()+" is the total number of projects");
		System.out.println(arr);
		System.out.println("=============");
		
		if(!deleteProject)
			return;
		for(int i=0;i<arr.length();i++) {
			JSONObject in=(JSONObject) arr.get(i);
			JSONObject project = (JSONObject) in.get("project");
			String name=project.getString("name");
			System.out.println(c+++" "+name);
			String id=(String) project.get("id");
			System.out.println(id);
			deleteProject(id);
		}
//		 
		 
	}
private static boolean deleteProject(String id) {
		
		String url=baseURL+"/project/optimize/v1/projects/%s";
		String updatedURL = String.format(url, id);
		//System.out.println(updatedURL);
		///delete the projects
		Response res = given().auth().oauth2(brearer).delete(updatedURL);
		int status = res.getStatusCode();
		System.out.println(status);
		if(status==401) {
			System.out.println("its unauthorized error \n update the beartor token ");
			brearer=sc.nextLine();
			deleteProject(id);
			return true;
		}
		if(status!=200) {
			System.out.println(status);
			return false;
		}
		System.out.println(id+" project deleted successfully ");
		return true;
	}
}
