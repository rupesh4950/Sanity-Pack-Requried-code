package test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class ssc {
	static Map <String ,String> v=new HashMap<String, String>();
	public static void main(String[] args) {
		String firstName="",secndName="";/// fill the search names here 
		
		String rol = "1718106";// fill roll number here
		String test = "";
		for (int i = 1; i < 2; i++) {
			if (i >= 100) {
				test = rol + i;
//				System.out.println(test);
			} else if (i >= 10) {

				test = rol + ("0" + i);
				//System.out.println(test);
			} else {
				test = rol + ("00" + i);
			//	System.out.println(test);
			}
			check(test, firstName,secndName );
		}
		System.out.println(v);

	}

	private static void check(String roll,String name1,String name2) {
		try {
			String url1 = "http://results.manabadi.co.in/2017/andhra-pradesh/SSC/AP-SSC2017.aspx";

			// header paraments
			Map<String, Object> head = new HashMap<String, Object>();

			head.put("Host", "results.manabadi.co.in"); // 895
			head.put("Referer",
					"http://results.manabadi.co.in/2017/andhra-pradesh/SSC/Andhra-pradesh-ssc-10th-class-results-2017-0305.htm");
			Map<String, Object> query = new HashMap<String, Object>();
			query.put("htno", roll);
			Response res = given().headers(head).params(query).when().get(url1);
			System.out.println(res.asString());
			String resu = res.asString().replaceAll("|", "*");
			System.out.println(resu);
			String[] map = resu.split("*");
			for (String string : map) {
				System.out.print(string+" ");
			}

//			System.out.println("name is " + map[3]+" roll "+roll);
//			if ((map[3].toLowerCase()).contains(name1)||(map[3].toLowerCase()).contains(name2)) {
//				System.out.println("**********************************************************************************");
//				System.out.println("name is " + map[3] + "  roll number is " + roll);
//				v.put(map[3], roll);
//				System.out.println(true);
//				System.out.println("**********************************************************************************");
//			}

		} catch (Exception e) {
			System.err.println("roll number not exist"+" : "+ roll);
		}

	}

}
