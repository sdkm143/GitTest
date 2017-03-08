package com.cts.changeimpact.dao;

public class ChangeImpactMsSQLSet implements ChangeImpactSQLSet {

	@Override
	public String orderby() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String groupby() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String limit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String where() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String and() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTCName() {
		// TODO Auto-generated method stub
		return "SELECT TC_Name val FROM tc_details WITH (NOLOCK) WHERE testcase_id = :id";
	}

}
