package com.cts.changeimpact.dao;

public interface ChangeImpactSQLSet {

	/*
	 * public abstract String getTcs();
	 */
	public abstract String orderby () ;
	public abstract String groupby () ;
	public abstract String limit () ;
	public abstract String where () ;
	public abstract String and () ;
	
	public abstract String getTCName();
}
