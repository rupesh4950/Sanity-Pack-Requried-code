package test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;

import org.json.JSONObject;

public class deleteProjects {
	//https://app.fireflink.com
	static String baseURL;
	static String prodBaseURL="https://app.fireflink.com";
	static String onpremBaseURl="https://preprodonprem.fireflink.com";
	static String betaBaseURL="https://beta.fireflink.com";
	static String testBaseURL="http://test.fireflink.com/";
	static String testBaseURL1="http://testbackend.fireflink.com";
	static String cstOnPremBaseURL="https://cstonprem.fireflink.com";
	///////email and passwords
	static String prProdONprememail="mohammedwasim.a@fireflink.com";
	static String preProdONrempassword="@WASIMakhtar06";
	static String betaUserEmail="fireflink9@gmail.com";
	static String betaPassword="Password@123";
	/////////////////////////////////////////////////
	static String email="";
	static String password="";
	// change the userID barrer token and the base url before trigering 
	static String userID="";
	static String brearer="";
	public static void main(String[] args) {
		////chandge before executon
		baseURL=betaBaseURL;
		email=betaUserEmail;
		password=betaPassword;
		// to update the barear token and  user id
		getBaraerToken(email,password);
		getID();
		System.out.println(brearer);
		// access contol
			boolean deleteProject=true;
			boolean basedONDate=false;
		//project/optimize/v1/projects/user/USR12990
		//provide you want comment and give manual date and time
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal=Calendar.getInstance();
		int toDayDate=Integer.parseInt(dateFormat.format(cal.getTime()));// date
		dateFormat = new SimpleDateFormat("HH");
		int timeTODelete=Integer.parseInt(dateFormat.format(cal.getTime()));;// time
	//	toDayDate=31;
		//timeTODelete=17;
		
		System.out.println("/////////////////");
		
		int nameIndex=7;
		String idOfProject=null;
		// this is regresion 
		/////////////////////project/optimize/v1/projects/user/USR12990
		String url=baseURL+"/project/optimize/v1/projects/user/"+userID;//USR104569
	//	String url="http://testbackend.fireflink.com/project/optimize/v1/projects/user/USR42067";
		System.out.println("URL : "+ url);
		
		Response res = given().auth().oauth2(brearer).get(url);
		System.out.println("status code "+res.getStatusCode());
		System.out.println("response time "+res.getTime());
		System.out.println("/////total obj");
		System.out.println(res.asString());
		System.out.println("/////total obj end");
		String s=res.asString();
	System.out.println(s.split("responseObject")[1]);
	String[] t = s.split("responseObject")[1].split("\"project\"");
	System.out.println(t.length);
	int deletedCount=0;
	for(int i=0;i<t.length;i++) {
		String keyVal[]=t[i].split(",");
		String createdON = null;
		boolean deleteCheck=false;
		// to get the values
		boolean namePrint=true;
		System.out.println("/////////////////");
		for(int j=0;j<keyVal.length;j++) {
		//	System.out.println(keyVal[j]);
			// to get the name
			if(namePrint&&keyVal[j].contains("name")) {
				System.out.println(keyVal[j]);
				try {
				String name=keyVal[nameIndex].split(":")[1];
				name=name.substring(1, name.length()-1);
				System.out.print(" name  "+name+" ");
				}
				catch(Exception e){
					System.out.println("name issue");
					continue;
				}
				namePrint=false;
			}
			if(keyVal[j].contains("PJT")) {
				String id=keyVal[j].split(":")[1];
				id=id.substring(1, id.length()-1);
				System.out.print(" id  "+id+" ");
				idOfProject=id;
			}
			//created on 
			if(keyVal[j].contains("createdOn")) {
				String d=keyVal[j].split(":")[1];
				d=d.substring(1, d.length());
				System.out.print(" created ON  "+d);
				createdON=d;
				deleteCheck=true;
				
			}
			
		}
		System.out.println();
		
		if(deleteCheck) {
			int time= Integer.parseInt(createdON.split(" ")[1]);
			int date=Integer.parseInt(createdON.split(" ")[0].split("-")[0]);
			boolean toDel=false;
			if(basedONDate) {
						 toDel=false;
			if(date==toDayDate && time<timeTODelete) {
				toDel=true;
				System.out.println("delete project this is created on today at "+ time);
			}
			else if(date<=toDayDate-1 ) {
				toDel=true;
				System.out.println("delete project this is crared on Yesterday");
			}
			else {
				System.out.println("project no need ot delete");
			}
			}
			else {
				//System.out.println("project will be deleted completly not based on the date");
			}
			if(deleteProject&&((basedONDate&&toDel)||(!basedONDate))) {
				deletedCount++;
					boolean returnVal = deleteProject(idOfProject);
					if(!returnVal) {
						//System.out.println("server is down termenating the execution ");
						return;
					}
				System.out.println(deletedCount +"  is deleted as of now");
			}
			else {
				break;
			}
			System.out.println("/////////////////");
		}
		
	}		
	
	}

