package com.ibm.db2.rca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.jdbc.core.RowMapper;

public class ConfigurableRowMapper implements RowMapper 
{

		
		public ConfigurableRowMapper(Map<String, String> classPropertiesSqlColumnMapping, Class<?> objectClass)
		{
			this.classPropertiesSqlColumnMapping = classPropertiesSqlColumnMapping;
			
			this.objectClass = objectClass;
		}
		
		private Map<String, String> classPropertiesSqlColumnMapping = null;
		
		private Class<?> objectClass = null;

		@Override

		public Object mapRow(ResultSet rs, int line) throws SQLException 
		{			  
			  Object object = null;
			  
			  if(classPropertiesSqlColumnMapping != null)
			  {
				  Iterator<Entry<String, String>> itr = classPropertiesSqlColumnMapping.entrySet().iterator();
				  
				  Entry<String, String> entry = null; 
				  
				  String columnName = null;
				  
				  Object columnValue = null;
				  
				  String classPropertyName = null;
				  
				  BeanWrapper wrapper = null;

				  wrapper = new BeanWrapperImpl(this.objectClass);				
				  
				  Map<String,Object> map = new HashMap<String,Object>();

				  while(itr.hasNext())
				  {
					  entry = itr.next();
					  
					  columnName = entry.getKey();
					  
					  columnValue = rs.getObject(columnName);
					  
					  classPropertyName = entry.getValue();
					  
					  map.put(classPropertyName, columnValue);
				  }
				  
				  wrapper.setPropertyValues(map);
				  
				  object = wrapper.getWrappedInstance();

			  }
			  
			  return object;
			  
		  }
	
}