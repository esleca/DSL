package com.dsl.models.dtos;

public class ClassTestsRequest {
	
	private String packageName;
	private String className;
	
	public ClassTestsRequest(String packageName, String className) {
		this.packageName = packageName;
		this.className = className;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public String getClassName() {
		return className;
	}
}
