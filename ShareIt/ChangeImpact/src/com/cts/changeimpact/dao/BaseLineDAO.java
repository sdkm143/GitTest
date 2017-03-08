package com.cts.changeimpact.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.changeimpact.rowmapper.BaseLineRowMapper;
import com.cts.changeimpact.util.AppUtil;
import com.cts.changeimpact.vo.BaseLineVO;

public class BaseLineDAO extends BaseDAO {


	public static BaseLineDAO getBaseLineDAO() {
		return (BaseLineDAO) AppUtil.getappContext().getBean(
				"baselineDao");
	}
	
	public List<BaseLineVO> getTCName() {
		Map<String, Object> mp = null;

		mp = new HashMap<String, Object>();
		//mp.put("id", 1);
		
			
		
		
		List<BaseLineVO> result= getJdbcTemplate().query(ChangeImpactSQLs.getTCName(), new BaseLineRowMapper());
		
		return result;
	}
}
