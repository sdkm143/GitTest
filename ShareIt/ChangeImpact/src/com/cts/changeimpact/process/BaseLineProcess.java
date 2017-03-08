package com.cts.changeimpact.process;

import java.util.List;

import com.cts.changeimpact.BaseException;
import com.cts.changeimpact.dao.BaseLineDAO;
import com.cts.changeimpact.util.AppUtil;
import com.cts.changeimpact.vo.BaseLineVO;

public class BaseLineProcess {
	
	public static BaseLineProcess getBaseLineProcess() {
		return (BaseLineProcess) AppUtil.getappContext().getBean(
				"baselineprocessproxy");
	}
	
	public List<BaseLineVO> getTCName() throws BaseException {
		BaseLineDAO bldao = null;
		String tcName = "";
			
			bldao = BaseLineDAO.getBaseLineDAO(); 
			List<BaseLineVO> result =  bldao.getTCName();

			return result;
	
	}
	
	

}
