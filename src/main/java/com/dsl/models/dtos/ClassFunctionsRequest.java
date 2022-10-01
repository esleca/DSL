package com.dsl.models.dtos;

public class ClassFunctionsRequest {

	private String classPath;
	private String language;
	
	public ClassFunctionsRequest(String classPath, String language) {
		this.classPath = classPath;
		this.language = language;
	}
	
	public String getClassPath() {
		return classPath;
	}
	
	public String getLanguage() {
		return language;
	}
}
