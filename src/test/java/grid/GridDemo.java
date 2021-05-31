package grid;


import java.net.URL;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridDemo {
	WebDriver driver;
  @Test
  public void test1() throws Exception 
  {
	  
	  String node="http://192.168.1.3:5555/wd/hub";
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
	 // System.setProperty("webdriver.gecko.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\geckodriver.exe");
	  DesiredCapabilities ds=new DesiredCapabilities();
	  ds.setPlatform(Platform.ANY);
	  ds.setBrowserName("chrome");
	  driver=new RemoteWebDriver(new URL(node), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  System.out.println("Title is: "+driver.getTitle());
	  
	  Thread.sleep(5000);

      driver.quit(); 
  }
}
