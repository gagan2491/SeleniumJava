package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected static Properties properties;
	protected WebDriver driver;
	
	/*
	 * Surround with try catch block
	 */

	@BeforeSuite
	public void loadConfig() throws IOException {

		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"/Users/gagan/eclipse-workspace/OrangeHRM/src/main/resources/config.properties");
		properties.load(fileInputStream);
	}

	@BeforeMethod
	public void setup() throws IOException {

		System.out.println("Setting up WrbDriver for: " + this.getClass().getSimpleName());

		launchBrowser();
		configBrowser();
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

	private void launchBrowser() {

		String browser = properties.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Browser name is no defined" + browser);
		}
	}

	private void configBrowser() {

		int implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

		driver.manage().window().maximize();
		String applicationUrl = properties.getProperty("url");
		driver.get(applicationUrl);
	}
	
	public void staticWait(int seconds) {
		LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
