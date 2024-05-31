package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class college {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to("http://siddharthgroup.ac.in/resultpage.html");
		List<WebElement> els = driver.findElements(By.xpath("//td//a"));
		File f=new File("./urls.text");
		if(f.exists()) {
			System.out.println("file exist");
		}
		else {
			try {
				f.createNewFile();
				System.out.println("file created");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//FileInputStream fis=new FileInputStream(f);
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> map=new HashMap<String, String>();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		Actions a=new Actions(driver);
		int co=0;
		for(int j=els.size()-1;j>0;j--) {
			WebElement e=els.get(j);
			jsExecutor.executeScript("arguments[0].style.border='2px solid green'", e);
			try {
				co++;
			String text=e.getText();
			a.moveToElement(e).perform();
			if(text.contains("R19")&& text.contains("B.Tech")&& !(text.contains("Revaluation"))) {
				
				jsExecutor.executeScript("arguments[0].style.border='2px solid green'", e);   
				//System.out.println(e.getText());
				try {
					fos.write((text+="\n").getBytes());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				e.click();
				try {
				driver.findElement(By.xpath("//td//input[@type=\"text\"]")).sendKeys("19F61A0644");
				driver.findElement(By.xpath("//td//input[@type=\"submit\"]")).click();
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Print')]")));
				int l = driver.findElements(By.xpath("//table//tr")).size();
				for(int i=2;i<=l;i++) {
					String subP = "//tbody/tr["+i+"]/td[2]";
					String sP="//tbody/tr["+i+"]/td[last()]";
					
				String	sub=driver.findElement(By.xpath(subP)).getText();
			//	System.out.println(subP+"  "+ sub);
				String status= driver.findElement(By.xpath(sP)).getText();
			//	System.out.println(sP+" "+status);
					map.put(sub,status);
				}
				}
				catch (Exception el) {
					System.out.println(el);
				}
				driver.navigate().back();
				driver.navigate().back();
				Thread.sleep(1000);
			}
			//
			} catch (Exception e2) {
			//	System.out.println(co);
			}
		}
		driver.quit();
		System.out.println(map);
		
	
		System.out.println(map.size());
		check(map.toString());
	}

	private static void check(String s) throws Exception {
		
		int p=0,fa=0;
		File f1=new File("./fail.text");
		File f=new File("./pass.text");
		if(f1.exists()) {
			System.out.println("file exist");
		}
		else {
			f1.createNewFile();
			System.out.println("fiel creaded");
		}
		FileOutputStream fail=new FileOutputStream(f1);
		FileOutputStream pass=new FileOutputStream(f);
	
		s=s.substring(1, s.length()-1);
		String[] arr = s.split(", ");
		for (String string : arr) {
			String s1[]=string.split("=");
			if(s1[1].contains("F")) {
				fail.write((s1[0]+="\n").getBytes());
				fa++;
			}
			else {
				p++;
				pass.write((s1[0]+="\n").getBytes());
			}
		}
		fail.write((fa+"").getBytes());
		pass.write((p+"").getBytes());
		fail.close();
		pass.close();
		
		
	}
}