	private static String getID() {
		String[] chunks = brearer.split("\\.");
		Base64.Decoder decoder = Base64.getUrlDecoder();
		

	//	String header = new String(decoder.decode(chunks[0]));
		String payload = new String(decoder.decode(chunks[1]));
		JSONObject jsonObject = new JSONObject(payload);
		String id=(String) jsonObject.get("id");
		System.out.println("user id is "+id);
		userID=id;
		return id;
		
	}

	private static boolean deleteProject(String id) {
//		String dontDelete="PJT1730,PJT1729,PJT1734,PJT1740,PJT1735,PJT1100,PJT1070,PJT1740,PJT1952,PJT1938,PJT1735,PJT1703,PJT1999,PJT1697,PJT2001,PJT2000,PJT1998,PJT1997,PJT1740,PJT1070,PJT1100,PJT1735,PJT1740,PJT1734,PJT1729,PJT1730,PJT2008,PJT2009,PJT2019,PJT2016,PJT2011,PJT2022,PJT2020,PJT2018,PJT2015,PJT2003,PJT1730,PJT1707,PJT1994,PJT1990,PJT1983,PJT1994,PJT2023,PJT2015,PROJ290524,PJT1496,PJT1447,PJT1477,PJT1936,PJT1937,PJT1488,PJT1712,PJT1584,PJT2024,PJT2025,PJT2029,PJT2026,PJT2028,PJT2030,PJT1449,PJT1487,PJT1941,PJT1441";
//		if(dontDelete.contains(id.strip())) {
//			System.out.println("==============================================================");
//			System.out.println("its contains in the project id inside the dont delete list "+ id); 
//			System.out.println("==============================================================");
//			return true;
//		}
		
		String url=baseURL+"/project/optimize/v1/projects/%s";
		String updatedURL = String.format(url, id);
		//System.out.println(updatedURL);
		///delete the projects
		Response res = given().auth().oauth2(brearer).delete(updatedURL);
		int status = res.getStatusCode();
		double resvalue=res.getTime();
		double time=resvalue/1000;
		System.out.println(time+"  secs taken to delete actual is "+resvalue);
		
		if(status!=200) {
			System.out.println(status);
			if(status==504) {
				System.out.println("time out exception termenating the execution trying to get the barer again ");
			
			}
			boolean b=getBaraerToken(email,password);
			if(b) {
				deleteProject(id);
			}
			else {
				return false;
			}
			return true;
		}
		//System.out.println(res.asString());
		return true;
	}
	private static boolean getBaraerToken(String userEmail, String Password) {
		String url=baseURL+"/appmanagement/optimize/v1/public/user/signin";
		System.out.println("started trying to connect");
		String body="{\"emailId\":\"%s\",\"password\":\"%s\"}";
		String [ ]vaues={userEmail,Password};
		body=String.format(body, vaues);
		System.out.println(body);
		try {
			Response res = given().header("Content-Type","application/json").body(body).post(url);
			
			System.out.println(res.getBody().asString());
			 String val = res.getBody().asString();
			 JSONObject jsonObject = new JSONObject(val);
			 jsonObject = new JSONObject(jsonObject.get("responseObject").toString());
			 //System.out.println("=====");
			 //System.out.println(jsonObject);
			// System.out.println(jsonObject.get("access_token"));
			 brearer=(String) jsonObject.get("access_token");
			 System.out.println("barear token saved successfully");
			 return true;
		} catch (Exception e) {
			System.out.println("failed in sigin");
			return false;
		}
			 
		
		
	}
}
