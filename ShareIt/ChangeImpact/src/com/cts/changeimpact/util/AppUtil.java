package com.cts.changeimpact.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppUtil {

	// cache aplication factory
	private static ClassPathXmlApplicationContext ctx = null;
	
	/**
	 * Method to get application factory. if other base classes want to load
	 * different application factory, need to overwrite this
	 * 
	 * @return
	 */
	public static ClassPathXmlApplicationContext getappContext() {

		if (ctx == null) {
			/*if (logger.isDebugEnabled()) {
			logger.debug("Creating new context");
			}*/
			ctx = new ClassPathXmlApplicationContext("applicationContextChangeImpact.xml");
		}
		//logger.debug("Created new context");
		return ctx;
	}


}
