package com.resonance.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.resonance.utility.Keyword.*;

public class BaseFramework {

	public RemoteWebDriver driver; // static variable

	public static ThreadLocal<WebDriver> thread;

	@Before
	public void setup() {
		thread = new ThreadLocal<WebDriver>();
		String browser = null;
		Config conf = new Config();
		browser = conf.getBrowserName();
		if (browser == null) {
			throw new Error("Please specify browser name");
		}
		this.driver = openBrowser(browser);
		thread.set(this.driver);
		
		launchUrl(conf.getAppUrl());
	}

	@After
	public void tearDown() {
		thread.get().close();
		thread.remove();
	}

}
