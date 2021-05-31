package com.project.April6PMMavenSelenium;



public class Tc_003 extends BasePage {
	
	
	public static void main(String[] args) throws Exception {
		init();
		
		
		launch("chromebrowser","amazonurl");
		
		
		windowMaximize();
		
		
		selectOption("amazondropdown_id","Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("The girl in room 105");
		//typeText("field-keywords","The girl in room 105");//name locator
		//typeText("amazonsearchtextbox_id","The girl in room 105");//id locator
		
		typeText("amazonsearchtextbox_name","harry potter");//name locator
		
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		clickElement("amazonsearch_xpath");
		
		
		//driver.findElement(By.linkText("The Girl in Room 105")).click();
		
		
	}

	

}
