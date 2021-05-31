package grid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
  @Test
  public void test1() throws Exception {
	  System.out.println("Started Test1");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
	  DesiredCapabilities ds = new DesiredCapabilities();
	  ds.setPlatform(Platform.ANY);
	  ds.setBrowserName("chrome");
	  
	 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.3:5555/wd/hub"), ds);
	 driver.manage().window().maximize();
	 driver.get("https://www.amazon.in");
	 System.out.println("Title is : " + driver.getTitle());
	 
	 Thread.sleep(7000);
	 driver.quit();
	 System.out.println("Ended Test1");
  }
  @Test
  public void test2() throws Exception {
	  System.out.println("Started Test2");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
	  DesiredCapabilities ds = new DesiredCapabilities();
	  ds.setPlatform(Platform.ANY);
	  ds.setBrowserName("chrome");
	  
	 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.3:5555/wd/hub"), ds);
	 driver.manage().window().maximize();
	 driver.get("https://www.amazon.in");
	 System.out.println("Title is : " + driver.getTitle());
	 
	 Thread.sleep(7000);
	 driver.quit();
	 System.out.println("Ended Test2");
  }
  @Test
  public void test3() throws Exception {
	  System.out.println("Started Test3");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
	  DesiredCapabilities ds = new DesiredCapabilities();
	  ds.setPlatform(Platform.ANY);
	  ds.setBrowserName("chrome");
	  
	 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.3:5555/wd/hub"), ds);
	 driver.manage().window().maximize();
	 driver.get("https://www.amazon.in");
	 System.out.println("Title is : " + driver.getTitle());
	 
	 Thread.sleep(7000);
	 driver.quit();
	 System.out.println("Ended Test3");
  }
  @Test
  public void test4() throws Exception {
	  System.out.println("Started Test4");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
	  DesiredCapabilities ds = new DesiredCapabilities();
	  ds.setPlatform(Platform.ANY);
	  ds.setBrowserName("chrome");
	  
	 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.3:5555/wd/hub"), ds);
	 driver.manage().window().maximize();
	 driver.get("https://www.amazon.in");
	 System.out.println("Title is : " + driver.getTitle());
	 
	 Thread.sleep(7000);
	 driver.quit();
	 System.out.println("Ended Test4");
  }
}
