package com.cts.changeimpact.util;

import com.cts.changeimpact.BaseException;
import com.cts.changeimpact.ConConstants;
import com.cts.changeimpact.PropertyManager;
import com.cts.changeimpact.dao.ChangeImpactSQLSet;

public class Util {

	public static ChangeImpactSQLSet CreateChangeImpactSQLSet() {
		
		ChangeImpactSQLSet changeImpactUtil=null;
	    try {
	    	changeImpactUtil = (ChangeImpactSQLSet)Class.forName(PropertyManager.getProperty("changeimpactdbclass", ConConstants.DBTYPE_PATH)).newInstance();
				
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return changeImpactUtil;

	}
}
