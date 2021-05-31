package task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon2 {
	WebDriver driver;
  @Test
  public void login() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
		//ChromeOptions option=new ChromeOptions();
		//option.addArguments("user-data-dir=C:\\Users\\chinmaya\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
	//	option.addArguments("--disable-notifications");
		
		//driver=new ChromeDriver(option);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).
		  click();
		  driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("chin"
		  ); driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(
		  "prustychinmya294@gmail.com");
		  driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("7894696");
		  driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys(
		  "7894696"); driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		  driver.close();
		
		 
		 
		
  }
}
