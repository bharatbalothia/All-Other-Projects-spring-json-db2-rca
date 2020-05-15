package com.ibm.db2.rca;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;




public abstract class BaseDaoImpl<DataSource> implements BaseDao 
{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	public void setDataSource(javax.sql.DataSource dataSource) 
	{
		 this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}


	public List<?> select(Map<String,Object> params) throws DataAccessException, ClassNotFoundException 
	{
		String sql = null;
		
		Map<String, Object>  methodBeanConfig = (Map<String, Object>) params.get("methodBeanConfig");
		
		sql = (String) params.get("sql");
		
		List<String> sqlParams = (List<String>) methodBeanConfig.get("sqlParams");
		
		String classNameOfObjectsReturned = (String) methodBeanConfig.get("classNameOfObjectsReturned"); 
		
		Map<String, String> classPropertiesSqlColumnMapping = (Map<String, String>) methodBeanConfig.get("classPropertiesSqlColumnMapping"); 

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		for(String sqlParamName : sqlParams)
		{
			namedParameters.addValue(sqlParamName, params.get(sqlParamName));			
		}
			
		return this.namedParameterJdbcTemplate.query(sql, namedParameters, new ConfigurableRowMapper(classPropertiesSqlColumnMapping, Class.forName(classNameOfObjectsReturned)));

	}
	
	
	public List<?> selectRowsAsList(Map<String,Object> params) throws DataAccessException, ClassNotFoundException 
	{
		String sql = null;
		
		Map<String, Object>  methodBeanConfig = (Map<String, Object>) params.get("methodBeanConfig");
		
		sql = (String) params.get("sql");
		
		List<String> sqlParams = (List<String>) methodBeanConfig.get("sqlParams");
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		for(String sqlParamName : sqlParams)
		{
			namedParameters.addValue(sqlParamName, params.get(sqlParamName));			
		}
			
		return this.namedParameterJdbcTemplate.queryForList(sql, namedParameters);

	}
	
	public double selectOneRowOneColumnDoubleValue(Map<String,Object> params) throws DataAccessException, ClassNotFoundException 
	{
		String sql = null;
		
		Map<String, Object>  methodBeanConfig = (Map<String, Object>) params.get("methodBeanConfig");
		
		sql = (String) params.get("sql");
		
		List<String> sqlParams = (List<String>) methodBeanConfig.get("sqlParams");
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		for(String sqlParamName : sqlParams)
		{
			namedParameters.addValue(sqlParamName, params.get(sqlParamName));			
		}
			
		return (Double)this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Double.class);

	}


}