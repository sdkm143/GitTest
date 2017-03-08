/*
* Copyright Information © 2013, Cognizant Technology Solutions, All rights
* reserved.
* 
 * This document is protected by copyright. No part of this document may be
* reproduced in any form by any means without prior written authorization of
* Cognizant Technology Solutions and its licensors, if any.
*/




package com.cts.changeimpact;


public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7576338595684000786L;

	public BaseException(String msg, Throwable ex) {
		super(ex);
		
		if (ex != null) {
		ex.printStackTrace();
			
		}
		
	}
	
	public BaseException(String msg, Throwable ex, boolean showTrace) {
		super(ex);
		
		if (ex != null && showTrace) {
		ex.printStackTrace();
			
		}
		
	}
	
	public BaseException(Throwable ex) {
		super(ex);
		
		if (ex != null) {
			//ex.printStackTrace();
			
		}
		
	}

	/* User Mgmt & Auth */
	public BaseException(String msg) {
		super(msg);
		
	}
	/* User Mgmt & Auth */
}
