package automation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestNew {
	
	WebDriver driver;
	Utility class1 = new Utility();
	SoftAssert obj;
		
	
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
	obj= new SoftAssert();
	}
	
	@DataProvider(name="getdata_createaccout")
	public Object[][] CreatAccount(){
	 return new Object[][] {{"","4372602055","Viki.2658","Viki.2658"},
		 {"Vignesh Kumaresan","","Viki.2658","Viki.2658"},
		 {"Vignesh Kumaresan","4372602055","Viki.2658","Viki.2658"},
		 {"Vignesh Kumaresan","427","Viki.2658","Viki.2658"},
		 {"Vignesh Kumaresan","nng","Viki.2658","Viki.2658"},
		 {"Vignesh Kumaresan","4372602055","V658","Viki.2658"},
		 {"Vignesh Kumaresan","4372602055","","Viki.2658"},
		 {"Vignesh Kumaresan","4372602055","Viki.2657","Viki.2658"},
		 {"Vignesh Kumaresan","4372602055","Viki.2658",""},
		 {"","4372602055","Viki.2658","Viki.2658"}
		 };
		 		 
}

	
	@Test(groups="CreateAccount",dataProvider="getdata_createaccout")
	public void TC02to11(String name, String email, String P1,String P2)  {
//	     class1.CickCreatelink();
	    Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"))).build().perform(); 
		driver.findElement(By.linkText("Start here.")).click();
	     driver.findElement(By.name("customerName")).sendKeys(name);
		 driver.findElement(By.name("email")).sendKeys(email);
	     driver.findElement(By.id("ap_password")).sendKeys(P1);
	     driver.findElement(By.id("ap_password_check")).sendKeys(P2);
	     driver.findElement(By.id("continue")).click();
	     boolean result= driver.findElement(By.xpath("//*[@id=\"auth-customerName-missing-alert\"]/div/div")).isDisplayed();
	     System.out.println(result);
}
	
	 
	@Test(groups="CreateAccount")
	public void TC12() { 
		 
		class1.CickCreatelink();
		driver.findElement(By.xpath("//*[@id=\"legalTextRow\"]/a[1]")).click();
		boolean result= driver.findElement(By.id("GUID-6E4B8D4E-A506-4715-9F50-0DA58AA4F448__GUID-2C1DF364-8FA3-4387-BCDB-2A63B7C51B64")).isDisplayed();
		System.out.println(result);
	 }
	 
	@Test(groups="CreateAccount")
	public void TC13()
	 {
		class1.CickCreatelink();
		driver.findElement(By.xpath("//*[@id=\"legalTextRow\"]/a[2]")).click();
		boolean result=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/div/div/a")).isDisplayed();
	    System.out.println(result);
	 }
	 
	@Test(groups="CreateAccount")
	public void TC14()
	 {
		 class1.CickCreatelink();
		 driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/div[9]/a")).click();
		 boolean result=driver.findElement(By.id("ap_email")).isDisplayed();
		 System.out.println(result);
 
	 }	 
	
	@Test(groups="CreateAccount")
	public void TC15()
	 {
		 class1.CickCreatelink();
		 driver.findElement(By.xpath("//*[@id=\"ab-registration-link\"]")).click();
		 boolean result=driver.findElement(By.id("businessEmail-field-id")).isDisplayed();
		 System.out.println(result);
}

	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC16()
		 {
		class1.SignIn();
	    driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
		driver.findElement(By.id("continue")).click();
		boolean result=driver.findElement(By.id("ap_password")).isDisplayed();
		System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC17()
		 {
		class1.SignIn();
		driver.findElement(By.id("ap_email")).sendKeys("");
		driver.findElement(By.id("continue")).click();
	    boolean result=driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).isDisplayed();
		System.out.println(result);
			 
			 
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC18()
		 {
		     class1.SignIn();
			 driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04");
			 driver.findElement(By.id("continue")).click();
			 boolean result=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).isDisplayed();
			 System.out.println(result);
			 
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC19()
		 {
			class1.SignIn();
			driver.findElement(By.id("ap_email")).sendKeys("vigneshkumaresan6@gmail.com");
			driver.findElement(By.id("continue")).click();
			boolean result=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).isDisplayed();
			 System.out.println(result);
			 
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC20()
		 {
			class1.SignIn();	 
			driver.findElement(By.xpath("//*[@id=\"legalTextRow\"]/a[1]")).click();
			 boolean result=driver.findElement(By.xpath("//*[@id=\"GUID-6E4B8D4E-A506-4715-9F50-0DA58AA4F448__GUID-2C1DF364-8FA3-4387-BCDB-2A63B7C51B64\"]")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC21()
		 {
			class1.SignIn();	 
			driver.findElement(By.xpath("//*[@id=\"legalTextRow\"]/a[2]")).click();
			 boolean result=driver.findElement(By.id("GUID-39BF3145-BD72-423B-886C-C01B24F96663__GUID-2C1DF364-8FA3-4387-BCDB-2A63B7C51B64")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC22()
		 {
		class1.SignIn();	 
		driver .findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/div[3]/div/a/span")).click();
			 boolean result= driver.findElement(By.id("auth-fpp-link-bottom")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC23()
		 {
		class1.SignIn();	 
		driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/div[3]/div/a/span")).click();
			 driver.findElement(By.id("auth-fpp-link-bottom")).click();
			 boolean result=driver.findElement(By.id("ap_email")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		public void TC24()
		{
			class1.SignIn();	 
			driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/div[3]/div/a/span")).click();
			driver.findElement(By.id("ap-other-signin-issues-link")).click();
			boolean result = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/h1")).isDisplayed();
			System.out.println(result);
		}
		 
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC25()
		 {
			class1.SignIn();
			driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("ap_password")).sendKeys("Viki@2658");
			 driver.findElement(By.id("signInSubmit")).click();
			 boolean result=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC26()
		 {
		class1.SignIn();	 
		driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("ap_password")).sendKeys("Viki@2338");
			 driver.findElement(By.id("signInSubmit")).click();
			 boolean result=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC27()
		 {
			 
		class1.SignIn();
		driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("signInSubmit")).click();
			 boolean result=driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).isDisplayed();
			 System.out.println(result);
			 
			 
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC28()
		 {
		class1.SignIn();
		driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("ap_password")).sendKeys("Viki@2658");
			 driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/span")).click();
			 driver.findElement(By.id("signInSubmit")).click();
			 driver.close();  
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC29()
		 {
		class1.SignIn();
		driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("ap_change_login_claim")).click();
			 boolean result=driver.findElement(By.id("ap_email")).isDisplayed();
			 System.out.println(result);
			 
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC30()
		 {
			 
		class1.SignIn();
		driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("auth-fpp-link-bottom")).click();
			 boolean result=driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/form/h1")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="AlreadyExistingcustomer")
		 public void TC31()
		 {
		class1.SignIn();
		driver.findElement(By.id("ap_email")).sendKeys("vigneshjayam04@gmail.com");
			 driver.findElement(By.id("continue")).click();
			 driver.findElement(By.id("remember_me_learn_more_link")).click();
			 boolean result=driver.findElement(By.id("a-popover-header-1")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="Your Account")
		 public void TC32()
		 {
		class1.Login();
		Actions action = new Actions(driver);
			 action.moveToElement(driver.findElement(By.xpath("//*[@id=\\\"nav-link-accountList\\\"]/span"))).build().perform();
			 driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[1]/h1")).isDisplayed();
			 System.out.println(result);
			 
		 }
	
	@Test (groups="Your Account")
		 public void TC33()
		 {
		class1.Login();
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 boolean result = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[1]/h1")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="Your Account")
		 public void TC34()
		 
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[2]/div[1]/a/div/div/div/div[2]/h2")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[3]/ul/li[2]/a")).isDisplayed();
			 System.out.println(result);
			 boolean result1= driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[3]/ul/li[3]/a")).isDisplayed();
			 System.out.println(result1);
			 boolean result2= driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[3]/ul/li[4]/a")).isDisplayed();
			 System.out.println(result2);
			  }
		 
	@Test (groups="Your Orders")
	public void TC35()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 boolean result= driver.findElement(By.id("//*[@id=\"nav_prefetch_yourorders\"]/span")).isDisplayed();
			 System.out.println(result);
		 }
		 
	@Test (groups="Your Orders")
		 public void TC36()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("//*[@id=\"nav_prefetch_yourorders\"]/span")).click();
			 driver.findElement(By.id("//*[@id=\"a-page\"]/section/div/div[3]/ul/li[2]/a")).click();
			 
		 }
		 
	
	@Test (groups="Your Orders")
		 public void TC37()
		 {
		class1.Login();
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("//*[@id=\"nav_prefetch_yourorders\"]/span")).click();
			 driver.findElement(By.xpath("//a[text()='Not Yet Shipped']")).click();
			 
		 }
		 
	@Test (groups="Your Orders")
	public void TC38()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("//*[@id=\"nav_prefetch_yourorders\"]/span")).click();
			 driver.findElement(By.xpath("//a[text()='Not Yet Shipped']")).click();
			 
		 }
		 
	@Test (groups="Your Orders")
	public void TC39()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("//*[@id=\"nav_prefetch_yourorders\"]/span")).click();
			 driver.findElement(By.xpath("//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a")).click();
			 
		 }
		 
	@Test (groups="Your Orders")
	public void TC40()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("//*[@id=\"nav_prefetch_yourorders\"]/span")).click();
			 driver.findElement(By.xpath("//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a")).click();
			 
		 }
		 
		 
	@Test (groups="Your Address")
	public void TC41()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 boolean result= driver.findElement(By.id("ya-myab-plus-address-icon")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="Your Address")
		 public void TC42()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")).isDisplayed();
			 System.out.println(result);
		 }
	
	@Test (groups="Your Address")
	public void TC43()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName-full-validation-alerts\"]/div/div/div/div")).isDisplayed();
			 System.out.println(result);
			 
		 }
	
	@Test (groups="Your Address")
		 public void TC44()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber-full-validation-alerts\"]/div/div/div/div")).isDisplayed();
			 System.out.println(result); 
		 }
	
	@Test (groups="Your Address")
		 public void TC45()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("");
			 driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Brampton");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2-full-validation-alerts\"]/div/div/div/div")).isDisplayed();
			 System.out.println(result); 
		 }
		
	
	@Test (groups="Your Address")
	public void TC46()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("new york");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2-full-validation-alerts\"]/div/div/div/div")).isDisplayed();
			 System.out.println(result); 
		 }
		 
	
	@Test (groups="Your Address")
		 public void TC47()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity-full-validation-alerts\"]")).isDisplayed();
			 System.out.println(result); 
		 }
		 
	
	@Test (groups="Your Address")
		 public void TC48()
		 {
			 
		class1.Login();
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("new york");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-full-validation-alerts\"]")).isDisplayed();
			 System.out.println(result); 
		 }
		 
	
	@Test (groups="Your Address")
		 public void TC49()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("56777");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[text()=\"Suggested Address:\"]")).isDisplayed();
			 System.out.println(result); 
		 }
		 
	
	@Test (groups="Your Address")
		 public void TC50()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[text()='Please enter a ZIP or postal code.']")).isDisplayed();
			 System.out.println(result); 
		 }
		 
	
	@Test (groups="Your Address")
		 public void TC51()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-use-as-my-default\"]")).click();
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[@id=\"ya-myab-display-address-block-0\"]//span[contains(text(), 'Default')]")).isDisplayed();
			 System.out.println(result); 
		 }
		 
	@Test (groups="Your Address")
	public void TC52()
		 {
		class1.Login();	 
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
			 driver.findElement(By.id("ya-myab-plus-address-icon")).click();
			 driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vigneshkumaresan");
			 driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4372602055");
			 driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("33 basement");
			 driver .findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("fort williams dr");
			 Select obj= new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span")));
			 obj.selectByVisibleText("Ontario");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-use-as-my-default\"]")).click();
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("L6X 0W4");
			 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
			 boolean result= driver.findElement(By.xpath("//*[text()=\"Address saved\"]")).isDisplayed();
			 System.out.println(result); 
		 }
		 
		
	@Test (groups="LoginAndsecurity")
	public void TC55()
		 {
		    
		class1.Login();
			 driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			 driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/div/span")).click();
		     driver.findElement(By.xpath("//*[contains(text(),'Login & security')]")).click();
		     driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Viki.2658");
		     driver.findElement(By.id("auth-cnep-edit-name-button")).click();
		     driver.findElement(By.xpath("//*[@name = 'customerName']")).sendKeys("Viki");
		     driver.findElement(By.xpath("//*[contains(text(),\"Save changes\")]")).click();
		     Boolean result=driver.findElement(By.xpath("//span[contains(text(),'You successfully changed your account!')]")).isDisplayed();
		     System.out.println(result);
		 }		 
		
	@Test (groups="Searching")
	public void TC65(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("bag");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
	
	@Test (groups="Searching")
	public void TC66(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("red bag");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
	
	@Test (groups="Searching")
	public void TC67(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("tommy");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
	
	@Test (groups="Searching")
	public void TC68(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("B0036QL1JY");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
	
	@Test (groups="Searching")
	public void TC69(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("B0036");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
		
	
	@Test (groups="Searching")
	public void TC70(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("dresses");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
		
	@Test (groups="Searching")
	public void TC71(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	}
	
	@Test (groups="Searching")
	public void TC72(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		String Text = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]//img")).getText();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]")).click();
		String Title = driver.findElement(By.id("productTitle")).getText();
		obj.assertEquals(Text, Title);
		
	}
	 
	@Test (groups="Searching")
	public void TC74(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		driver.findElement(By.xpath("//a[text()=\"Next\"]")).click();	
	} 
	

	
	@Test (groups="Filteration")
	public void TC80(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[text()=\"Brand\"]/../../ul//li//div[1]")).click();
		boolean result = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]")).isDisplayed();
		System.out.println(result); 
	} 
	
	
	@Test (groups="Filteration")
	public void TC81(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[text()=\"Price\"]/../..//ul//a/span[1]")).click();
	} 
	
	@Test (groups="Filteration")
	public void TC82(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[text()=\"Include Out of Stock\"]")).click();
	} 
	
	
	@Test (groups="Sorting")
	public void TC83(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		Select obj=new Select(driver.findElement(By.id("a-autoid-0")));
		obj.selectByVisibleText("Newest srrivals");
	} 
	
	@Test (groups="Sorting")
	public void TC84(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		Select obj=new Select(driver.findElement(By.id("a-autoid-0")));
		obj.selectByVisibleText("avg. cutomer reviews");
		
	} 
	
	@Test (groups="Sorting")
	public void TC85(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		Select obj=new Select(driver.findElement(By.id("a-autoid-0")));
		obj.selectByVisibleText("Price: Low to high");
		
	}
	
	
	@Test (groups="Sorting")
	public void TC86(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		Select obj=new Select(driver.findElement(By.id("a-autoid-0")));
		obj.selectByVisibleText("Price: High to low");
		
	}
	
	@Test (groups="Sorting")
	public void TC87(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
		Select obj=new Select(driver.findElement(By.id("a-autoid-0")));
		obj.selectByVisibleText("Featured");
		
	}
	
	@Test (groups="Shopping cart")
	public void TC90(){
		class1.Login();
		driver.findElement(By.id("nav-cart-count-container")).click();
		Boolean result= driver.findElement(By.xpath("//*[contains(text(),\"Your Amazon Cart is empty.\")]")).isDisplayed();
		System.out.println(result);
	}
	
	
	@Test (groups="Searching")
	public void TC91(){
		class1.Login();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("fast track watches");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);	
	    driver.findElement(By.xpath("//*[@data-uuid='8f3dfdb0-49a3-4ef7-9037-51abdc4aa8ab']")).click();
	    driver.findElement(By.xpath("//span[text()=\"Add to Cart\"]")).click();
	    Boolean result = driver.findElement(By.xpath("//span[contains(text(),\"Added to Cart\")]")).isDisplayed();
	    System.out.println(result);
	}
		
		
	
	
@AfterMethod
	
	public void CloseBrowser()
	{
		driver.close();
	}

}