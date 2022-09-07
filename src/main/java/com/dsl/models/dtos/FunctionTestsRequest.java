package com.dsl.models.dtos;

public class FunctionTestsRequest {
	
	private String packageName;
	private String className;
	private String functionName;

	public FunctionTestsRequest(String packageName, String className, String functionName) {
		this.packageName = packageName;
		this.className = className;
		this.functionName = functionName;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getFunctionName() {
		return functionName;
	}
}
