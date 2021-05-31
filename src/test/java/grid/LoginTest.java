package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
  @Test(priority = 1)
  public void setUp() throws Exception 
  {
	  String nodeURL="http://192.168.1.3:5555/wd/hub";
	  DesiredCapabilities ds= DesiredCapabilities.chrome();
	  
	  ds.setBrowserName("chrome");
	  ds.setPlatform(Platform.ANY);
	  
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
	  driver=new RemoteWebDriver(new URL(nodeURL), ds);
	  //driver=new ChromeDriver();
	  
  }
  @Test(priority = 2)
  public void login() 
  {
	  driver.get("http://practice.automationtesting.in/my-account/");
	  driver.findElement(By.id("username")).sendKeys("pavanoltraining");
	  driver.findElement(By.id("password")).sendKeys("Test@selenium123");
	  driver.findElement(By.name("login")).click();;
	 String captext = driver.findElement(By.xpath("//strong[contains(text(),'pavanoltraining')]")).getText();
  System.out.println(captext);
  }
  @Test(priority = 3)
  public void f() {
  }
}
