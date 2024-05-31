package test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class JsonDeleteProject {
	static Scanner sc=new Scanner(System.in);
	static String preProdbaseURL="https://preprodonprem.fireflink.com";
	static String betaURL="https://beta.fireflink.com";
	static String baseURL="https://app.fireflink.com";
	static String userID="USR12991";
	static String betaUserID="USR42052";
	static String brearer="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJNODJhX1U2VHRFSnFvWV9jdzNfWi1KaWVoZ2hQcjJ4QjVMbnlNZ3RtRGs0In0.eyJleHAiOjE3MTcwNDkxNTAsImlhdCI6MTcxNjg3NjM1MCwianRpIjoiZjk2NDJiYTItNWFiZi00MWNkLTkxNTUtZGFiYmNiNDUwYTIyIiwiaXNzIjoiaHR0cHM6Ly9hcHAuZmlyZWZsaW5rLmNvbTozMTAwMS9yZWFsbXMvRmlyZUZsaW5rIiwic3ViIjoiZjphZjhmZmUyYS1jMTIyLTQ3ZjAtOTIxYS01ODgyODcwMjVjZmM6ZmlyZWZsaW5rOUBnbWFpbC5jb20iLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJmbGluay1zZXJ2aWNlIiwic2Vzc2lvbl9zdGF0ZSI6ImY0MWI3MjlhLTliNGMtNDg0Zi1hMzExLWZiZTkyNGI0ZTczNSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiZjQxYjcyOWEtOWI0Yy00ODRmLWEzMTEtZmJlOTI0YjRlNzM1IiwiY3VycmVudExpY2Vuc2VJZCI6IkxJQzE5MDg3IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJjdXJyZW50UHJpdmlsZWdlIjoiQWRtaW4iLCJmdWxsTmFtZSI6IlJhdmFuIiwiYWN0aXZhdGlvblN0YXR1cyI6IkFDVElWRSIsInByaXZpbGVnZSI6IkFkbWluIiwibGljZW5zZU5hbWUiOiJmaXJlLWZsaW5rLUxJQzE5MDg3IiwicHJlZmVycmVkX3VzZXJuYW1lIjoiUmF2YW4iLCJ1c2VyTmFtZSI6ImZpcmVmbGluazlAZ21haWwuY29tIiwiYmlsbGluZ0N5Y2xlIjoiWWVhcmx5IiwiaWQiOiJVU1IxMDY0MDkiLCJsaWNlbnNlSWQiOiJMSUMxOTA4NyIsImVtYWlsIjoiZmlyZWZsaW5rOUBnbWFpbC5jb20ifQ.vqSp1-9tjW1p-O53mk-BZK2L9U-Zc0wK9Rw0DlNyCL3WX8Qqo6AgOU3KItwIRne1-znXWAynVbdEjn-Vci5rXahVJfWRbCT3J1azheP0ulx1DWt5bJ843PVmHolQV8GD1RGCcfVKbtnKzkq20zlUtWgRX2MrMl1B3b6x0cV8j3snGNftH82VIig3NVncNWLwcyGnWF2faZIdaZ9Ai5b-dl6cgS2xsu707YUZASxHCMfW1erQ87kpD1xw02iuTDTyVd-FdJLg_isXSteWekDyQr5s69mddghczWcO0MqO90dj0KdcnlWkUnWf-3Xwrws8ZanLifBH6emqGCzkbotTEw";
	public static void main(String [] args) {
		//for beta
		baseURL=preProdbaseURL;
	//	userID=betaUserID;
		boolean b=true;
		if(b) {
			getBaraerToken("mohammedwasim.a@fireflink.com","@WASIMakhtar06");
			String[] chunks = brearer.split("\\.");
			Base64.Decoder decoder = Base64.getUrlDecoder();
			

			String header = new String(decoder.decode(chunks[0]));
			String payload = new String(decoder.decode(chunks[1]));
			System.out.println(header);
			System.out.println(payload);
			JSONObject jsonObject = new JSONObject(payload);
			System.out.println(jsonObject.get("id"));
			
			return;
		}
		
		String url=baseURL+"/project/optimize/v1/projects/user/"+userID;
		System.out.println("started trying to connect");
		
		Response res = given().auth().oauth2(brearer).get(url);
		System.out.println("connection establisied");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		String val = res.asString();
		System.out.println(res.asString());
//		JSONObject jsonObj = new JSONObject();
//		jsonObj=(JSONObject)res;
//		System.out.println(jsonObj.get("responseCode"));
		Set<String> ids=new LinkedHashSet<String>();
		
		int intialIndex=0;
		for(int i=0;i<val.length();i++) {
			if(intialIndex>val.length()) {
				System.out.println("out of bount");
				break;
			}
			try {
				int valu = val.indexOf("PJT",intialIndex );
				
				if(valu==-1) {
					System.out.println("reached end");
					break;
				}
				intialIndex=valu+1;
			//	System.out.println(valu);
				String id=(String) val.subSequence(valu, valu+7);
//			System.out.println((String) val.subSequence(valu, valu+8));
			System.out.println(id);
				ids.add(id);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println(ids);
		System.out.println(ids.size());
		
		String dontDelete[]="PJT1730,PJT1729,PJT1734,PJT1740,PJT1735,PJT1100,PJT1070,PJT1740".split(",");
		for (String id : dontDelete) {
			boolean deleted = ids.remove(id);
			if(deleted) {
			System.out.println(id+" is removed");
			}
			
		}
		
		Iterator<String> value = ids.iterator(); 
		int count=70;
        while (value.hasNext()) { 
        	if(count-->0) {
        	String id=  (value.next()); 
        	 boolean response=deleteProject(id);
    		 if(!response) {
    			 System.out.println("some error occured with the status of the code");
    			 return;
    		 }}
        	else {
        		break;
        	}
        } 
		//ArrayList< String > idsFinal=(ArrayList<String>) ids;
		
//	for(int i=0;i<idsFinal.size();i++) {
//		String id=idsFinal.get(i);
//		 boolean response=deleteProject(id);
//		 if(!response) {
//			 System.out.println("some error occured with the status of the code");
//			 return;
//		 }
//	}
	}
	private static void getBaraerToken(String userEmail, String Password) {
		String url=baseURL+"/appmanagement/optimize/v1/public/user/signin";
		System.out.println("started trying to connect");
		String body="{\"emailId\":\"%s\",\"password\":\"%s\"}";
		String [ ]vaues={userEmail,Password};
		body=String.format(body, vaues);
		System.out.println(body);
		Response res = given().header("Content-Type","application/json").body(body).post(url);
		
		System.out.println(res.getBody().asString());
		 String val = res.getBody().asString();
		 JSONObject jsonObject = new JSONObject(val);
		 jsonObject = new JSONObject(jsonObject.get("responseObject").toString());
		 System.out.println("=====");
		 System.out.println(jsonObject);
		 System.out.println(jsonObject.get("access_token"));
		 
		 
		System.out.println("connection establisied");
		
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
			
		}
		if(status!=200) {
			System.out.println(status);
			return false;
		}
		System.out.println(id+" project deleted successfully ");
		return true;
	}

}
