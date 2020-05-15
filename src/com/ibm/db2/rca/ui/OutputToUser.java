package com.ibm.datatools.opm.rca.engine.ui;

import java.util.LinkedList;

import com.ibm.datatools.opm.rca.engine.LogTrace;

public class OutputToUser 
{
	private String status = "";
	
	private String rootCauseAnalysisResponseText = "";
	
	private LinkedList <Double> matricesValuesList = null;
	
	private LinkedList <String> matricesNameList = null;
	
	
	//private JSONArray matricesNameListJSONArray = null;
	
	private LogTrace traceLog = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRootCauseAnalysisResponseText() {
		return rootCauseAnalysisResponseText;
	}

	public void setRootCauseAnalysisResponseText(
			String rootCauseAnalysisResponseText) {
		this.rootCauseAnalysisResponseText = rootCauseAnalysisResponseText;
	}



	public LinkedList<Double> getMatricesValuesList() {
		return matricesValuesList;
	}

	public void setMatricesValuesList(LinkedList<Double> matricesValuesList) {
		this.matricesValuesList = matricesValuesList;
	}

	public LinkedList<String> getMatricesNameList() {
		return matricesNameList;
	}

	public void setMatricesNameList(LinkedList<String> matricesNameList) {
		this.matricesNameList = matricesNameList;
	}
	



/*	public JSONArray getMatricesNameListJSONArray() {
		return matricesNameListJSONArray;
	}

	public void setMatricesNameListJSONArray(JSONArray matricesNameListJSONArray) {
		this.matricesNameListJSONArray = matricesNameListJSONArray;
	}
*/
	public LogTrace getLogTrace() {
		return traceLog;
	}

	public void setLogTrace( LogTrace logTrace) {
		this.traceLog = logTrace;
	}
	

	
	
	
	
}
