package com.dsl.models.language;

public class LanguageCode {

	private String language;
	private String generatedCode;
	
	public LanguageCode(String language, String generatedCode) {
		this.language = language;
		this.generatedCode = generatedCode;
	}
	
	public String getLanguage() {
		return language;
	}

	public String getGeneratedCode() {
		return generatedCode;
	}
	
}
