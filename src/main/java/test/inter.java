package test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class inter {
	static Map <String ,String> v=new HashMap<String, String>();
	public static void main1(String[] args) {
		
		

		// header paraments
		Map<String, Object> head = new HashMap<String, Object>();

		
		Map<String, Object> query = new HashMap<String, Object>();
		
		Response res = given().headers(head).params(query).when().get("https://reqres.in/api/users?page=2");
		System.out.println(res.toString());
		System.out.println(res.getStatusCode());
		String t1=(res.getBody().asString());
		String t2="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
		System.out.println(t1.contains(t2));
		System.out.println(t1.equals(t2));
		
		String s1="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces /7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\" :\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\" :\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\" :\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image .jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}\r\n"
				+ "";
		String s2="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces /7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\" :\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\" :\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\" :\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image .jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
		//System.out.println(s1.equals(s2));
		System.out.println(s1.contains(s2));
	}
	public static void main(String[] args) {
		String firstName="LEBAKU",secndName="LAVANYA";/// fill the search names here 
		
		String rol1 = "190922";// fill roll number here
		//check(rol, firstName,secndName );
		for(int k=7;k<=9;k++) {
			String rol=rol1+k;
		
		String test = "";
		for (int i = 1; i < 1000; i++) {
			if (i >= 100) {
				test = rol + i;
			} else if (i >= 10) {
				test = rol + ("0" + i);
			} else {
				test = rol + ("00" + i);
			}
			System.out.println(test);
			check(test,firstName,secndName);
			
		}
		}
		
	//	System.out.println(v);

	}

	private static void check(String roll,String name1,String name2) {
		try {
			String url1 = "http://www.results.manabadi.co.in/2019/AP/Inter/2nd-year/i2gen2019-ap.aspx";

			// header paraments
			Map<String, Object> head = new HashMap<String, Object>();

			head.put("Host", "results.manabadi.co.in"); // 895
			head.put("Referer",
					"http://www.results.manabadi.co.in/2019/AP/Inter/2nd-year/AP-Intermediate-2nd-year-regular-exam-result-April-2019.htm");
			Map<String, Object> query = new HashMap<String, Object>();
			query.put("htno", roll);
			Response res = given().headers(head).params(query).when().get(url1);
			
		//	System.out.println(res.asString());
			String s=res.asString();
			if(s.contains(name1)|| s.contains(name2)) {
				System.out.println("===============================================");
				System.out.println(roll);
				System.out.println(s);
				write(s,roll);
				System.out.println("===============================================");
			}
			
			/*
			 * String resu = res.asString().replaceAll("", "*"); System.out.println(resu);
			 * String[] map = resu.split("*"); for (String string : map) {
			 * System.out.print(string+" "); }
			 * 
			 * System.out.println("name is " + map[3]+" roll "+roll); if
			 * ((map[3].toLowerCase()).contains(name1)||(map[3].toLowerCase()).contains(
			 * name2)) { System.out.println(
			 * "**********************************************************************************"
			 * ); System.out.println("name is " + map[3] + "  roll number is " + roll);
			 * v.put(map[3], roll); System.out.println(true); System.out.println(
			 * "**********************************************************************************"
			 * ); }
			 */

		} catch (Exception e) {
			System.err.println("roll number not exist"+" : "+ roll);
		}

	}

	private static void write(String s, String roll) throws Exception {
		File f=new File("./inter.text");
		if(f.exists()) {
			System.out.println("file exist");
		}
		else {
			f.createNewFile();
			System.out.println("fiel creaded");
		}
		String e="===================================================";
		FileOutputStream pass=new FileOutputStream(f,true);
		pass.write((e+="\n").getBytes());
		pass.write((roll+="\n").getBytes());
		pass.write((s+="\n").getBytes());
		pass.write((e+="\n").getBytes());
		
	}

}
