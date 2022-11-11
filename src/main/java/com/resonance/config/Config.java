package com.resonance.config;

import com.resonance.utility.PropUtil;

public class Config {

	private static final String filePath = System.getProperty("user.dir")+"/src/main/resources/application.properties";
	
	/**
	 * This method will return url mentioned in application.properties file
	 */
	public String getAppUrl() {
		return getProperty("app.url");
	}
	
	public String getBrowserName() {
		return getProperty("browsername");
	}
	
	private String getProperty(String property) {
		PropUtil prop=new PropUtil();
		return prop.getValue(filePath, property);
	}
	
	public String getAppUserName() {
		return getProperty("app.username");
	}
	
	public String getAppPassword() {
		return getProperty("app.password");
	}
}
