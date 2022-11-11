package com.resonance.utility;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Akshata
 *
 */
public class Keyword {
	public static RemoteWebDriver driver;
	private static WebDriverWait wait;
	private static final Logger LOG = Logger.getLogger(Keyword.class);

	/**
	 * This method will launch specified browser in maximised mode
	 * 
	 * @param browserName must be one of the following
	 *                    <ul>
	 *                    <li>Chrome</li>
	 *                    <li>Firefox</li>
	 *                    <li>Safari</li>
	 *                    </ul>
	 */
	public static RemoteWebDriver openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			LOG.error("Invalid browser name: " + browserName);
		}
		LOG.info(browserName + " is launched successfully");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return driver;
	}

	/**
	 * This method will launch the specified url in currently opened browser window
	 * 
	 * @param url
	 */
	public static void launchUrl(String url) {
		driver.get(url);
		LOG.info("Url is launched successfully");
	}

	/**
	 * This method will click on element described by {@code locatorType} and
	 * {@code locatorValue}
	 * 
	 * @param locatorType  must be one of the following:
	 *                     <ul>
	 *                     <li>xpath</li>
	 *                     <li>css</li>
	 *                     <li>id</li>
	 *                     <li>class</li>
	 *                     <li>name</li>
	 *                     </ul>
	 * @param locatorValue
	 */
	@Deprecated
	public static void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public static void click(String locator) {
		String[] parts = locator.split("##");
		getWebElement(parts[0], parts[1]).click();
	}
	public static void click(By by) {
		driver.findElement(by).click();
	}
	@Deprecated
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void enterText(String locator, String textToEnter) {
		String[] parts = locator.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}

	
	private static WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else {
			System.err.println("Invalid locator type: " + locatorType);
			return null;
		}
	}
	/**
	 * 
	 * @param duration is in milliseconds
	 */
	public static void waitFor(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPresenceOfElement(WebElement element) {
		//Logic
	}
}
