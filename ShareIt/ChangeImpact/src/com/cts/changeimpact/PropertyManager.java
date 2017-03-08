package com.cts.changeimpact;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.cts.changeimpact.NoFileException;
import com.cts.changeimpact.BaseException;

public class PropertyManager {

	private static HashMap<String, Properties> property = new HashMap<String, Properties>();

	public  static String getProperty(String key, String filepath) throws BaseException {
		//This method will return the property value associated with key and filepath
		Properties props = property.get(filepath);
		String value = null;
		
		if (props == null) {
			props = new Properties();
			props = loadProperties(filepath);			
			property.put(filepath, props);
		}
		value = props.getProperty(key);

		return value;
		
	}
	
	public static Properties loadPropertiesFromFile(String fileName) throws BaseException{
		Properties propertyList = null;
		
		try {
			propertyList = new Properties();
			propertyList.load(new FileInputStream(new File(fileName)));
		}catch (IOException e) {
			throw new NoFileException("While opening property file", e);
		}
		return propertyList;
	}
	
	//This method will load the property files
	public static Properties loadProperties(String fileName) throws BaseException{
		InputStream propertiesInputStream = null;
		Properties propertyList = null;
		
		try {
			propertiesInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			propertyList = new Properties();
			propertyList.load(propertiesInputStream);
		}catch (IOException e) {
			throw new NoFileException("While opening property file", e);
		}
		return propertyList;
	}



}
