package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class f {
	public static void main(String[] args) {
		Map< String, String> s=new HashMap<String, String>();
		s.put("d", "dd");
		System.out.println(s);
		String t=s.toString();
		System.out.println(t);
	}
//	public static void main(String[] args) throws IOException {
//		File f=new File("./urls.text");
//		File f1=new File("./res.text");
//		if(f1.exists()) {
//			System.out.println("file exist");
//		}
//		else {
//			f1.createNewFile();
//			System.out.println("fiel creaded");
//		}
//		FileOutputStream fos=new FileOutputStream(f1);
//		FileReader fs=new FileReader(f);
//		String s="";
//		int i=0;
//		while(!((i=fs.read())==-1)) {
//			s+=((char)i);
//		}
//		System.out.println(s);
//		s=s.substring(1, s.length()-1);
//		String[] arr = s.split(", ");
//		for (String string : arr) {
//			String s1[]=string.split("=");
//			if(s1[1].contains("F")) {
//				fos.write((s1[0]+="\n").getBytes());
//			}
//		}
//		fos.close();
//		
//		
//	}
	
	
//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.navigate().to("http://siddharthgroup.ac.in/aut1btech2r19mar2023.php?dbn=aut1btech2r19mar2023");
//		driver.findElement(By.xpath("//td//input[@type=\"text\"]")).sendKeys("19F61A0644");
//		driver.findElement(By.xpath("//td//input[@type=\"submit\"]")).click();
//		int l = driver.findElements(By.xpath("//table//tr")).size();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Print')]")));
//		//System.out.println(driver.findElement(By.xpath("")).getText());
//		for(int i=2;i<=l;i++) {
//			String subP = "//tbody/tr["+i+"]/td[2]";
//			String sP="//tbody/tr["+i+"]/td[last()]";
//			
//		String	sub=driver.findElement(By.xpath(subP)).getText();
//		System.out.println(subP+"  "+ sub);
//		String status= driver.findElement(By.xpath(sP)).getText();
//		System.out.println(sP+" "+status);
//		}
//		driver.quit();
//	}
}
