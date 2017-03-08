/*
* Copyright Information © 2013, Cognizant Technology Solutions, All rights
* reserved.
* 
 * This document is protected by copyright. No part of this document may be
* reproduced in any form by any means without prior written authorization of
* Cognizant Technology Solutions and its licensors, if any.
*/


package com.cts.changeimpact.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class StringListRowMapper implements ParameterizedRowMapper<String>  {
	

	public String mapRow(ResultSet rs, int rowNum) throws SQLException {

		String temp = rs.getString("val");

		return temp;
	}



}
