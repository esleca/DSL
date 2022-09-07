package com.dsl.models.database;

import org.json.simple.JSONArray;
import com.dsl.models.valuetypes.ValueType;

public class UnitTestMetaData {
	
	private String classPath; // required by mapper
    private String language;  // required by mapper
    private String outputPath; // required by printer
	private String function;
    private String testName;
    private JSONArray parameters;
    private ValueType expected;
    private String assertion;
    
	public UnitTestMetaData(String classPath, String language, String outputPath, String function, String testName,
			JSONArray parameters, ValueType expected, String assertion) {
		this.classPath = classPath;
		this.language = language;
		this.outputPath = outputPath;
		this.function = function;
		this.testName = testName;
		this.parameters = parameters;
		this.expected = expected;
		this.assertion = assertion;
	}

	public String getClassPath() {
		return classPath;
	}

	public String getLanguage() {
		return language;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public String getFunction() {
		return function;
	}

	public String getTestName() {
		return testName;
	}

	public JSONArray getParameters() {
		return parameters;
	}

	public ValueType getExpected() {
		return expected;
	}

	public String getAssertion() {
		return assertion;
	}
    
}
