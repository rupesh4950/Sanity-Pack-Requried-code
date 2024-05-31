package test;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class fireflink  {
	public static void main(String[] args) throws Exception {
		
		//ScreenRecorderUtil.startRecord("test");
		System.out.println("//div[@id=\"demo\" and contains(@class,\" ace_editor ace-tomorrow\")]//textarea[@class=\"ace_text-input\"])[1]");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://webbeta.fireflink.com/");
	//	Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign In')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name=\"emailId\"]")).sendKeys("mekala.r@fireflink.com");//carige5880@royalka.com
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Rupesh@123");//Password@123
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt=\"fireflink-platform\"]"))).click();
		
		
		//switch to window
		Set<String> wind = driver.getWindowHandles(); System.out.println(wind); 
		for(String string : wind) { 
			driver.switchTo().window(string); 
			String url =driver.getCurrentUrl(); 
			if(url.contains("access_token")) {
				System.out.println("switched"); 
				System.out.println(driver.getTitle()); break;
				}
			}
		 Actions a=new Actions(driver);
		 for(int i=0;i<5;i++){
			 a.sendKeys(Keys.ARROW_DOWN).perform();
		 }
		 for(int i=0;i<5;i++){
			 a.sendKeys(Keys.ARROW_UP).perform();
		 }
		
		// getiing all projects
		List<WebElement> pro = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		int i=0;
		for (WebElement ele : pro) {
			a.moveToElement(ele).perform();
			i++;
			
			String text = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]//span/span/span")).getText();
			System.out.println(text);
			if(!text.contains("delete")) {
				
			}
		}
		
		//web services
		/*
		 * driver.findElement(By.xpath("//span[contains(text(),'Webservice do')]")).
		 * click(); WebDriverWait wait =new WebDriverWait(driver,
		 * Duration.ofSeconds(20));
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//button[@title=\"Expand All\"]"))); Thread.sleep(5000);
		 * System.out.println("waiting to click");
		 * driver.findElement(By.xpath("//button[@title=\"Expand All\"]")).click();
		 * System.out.println("clciked");
		 * driver.findElement(By.xpath("//span[contains(text(),'test dev')]")).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//span[contains(text(),'Web Service')]")).click(
		 * ); Thread.sleep(5000);
		 * driver.findElement(By.xpath("//input[@name=\"requestName\"]")).sendKeys(
		 * "testdkkk");
		 * driver.findElement(By.xpath("//input[@name=\"requestUrl\"]")).sendKeys(
		 * "https://reqres.in/api/users?page=2"); driver.findElement(By.
		 * xpath("(//div[@id=\"demo\" and contains(@class,\" ace_editor ace-tomorrow\")]//textarea[@class=\"ace_text-input\"])[1]"
		 * )).sendKeys("testing "); Thread.sleep(5000);
		 * driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
		 * Thread.sleep(5000); String text =
		 * driver.findElement(By.xpath("(//div[@class=\"ace_content\"])[4]")).getText();
		 * System.out.println(text); String
		 * expecd="{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}"
		 * ;
		 * 
		 * System.out.println(text.contains(expecd));
		 * 
		 * // driver.findElement(By.xpath("//h3[text()='My Products']")).click(); //
		 * driver.findElement(By.xpath("//a/img[@alt=\"FireFlink Platform\"]")).click();
		 * //Thread.sleep(10000); // ScreenRecorderUtil.stopRecord();
		 * 
		 * Set<String> wind = driver.getWindowHandles(); System.out.println(wind); for
		 * (String string : wind) { driver.switchTo().window(string); String url =
		 * driver.getCurrentUrl(); if(url.contains("access_token")) {
		 * System.out.println("switched"); System.out.println(driver.getTitle()); break;
		 * } }
		 * 
		 * WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3)); Actions
		 * a=new Actions(driver); for(int i=0;i<5;i++) {
		 * a.sendKeys(Keys.ARROW_DOWN).build().perform(); }
		 */
		//////////////////////////////////////////////////////////
	  
	 /* int l=
	 * driver.findElements(By.xpath("//tbody[@role=\"rowgroup\"]//tr")).size();
	 * System.out.println(l); int j=0; for(int i=1;j<l;j++) { try {
	 * 
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr[1]/td[1]")));
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr[1]/td[1]"))); //
	 * System.out.println("wait completed"); String name =
	 * (driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]//tr["+i+"]/td[1]"))
	 * .getText()); String staus =
	 * (driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]//tr["+i+"]/td[3]"))
	 * .getText()); if(name.contains("delete")) { System.out.println(name
	 * +" skiped"); i++; continue; }
	 * System.out.println("project to delete:  "+name); System.out.println(staus);
	 * if(staus.contains("Open")) { a.moveToElement(driver.findElement(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr["+i+"]"))).perform();
	 * driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]//tr["+i+
	 * "]/td[6]//span[@data-title=\"Edit\"]/button")).click();
	 * driver.findElement(By.xpath("//input[@type=\"checkbox\"]//..//span")).click()
	 * ;
	 * driver.findElement(By.xpath("//button[contains(text(),'Change')]")).click();
	 * driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
	 * waitSuccwsInvs(driver,wait); } int t=20; while(t>0) { try {
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr["+i+"]"))); break; } catch (Exception e) {
	 * Thread.sleep(500); } t--;
	 * 
	 * }
	 * 
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr[1]/td[1]")));
	 * a.moveToElement(driver.findElement(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr["+i+"]"))).perform(); try {
	 * driver.findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+
	 * "]/td[6]//span[@data-title='Delete']")).click(); } catch (Exception e) {
	 * driver.findElement(By.xpath("//tbody[@role='rowgroup']//tr["+i+
	 * "]/td[6]//span[@data-title='Delete']")).click(); }
	 * driver.findElement(By.xpath("//button[text()='Delete']")).click(); t=5;
	 * while(t>0) { try {
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//tbody[@role=\"rowgroup\"]//tr["+i+"]"))); break;
	 * 
	 * } catch (Exception e) { Thread.sleep(500);
	 * 
	 * } t--;
	 * 
	 * } System.out.println("project deleted : "+name); waitSuccwsInvs(driver,wait);
	 * } catch(Exception e){
	 * 
	 * } }
	 */
