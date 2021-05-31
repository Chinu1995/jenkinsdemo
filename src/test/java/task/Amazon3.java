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

public class Amazon3 {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
			//ChromeOptions option=new ChromeOptions();
			//option.addArguments("user-data-dir=C:\\Users\\chinmaya\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		//	option.addArguments("--disable-notifications");
			
			//driver=new ChromeDriver(option);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com/");
			WebDriverWait wait = new WebDriverWait(driver, 20);
		    WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		    searchBox.click();
		    searchBox.sendKeys("Headphones"+Keys.ENTER);
		    Actions action = new Actions(driver);
		    List<WebElement> bestSellers = driver.findElements(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1]"));
		    for(int i=1;i<=bestSellers.size();i++) {
		        //action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div['"+i+"']")))).build().perform();
		        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div['"+i+"']"))).click();
		    	action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1])[" +i +"]")))).build().perform();
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1])[" +i +"]"))).click();
		    	
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sims-fbt-form\"]/div[2]/fieldset/ul/li[2]/span/span/div/label/input"))).click(); 
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sims-fbt-form\"]/div[2]/fieldset/ul/li[3]/span/span/div/label/input"))).click(); 
		    	
		    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-autoid-17\"]/span/input"))).click(); 
		        //System.err.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Added to Cart')]"))).getText());
		    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'uss-o-close-icon uss-o-close-icon-medium') or contains(@class,'a-link-normal close-button')]"))).click();
		    	// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uss-o-close-icon.uss-o-close-icon-medium"))).click();
		    	
		    	driver.navigate().back();
		        driver.navigate().refresh();
		        driver.navigate().back();
		        driver.navigate().refresh();
		        System.err.println("try to find next best seller item ");
		    }
		   // driver.findElement(By.xpath("//*[@id=\"a-autoid-17\"]/span/input")).click();
			

	}

}
