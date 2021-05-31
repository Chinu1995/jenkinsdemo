package javaScriptExect;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptexc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='chinmaya'");
		js.executeScript("document.getElementById('pass').value='7894696'");
		
		//title 
		String title = js.executeScript(" return document.title").toString();
		System.out.println(title);
		
		js.executeScript("window.scrollBy(0,500)");
		
		//scroll down to page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		// untill login button visibility
		js.executeScript("document.getElementById(\"u_0_d_OR\").scollIntoView()");
		
		//backward move
		js.executeScript("window.history.back()");
		
		//move forward
		js.executeScript("window.history.forward()");
		//refresh
		js.executeScript("window.history.go(0)");
		
		

	}

}
