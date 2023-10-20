package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Utility {
	WebDriver driver;
	
	@BeforeSuite
	public void Driver() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
//	@BeforeTest
//	public void Browser() {
//		 driver=new ChromeDriver();
//		}
	
	@BeforeMethod
	public void OpenBrowser()
	{ 
    driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.navigate().to("https://www.amazon.ca/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}
	@Test
	
	public void Login() {
	{
		     Actions action = new Actions(driver);
			 action.moveToElement(driver.findElement(By.xpath("*[@id=\"nav-link-accountList-nav-line-1\"]"))).build().perform();
		     driver.findElement(By.xpath("*[@id=\"nav-flyout-ya-signin\"]aspan")).click();
			 driver.findElement(By.id("ap_email")).sendKeys("naganandhiniganesan.aug21@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("ap_password")).sendKeys("907P@ss871");
			 driver.findElement(By.id("signInSubmit")).click();
			 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		}
			
		 }
		
		
		@Test
		public void CickCreatelink()   {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("*[@id=\"nav-link-accountList-nav-line-1\"]"))).build().perform(); 
			driver.findElement(By.linkText("Start here.")).click();
			//driver.manage().timeouts().wait(5000);
		}
		

		@Test
		public void SignIn() {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("*[@id=\"nav-link-accountList-nav-line-1\"]"))).build().perform();
			driver.findElement(By.xpath("span[text()=\"Sign in\"][1]")).click();
		}
	

}
