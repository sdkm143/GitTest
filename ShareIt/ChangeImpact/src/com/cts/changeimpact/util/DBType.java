package com.cts.changeimpact.util;

import com.cts.changeimpact.dao.ChangeImpactSQLSet;

public class DBType {
	public static ChangeImpactSQLSet ChangeImpactSQLs=null;
	
	static {
		ChangeImpactSQLs=Util.CreateChangeImpactSQLSet();
	}
}