//	 WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'Rupesh')]"));
//	 a.moveToElement(ele1).build().perform();
//	int l = driver.findElements(By.xpath("//span[contains(text(),'Rupesh')]")).size();
//	
//	for(int i=0;i<l;i++) {
//	WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Rupesh')]"));
//	a.moveToElement(ele).build().perform();
//	String text = driver.findElement(By.xpath("//span[contains(text(),'Rupesh')]//ancestor::tr//td[3]/div")).getText();
//	if(text.contains("Closed")) {
//		driver.findElement(By.xpath("//span[contains(text(),'Rupesh')]//ancestor::tr//td//span[@id=\"del\"]")).click();
//		driver.findElement(By.xpath("//button[text()='Delete']")).click();
//		int t=20;
//		while(t>0) {
//			try {
//				wait.until(ExpectedConditions.elementToBeClickable(ele));
//				break;
//			} catch (Exception e) {
//				Thread.sleep(500);
//			}
//		
//		
//		}
//	}
//	else{
//		driver.findElement(By.xpath(""))
//	}
//	
	
	}

	private static void waitSuccwsInvs(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		int t=20;
		while(t-->0) {
			try {
				driver.findElement(By.xpath("//div[contains(@class,\"alert\")]//span[contains(text(),'Success.')]"));
				System.out.println("identified success"+t);
				Thread.sleep(500);
				
			} catch (Exception e) {
				System.out.println("waiting");
				break;
			}
		}
		
	}
	 
	 
	 
	 
	 
	 
	 
	/* wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
	 * "//tbody//td//span[contains(text(),'DontDelete')]")));
	 * driver.findElement(By.xpath(
	 * "//tbody//td//span[contains(text(),'DontDelete')]")).click();
	 * 
	 * wait.until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//li//span[contains(text(),'Test Data')]")));
	 * driver.findElement(By.xpath("//span[contains(text(),'Test Data')]")).click();
	 * Actions a=new Actions(driver); Thread.sleep(5000);
	 * a.moveToElement(driver.findElement(By.
	 * xpath("//span[@class=\"fancytree-title \"]"))).build().perform();
	 * driver.findElement(By.xpath("//span[contains(text(),'test')]//..//button")).
	 * click(); driver.findElement(By.xpath("//button[text()='Add File']")).click();
	 * System.out.println("clicked on add file"); //
	 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
	 * xpath("//input[@id='file']")))); // driver
	 * driver.findElement(By.xpath("//input[@id='file']")).sendKeys(
	 * "C:\\Users\\User\\Desktop\\rest\\pass.text");
	 */
	}
