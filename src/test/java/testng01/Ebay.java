package testng01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ebay extends Baseclass {
	
@Test
private void Brower() throws Exception {
	initDriver("Chrome");
	Thread.sleep(3000);
	getUrl("https://www.ebay.com/");
	
	Thread.sleep(3000);
	  WebElement sr = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
	sendKeys(sr," iphone");
}
		
		
		
		
		
	}

	

