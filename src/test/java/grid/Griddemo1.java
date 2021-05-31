package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Griddemo1 {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
		String URL = "http://www.google.de";    
        String Node = "http://192.168.1.3:5555/wd/hub";    
        DesiredCapabilities cap = DesiredCapabilities.firefox();   
        driver = new RemoteWebDriver(new URL(Node), cap);
        driver.navigate().to(URL);
        WebElement element = driver.findElement(By.name("q"));
        //Enter something to search for
        element.sendKeys("Cheese!");
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        Thread.sleep(5000);

        driver.quit();    

	}

}
