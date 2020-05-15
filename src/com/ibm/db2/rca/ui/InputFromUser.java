package com.ibm.db2.rca.ui;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import java.util.TimeZone;

public class InputFromUser 
{
	TimeZone timeZone = TimeZone.getTimeZone("Asia/Calcutta");
	
	private Date startDateTime = null;
	
	private Date endDateTime = null;
	
	private String schemaName = null;
	
	private String customerName = null; 
	


	public void validateUserInput() throws IllegalInputFromUserException
	{
		
		String errorMessage = "";
		
		if (this.startDateTime == null)
		{
			errorMessage = errorMessage + "Start Date Time input is missing.";
		}
		
		System.out.println("Input Start Time : " + this.startDateTime);
		
		if (this.endDateTime == null)
		{		
			errorMessage = errorMessage + "End Date Time input is missing.";
		}
		
		System.out.println("Input End Time : " + this.endDateTime);
		
		if (this.schemaName == null)
		{
			errorMessage = errorMessage + "Db Schema Name input missing.";
		}
		
		if(this.schemaName.trim().length() == 0)
		{
			errorMessage = errorMessage + "Db Schema Name input missing.";
		}
		
		if(errorMessage.trim().length() > 0)
		{
			throw (new IllegalInputFromUserException(errorMessage));
		}
		
	}

	public InputFromUser(HttpServletRequest request) 
	{

		this.startDateTime = new Date(Long.parseLong(request.getParameter("startTime")));
		
		this.endDateTime = new Date(Long.parseLong(request.getParameter("endTime")));
		
		this.schemaName = request.getParameter("connName");
		
		//System.out.println(this.startDateTime.toString() + this.endDateTime.toString() + this.monitoredDBConfiguredNameInPERFDB);

	}

	public InputFromUser(long startDateTime, long endDateTime, String schemaName) 
	{

		this.startDateTime = new Date(startDateTime);
		
		this.endDateTime = new Date(endDateTime);
		
		this.schemaName = schemaName;
		
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	

}
