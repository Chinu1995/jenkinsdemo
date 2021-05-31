package switches;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Frame1 {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	//implicitly wait
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		driver.findElement(By.linkText("WebDriver")).click();
		driver.switchTo().defaultContent();
		
		//driver.switchTo().frame(driver.findElement(By.name("classFrame")));//by using frame locator
		
		driver.switchTo().frame("classFrame");//using frame name
		driver.findElement(By.linkText("ChromeDriver")).click();
		
		

	}

}
