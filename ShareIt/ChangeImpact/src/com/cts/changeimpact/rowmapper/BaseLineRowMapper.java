package com.cts.changeimpact.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.cts.changeimpact.vo.BaseLineVO;

public class BaseLineRowMapper implements ParameterizedRowMapper<BaseLineVO> {

	@Override
	public  BaseLineVO mapRow(ResultSet rs, int rownum) throws SQLException {
	// TODO Auto-generated method stub

        BaseLineVO  blvo =  new BaseLineVO();
        

        
//        blvo.setTestcase_id(rs.getString("testcase_id"));
//        blvo.setTc_name(rs.getString("TC_Name"));
        blvo.setTc_desc(rs.getString("TC_Desc"));
//        blvo.setSc_name(rs.getString("script_name"));
//        blvo.setProj_name(rs.getString("project"));
//        blvo.setCreatedby(rs.getString("createdby"));
//        blvo.setIs_auto(rs.getString("modified"));
//        blvo.setAutotech(rs.getString("autotech"));

    
 
       /* if (blvo.getIs_auto().equals("1")) {
               blvo.setIs_auto("Yes");
        } else {
               blvo.setIs_auto("No");
        }*/

return blvo;
 
 }
		

	

}
