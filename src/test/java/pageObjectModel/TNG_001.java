package pageObjectModel;

import org.testng.annotations.Test;

import com.project.April6PMMavenSelenium.BasePage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TNG_001 extends BasePage{
	//WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod() 
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			   driver.manage().window().maximize();
			   //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	//implicitly wait
	  }
  @Test(enabled = false)
  public void f() throws Exception
  {
	  LoginPage login=new LoginPage(driver);
	  login.CustomerLogin();
	  Assert.assertEquals(login.verifyLogin(), "Authentication failed.");
	  
	  
	 // driver.findElement(By.linkText("Sign in")).click();
	  //driver.findElement(By.id("email")).sendKeys("qabfggffg@gmail.com");
	  //driver.findElement(By.id("passwd")).sendKeys("password");
	  //driver.findElement(By.id("SubmitLogin")).click();
	 //String actualError = driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
 // String expectedError = "Authentication failed.";
  //Assert.assertEquals(actualError, expectedError);
  
  }
  
  @Test
  public void custRegistration() throws Exception
  {
	   CustomerRegistration cr = new CustomerRegistration(driver);
	   cr.customerRegistration();
  }
  @AfterMethod
  public void afterMethod() {
  }

}
