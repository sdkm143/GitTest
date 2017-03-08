package com.cts.changeimpact.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


import com.cts.changeimpact.ConUtil;
//import com.cts.alite.ConUtil;
import com.cts.changeimpact.util.DBType;


public class BaseDAO extends DBType {
	
	
	private SimpleJdbcTemplate jdbcTemplate;

		
		public SimpleJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	
	protected String prepareQuery(List<String> inlist, List<String> fields) {
		StringBuffer sb = new StringBuffer();
		
		for(String fld:fields) {
			for (String str:inlist) {
				sb.append(fld);
				sb.append("'%");
				sb.append(str);
				sb.append("%'");
			}
		}
		
		return sb.toString();
	}
	
	

	
	
	
	/*protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}*/
	
	


	public HashMap<String, String> getJoinFilter(Map<String, String> filters){
		
		/*if (logger.isDebugEnabled()) {
			logger.debug("Inside getJoinFilter");
		}*/
		HashMap<String, String> joinFilter = new HashMap<String, String>();
		
		if(filters != null && !filters.isEmpty()){
			for(String key : filters.keySet()){
				joinFilter.put(key, key);
			}
		}
		return joinFilter;
	}
	
	public String prepareQueryForPaginationMySql(String query, int first, int pageSize, String sortField, String sortOrder, Map<String, String> filters,HashMap<String, String> joinFilter, String defaultSortField){
		return prepareQueryForPaginationMySql(query, first, pageSize, sortField, sortOrder,filters,joinFilter,defaultSortField, null);
	}
	public String prepareQueryForPaginationMySql(String query, int first, int pageSize, String sortField, String sortOrder, Map<String, String> filters,HashMap<String, String> joinFilter,String defaultSortField, String groupby){
			
		/*if (logger.isDebugEnabled()) {
			logger.debug("Inside prepareQueryForPagination");
		}*/
		StringBuffer sb = new StringBuffer(query);
		
		if(filters != null && !filters.isEmpty()){
			
			if(query.toUpperCase().indexOf(ChangeImpactSQLs.where()) == -1 ) {
				sb.append(ChangeImpactSQLs.where());
			}else {
				sb.append(ChangeImpactSQLs.and());
			}
			
			sb.append(addfilter(filters,joinFilter));
		}
		
		
		if(groupby != null) {
			sb.append(ChangeImpactSQLs.groupby());
			if(!joinFilter.isEmpty()){
				if(joinFilter.get(groupby) == null){
					sb.append(groupby);
				}else{
					sb.append(joinFilter.get(groupby));
				}
			}else{
				sb.append(groupby);
			}
			
		}
		
		sb.append(ChangeImpactSQLs.orderby());
		
		if(sortField !=null && !sortField.equals("")){
			if(!joinFilter.isEmpty()){
				
				if(joinFilter.get(sortField) != null){
					
					sb.append(joinFilter.get(sortField));
					
				}else{
					
					sb.append(sortField);
				}
			}else{
				
				sb.append(sortField);
			}
				
		}else{
			
			sb.append(" "+defaultSortField+" ");
		}
			
		if(sortOrder!=null){
			
			if(sortOrder.equals("DESCENDING")){
				sb.append(" ").append("DESC");
			}else{
				sb.append(" ").append("ASC");
			}
		}
		
		sb.append(" ").append(ChangeImpactSQLs.limit()).append(first).append(",").append(pageSize);
		
		return sb.toString();
	}
	
	
	public String prepareQueryForPagination(String query, int first, int pageSize, String sortField, String sortOrder, Map<String, String> filters,HashMap<String, String> joinFilter, String defaultSortField){
		
		String query1=null;
		
		if(ConUtil.checkContainValue(ChangeImpactSQLs.toString(), "MySQL"))
		{
			query1=prepareQueryForPaginationMySql(query,first, pageSize,  sortField,  sortOrder,  filters, joinFilter,  defaultSortField,null);
		}if(ConUtil.checkContainValue(ChangeImpactSQLs.toString(), "MsSQL"))
		{
			query1=prepareQueryForPaginationMSSql(query,first, pageSize,  sortField,  sortOrder,  filters, joinFilter,  defaultSortField,null);
		}
		
		return query1;
		
	}
	
