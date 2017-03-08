package com.cts.changeimpact.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.jdt.internal.compiler.apt.dispatch.BaseProcessingEnvImpl;
import org.json.JSONException;
import org.json.JSONObject;

import com.cts.changeimpact.BaseException;
import com.cts.changeimpact.process.BaseLineProcess;
import com.cts.changeimpact.vo.BaseLineVO;


@Path("/jsonServices")
public class JerseyRestService {

	@GET
    @Path("/getListValues/")
    @Produces(MediaType.APPLICATION_JSON)
 
    public  List<String> getRecords() {
		 
		List<String> srcFileAnalysisList = new ArrayList<String>() ;
		srcFileAnalysisList.add("new 1");
		srcFileAnalysisList.add("new 2");
		srcFileAnalysisList.add("new 3");
		srcFileAnalysisList.add("new 4");
		return srcFileAnalysisList;
	}

	@GET
    @Path("/getlongvalue/")
    @Produces(MediaType.APPLICATION_JSON)  
 
    public long getLongValue() {
		 
		long total = 999;
		return total;
	}
	
			
	@GET
    @Path("/getTestcaseName/")
    @Produces(MediaType.APPLICATION_JSON)
 
    public  JSONObject getStringValue() throws JSONException {
		JSONObject obj = new JSONObject();
//	List<String> l = new ArrayList<String>();
	List<BaseLineVO> tcTableResult = new ArrayList<BaseLineVO>();
		try {
			
			
			tcTableResult =  BaseLineProcess.getBaseLineProcess().getTCName();
				//System.out.println(tcTableResult);
			for(BaseLineVO r:tcTableResult){
				//System.out.println("jkfhjkahsjkfhjkash");
			
		        obj.put("testcase_id", r.getTestcase_id());
		        obj.put("TC_name", r.getTc_name());
		        obj.put("TC_desc", r.getTc_desc());
		        obj.put("script_name", r.getSc_name());
		        obj.put("project", r.getProj_name());
		        obj.put("createdBy", r.getCreatedby());
		        obj.put("modified", r.getIs_auto());
		        obj.put("autotech", r.getAutotech());
		        
				
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	
}
