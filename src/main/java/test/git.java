package test;

import static io.restassured.RestAssured.*;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import io.restassured.response.Response;

public class git {
	public static void main(String []args) {
//		for(int i=0;i<100;i++) {
//		 given().when().get("https://profile-counter.glitch.me/kavi1304/count.svg");
//		System.out.println(i);
//		}
		NumberFormat f = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(""+f.format(7777777.9));
		f = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println(""+f.format(77777.9));
		
		
	}
}