	public String prepareQueryForPagination(String query, int first, int pageSize, String sortField, String sortOrder, Map<String, String> filters,HashMap<String, String> joinFilter, String defaultSortField,String groupby){
		
		String query1=null;
			
			if(ConUtil.checkContainValue(ChangeImpactSQLs.toString(), "MySQL"))
			{
				query1=prepareQueryForPaginationMySql(query,first, pageSize,  sortField,  sortOrder,  filters, joinFilter,  defaultSortField,groupby);
			}if(ConUtil.checkContainValue(ChangeImpactSQLs.toString(), "MsSQL"))
			{
				query1=prepareQueryForPaginationMSSql(query,first, pageSize,  sortField,  sortOrder,  filters, joinFilter,  defaultSortField,groupby);
			}
			return query1;
		}
	
	
	private String prepareQueryForPaginationMSSql(String query, int first,
			int pageSize, String sortField, String sortOrder,
			Map<String, String> filters, HashMap<String, String> joinFilter,
			String defaultSortField, String groupby) {
	

		StringBuffer sb = new StringBuffer();
		StringBuffer strngbuff  = new StringBuffer();
		String[] qsplit=null;
		
		
		strngbuff.append("select * from (select ROW_NUMBER() over (ORDER BY ");
		
		
		
		
		if(sortField !=null && !sortField.equals("")){
			if(!joinFilter.isEmpty()){
				
				if(joinFilter.get(sortField) != null){
					strngbuff.append(joinFilter.get(sortField));
					
					
					
				}else{
					strngbuff.append(sortField);
					
				}
			}else{
				
				strngbuff.append(sortField);
			}
				
		}else{
			
			if(defaultSortField != null && !defaultSortField.isEmpty())
			{
				strngbuff.append(defaultSortField);
			}else{
				qsplit = query.split(",");
				if(qsplit[0] != null && !qsplit[0].isEmpty()){
					if(qsplit[0].contains("distinct")){
						strngbuff.append(qsplit[0].split("")[2]); // if distinct is specified in the query
					}else{
						strngbuff.append(qsplit[0].split("")[1]);
					}
				}
				
			}
		}
		
	if(sortOrder!=null){
			
			if(sortOrder.equals("DESCENDING")){
				strngbuff.append(" ").append(" DESC ");
			}else{
				strngbuff.append(" ").append(" ASC ");
			}
		}
		
		
		
		strngbuff.append(" ) as rownum,*  from (select * from ( ");
		strngbuff.append(query);
		
		
		sb.append(strngbuff );
		
		if(filters != null && !filters.isEmpty()){
			
			if(query.toUpperCase().indexOf(ChangeImpactSQLs.where()) == -1 ) {
				sb.append(ChangeImpactSQLs.where());
			}else {
				sb.append(ChangeImpactSQLs.and());
			}
			
			sb.append(addfilter(filters,joinFilter));
		}
		
		if(groupby != null) {
			sb.append(ChangeImpactSQLs.groupby());
			if(!joinFilter.isEmpty()){
				
				if(joinFilter.get(groupby) == null){
					sb.append(groupby);
				}else{
					sb.append(joinFilter.get(groupby));
				}
			}else{
				sb.append(groupby);
			}
			
		}
		
				sb.append(")as t )as t2  )t3 where ");
				sb.append(" rownum between ");
				sb.append(first + 1);
				sb.append(" and ");
				sb.append(first + pageSize);

			 
		
		  return sb.toString();
				
		
	}
	
	public String appendfilter(String query, Map<String, String> filters, HashMap<String, String> joinFilter){
		
		
		/*if (logger.isDebugEnabled()) {
			logger.debug("Inside appendfilter");
		}*/
		StringBuffer sb = new StringBuffer(query);
		String filter = addfilter(filters, joinFilter);
		
		if(!filter.isEmpty()) {
			if(query.toUpperCase().indexOf(ChangeImpactSQLs.where()) == -1 ) {
				sb.append(ChangeImpactSQLs.where());
			}else {
				sb.append(ChangeImpactSQLs.and());
			}
			
			sb.append(filter);
		}
		
		return sb.toString();
	}
	
	protected String addfilter(Map<String, String> filters, HashMap<String, String> joinFilter){
		
		
		/*if (logger.isDebugEnabled()) {
			logger.debug("Inside addfilter");
		}*/
		StringBuffer sbFilter = null;
		
		
			sbFilter = new StringBuffer(" ");
			
			for(String field : filters.keySet()){
				
				if(joinFilter.get(field) == null) {
					sbFilter.append(field+" like ");
				}else {
					sbFilter.append(joinFilter.get(field)+" like ");
				}
				
				sbFilter.append("'%");
				sbFilter.append(filters.get(field).replaceAll("'", "''"));
				sbFilter.append("%' AND ");
			}
			
			if(sbFilter.toString().trim().isEmpty()) {
				return "";
			}else {
				return sbFilter.toString().substring(0, sbFilter.toString().length()-4);
			}
		
	}
	
	public void prepareIn(ArrayList<String> inparam, String key, String fix) {
		
		StringBuffer sb = new StringBuffer();
		String temp = null;
		String []sk = null;

		sb.append(fix);
		sb.append(key);
		sb.append(fix);
		
		if(inparam.size()>0) {
			temp = inparam.get(inparam.size()-1);
			sk  =temp.split(",");
			
			if (sk.length<49) {
				inparam.set(inparam.size()-1, temp+","+sb.toString());
			}else {
				inparam.add(sb.toString());
			}
		}else {
			inparam.add(sb.toString());
		}
	}
	


}
