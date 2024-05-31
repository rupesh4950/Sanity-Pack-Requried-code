package test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getNames {
	public static void main(String[] args) throws Exception {
		
		//ScreenRecorderUtil.startRecord("test");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://webbeta.fireflink.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@name=\"emailId\"]")).sendKeys("mekala.r@fireflink.com");//carige5880@royalka.com
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Rupesh@123");//Password@123
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h3[text()='My Products']")).click();
		driver.findElement(By.xpath("//a/img[@alt=\"FireFlink Platform\"]")).click();
		//Thread.sleep(10000);
//		ScreenRecorderUtil.stopRecord();
	Set<String> wind = driver.getWindowHandles();
	System.out.println(wind);
	for (String string : wind) {
		driver.switchTo().window(string);
		String url = driver.getCurrentUrl();
		if(url.contains("access_token")) {
			System.out.println("switched");
			System.out.println(driver.getTitle());
			break;
		}
	}
	 
	 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
	 Actions a=new Actions(driver);
	 for(int i=0;i<5;i++) {
	 a.sendKeys(Keys.ARROW_DOWN).build().perform();
	 }
	 driver.findElement(By.xpath("//button[text()='+ Project']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@aria-labelledby=\"projecttype\"]")).click();
	List<WebElement> ele = driver.findElements(By.xpath("//div[@id=\"menu-type\"]//div[contains(@class,'MuiPaper-rounded')]//li/span[1]"));
	for (WebElement webElement : ele) {
		System.out.print(webElement.getText()+",");
	}
	}
}
