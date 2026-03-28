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
	
	//Method to click on an element
	
	public void click(By by) {
		
		try {
			waitForElementToBeClickable(by);
			driver.findElement(by).click();
		}
		catch(Exception e) {
			System.out.println("Unable to click element: " + e.getMessage());
		}
	}
	
	//Method to enter the text
	
	public void enterText(By by, String text) {
		
		try {
			waitForElementToBeVisible(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(text);
		}
		catch(Exception e) {
			System.out.println("Unable to enter text: " + e.getMessage());
		}
	}
	
	//Method to get the text value
	
	public String getText(By by) {
		
		try {
			waitForElementToBeVisible(by);
			return driver.findElement(by).getText();
		} catch (Exception e) {
			System.out.println("Unable to get text: " + e.getMessage());
			return null;
		}
	}
	
	// Method to compare 2 text
	
	public void compareText(By by, String expectedText) {
		
		try {
			waitForElementToBeVisible(by);
			String actualText = driver.findElement(by).getText();
			
			if(expectedText.equals(actualText)) {
				System.out.println("Texts are matching");
			} else
				System.out.println("Texts are not matching");
		} catch (Exception e) {
			System.out.println("Unable to compare the texts " + e.getMessage());
		}
	}
	
	// Method to check if an element id displayed
	
	public boolean isElementDisplayed(By by) {
		
		try {
			waitForElementToBeVisible(by);
			boolean isDisplayed = driver.findElement(by).isDisplayed();
			if(isDisplayed) {
				System.out.println("Element is displayed");
				return isDisplayed;
			}else
				return isDisplayed;
		} catch (Exception e) {
			System.out.println("Element is not displayed: " + e.getMessage());
			return false;
		}
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
	
	public void waitForElementToBeVisible(By by) {
		
		try {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(Exception e) {
			System.out.println("Element is not visible: " + e.getMessage());
		}
	}
	
}
