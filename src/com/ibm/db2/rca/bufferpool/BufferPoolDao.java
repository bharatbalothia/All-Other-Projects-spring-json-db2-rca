package com.ibm.db2.rca.bufferpool;

import com.ibm.db2.rca.BaseDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public class BufferPoolDao extends BaseDaoImpl 
{
	Map <String,Object> daoMethods = null;	
	
	public Map<String, Object> getDaoMethods() 
	{
		return daoMethods;
	}

	public void setDaoMethods(Map<String, Object> daoMethods) 
	{
		this.daoMethods = daoMethods;
	}
	
	/**
	 * This method returns the list of BufferPool class objects 
	 * where Buffer Pool Hit Ratio is less than specified in properties file. 
	 * @param inputFromUser An object of InputFromUser
	 * @param monitoredDBProperties An object of MonitoredDBProperties 
	 * @return List of BufferPool Class objects
	 * @throws DataAccessException
	 * @throws ClassNotFoundException
	 */
	public List<BufferPool>selectWhereBufferPoolHitRatioIsLessThan(InputFromUser inputFromUser, MonitoredDBProperties monitoredDBProperties) throws DataAccessException, ClassNotFoundException
	{
		Map<String,Object> params = new HashMap<String,Object>();

		/*Following Local class definition is just put there to get the local function name within the function.*/
		class Local{};
		
		String methodName = Local.class.getEnclosingMethod().getName();
		
		Map<String, Object> methodBeanConfig = (Map<String, Object>) daoMethods.get(methodName);
		
		String sql = (String) methodBeanConfig.get("sql");
		
		sql = RootCauseAnalyzerDbUtil.applyInstanceAndAggregationLevelToQuery(sql, monitoredDBProperties);
		
		params.put("sql",sql);
		params.put("methodBeanConfig",methodBeanConfig);
		params.put("startDate", inputFromUser.getStartDateTime());
		params.put("endDate", inputFromUser.getEndDateTime());
		params.put("dbName", monitoredDBProperties.getMonitoredDbName());
		
		
		return (List<BufferPool>) super.select(params);		
	}
	
	

	public List getRowsReadVsRowsReturnedRatio(InputFromUser inputFromUser, MonitoredDBProperties monitoredDBProperties) throws DataAccessException, ClassNotFoundException
	{
		Map<String,Object> params = new HashMap<String,Object>();

		/*Following Local class definition is just put there to get the local function name within the function.*/
		class Local{};
		
		String methodName = Local.class.getEnclosingMethod().getName();
		
		Map<String, Object> methodBeanConfig = (Map<String, Object>) daoMethods.get(methodName);
		
		String sql = (String) methodBeanConfig.get("sql");
		
		sql = RootCauseAnalyzerDbUtil.applyInstanceAndAggregationLevelToQuery(sql, monitoredDBProperties);
		
		params.put("sql",sql);
		params.put("methodBeanConfig",methodBeanConfig);
		params.put("startDate", inputFromUser.getStartDateTime());
		params.put("endDate", inputFromUser.getEndDateTime());
		
		return super.selectRowsAsList(params);		
	}
	
	public double getMaxPercentageSumPoolReadTime(MonitoredDBProperties monitoredDBProperties, InputFromUser inputFromUser) throws Exception 
	{
	
		double maxPercentageSumPoolReadTime = 0.0;

		Map<String,Object> params = new HashMap<String,Object>();

		/*Following Local class definition is just put there to get the local function name within the function.*/
		class Local{};
		
		String methodName = Local.class.getEnclosingMethod().getName();
		
		Map<String, Object> methodBeanConfig = (Map<String, Object>) daoMethods.get(methodName);
		
		String sql = (String) methodBeanConfig.get("sql");
		
		sql = RootCauseAnalyzerDbUtil.applyInstanceAndAggregationLevelToQuery(sql, monitoredDBProperties);
		
		params.put("sql",sql);
		params.put("methodBeanConfig",methodBeanConfig);
		params.put("startDate", inputFromUser.getStartDateTime());
		params.put("endDate", inputFromUser.getEndDateTime());
		params.put("dbName", monitoredDBProperties.getMonitoredDbName());
		
		
		maxPercentageSumPoolReadTime = super.selectOneRowOneColumnDoubleValue(params);

		return maxPercentageSumPoolReadTime;
	}
	
	public double getMaxReadResponseTime(MonitoredDBProperties monitoredDBProperties, InputFromUser inputFromUser) throws Exception 
	{
	
		double maxReadResponseTime = 0.0;

		Map<String,Object> params = new HashMap<String,Object>();

		/*Following Local class definition is just put there to get the local function name within the function.*/
		class Local{};
		
		String methodName = Local.class.getEnclosingMethod().getName();
		
		Map<String, Object> methodBeanConfig = (Map<String, Object>) daoMethods.get(methodName);
		
		String sql = (String) methodBeanConfig.get("sql");
		
		sql = RootCauseAnalyzerDbUtil.applyInstanceAndAggregationLevelToQuery(sql, monitoredDBProperties);
		
		params.put("sql",sql);
		params.put("methodBeanConfig",methodBeanConfig);
		params.put("startDate", inputFromUser.getStartDateTime());
		params.put("endDate", inputFromUser.getEndDateTime());
		params.put("dbName", monitoredDBProperties.getMonitoredDbName());
				
		maxReadResponseTime = super.selectOneRowOneColumnDoubleValue(params);

		return maxReadResponseTime;
	}

}