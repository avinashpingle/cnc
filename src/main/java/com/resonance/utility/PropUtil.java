package com.resonance.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class can be utilized for reading and writing the .properties files
 * @author avinashpingale
 *
 */
public class PropUtil {

	private static final Logger LOG = Logger.getLogger(PropUtil.class);
	/**
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 */
	public String getValue(String filePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			
			LOG.error("application.properties file not found");
		}
		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public String[] getLocator(String key) {
		String dir = System.getProperty("user.dir")+"/src/main/resources/OR.properties";
		String locator = getValue(dir, key);
		String[] parts = locator.split("##");
		return parts;
	}
	
}
