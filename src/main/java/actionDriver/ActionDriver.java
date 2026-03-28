package actionDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {

	private WebDriver driver;
	private WebDriverWait driverWait;
	
	/*
	 * Browser action
	 * Element finders
	 * Basic element actions
	 * Advanced user actions
	 * Wait until
	 * Drop down handling
	 * JE executor
	 * Alert handling
	 * Frames handling
	 * Window handling
	 * Screenshot handling
	 * Keyboard handling
	 */
	
	public ActionDriver(WebDriver driver) {
		
		this.driver = driver;
		new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	/*
	 * Javascript executor methods
	 */
	
	private JavascriptExecutor convertedDriverToJSE() {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor;
	}
	
	// Element click
	
	public void elementClick_JS(WebElement element) {
		
		convertedDriverToJSE().executeScript("arguments[0].click();", element);
	}
	
	// 
	
	
	public void waitForElementToBeClickable(By by) {
		
		try {
			driverWait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println("Element is no clickable" + e.getMessage());
		}
	}
	
}
