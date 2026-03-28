package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actionDriver.ActionDriver;
import base.BaseClass;

public class DummyTest extends BaseClass {
	
	@Test
	public void dummy() {
		
		WebElement link = driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
		new ActionDriver(driver).elementClick_JS(link);
		
		staticWait(5);
		
		
//		String actualTitle = driver.getTitle();
//		assert actualTitle.equalsIgnoreCase("OrangeHRM") : "Title assert failed";
		
		System.out.println("Test passed");
	}

}
